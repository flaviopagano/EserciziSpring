package co.develhope.redisCache.services;

import co.develhope.redisCache.entities.User;
import co.develhope.redisCache.entities.jpa.UserJPA;
import co.develhope.redisCache.entities.redis.UserRedis;
import co.develhope.redisCache.repositories.jpa.UserRepositoryJPA;
import co.develhope.redisCache.repositories.redis.UserRepositoryRedis;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    @Autowired
    private UserRepositoryRedis userRepositoryRedis;

    /**
     *  Utility per convertire da
     *  UserJPA a UserRedis
     *  la proprietà BeanUtils copierà tutti i field di UserJPA
     */
    public UserRedis convertData(UserJPA user){
        UserRedis userRedis = new UserRedis();
        BeanUtils.copyProperties(user, userRedis);
        return userRedis;
    }

    public UserJPA convertData(UserRedis user){
        UserJPA userRedis = new UserJPA();
        BeanUtils.copyProperties(user, userRedis);
        return userRedis;
    }

    public UserJPA create(UserJPA user) {
        if(user == null) return null;
        user.setId(null);
        return userRepositoryJPA.save(user);
    }

    public List<UserJPA> readAll() {
        return userRepositoryJPA.findAll();
    }

    /**
     * @param id    ID UserJPA
     * @return  metodo che ritorna
     *          uno UserJPA che cerca lo user sia nella cache redis
     *          sia nel DB
     */
    public UserJPA readOne(Long id) {
        Optional<UserRedis> userRedis = userRepositoryRedis.findById(id);
        if(userRedis.isPresent()){
            return convertData(userRedis.get());
        }else {
            UserJPA userFromDB = userRepositoryJPA.getById(id);
            if (userFromDB == null ) return null;
            userRepositoryRedis.save(convertData(userFromDB));
            return userFromDB;
        }
    }

    public UserJPA update(Long id, UserJPA user) {
        if(user == null) return null;
        user.setId(id);
        UserJPA newUser = userRepositoryJPA.save(user);

        Optional<UserRedis> userRedis = userRepositoryRedis.findById(id);
        if(userRedis.isPresent()) {
            //userRepositoryRedis.deleteById(id); // FASTER update - SLOWER read
            userRepositoryRedis.save(convertData(newUser)); // SLOWER update - FASTER read
        }

        return user;
    }

    /**
     *         Metodo per cancellare lo user sia dalla repo sia dalla cache
     */
    public void delete(Long id) {
        userRepositoryJPA.deleteById(id);
        userRepositoryRedis.deleteById(id);
    }
}
