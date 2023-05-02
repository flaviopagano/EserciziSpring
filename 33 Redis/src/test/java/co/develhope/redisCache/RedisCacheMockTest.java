package co.develhope.redisCache;

import co.develhope.redisCache.entities.User;
import co.develhope.redisCache.entities.jpa.UserJPA;
import co.develhope.redisCache.entities.redis.UserRedis;
import co.develhope.redisCache.repositories.jpa.UserRepositoryJPA;
import co.develhope.redisCache.repositories.redis.UserRepositoryRedis;
import co.develhope.redisCache.services.UserService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisCacheMock.class)
public class RedisCacheMockTest {

    @Autowired
    private UserRepositoryRedis userRepositoryRedis;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    @Test
    public void shouldWriteOnRedisCache(){
        UserRedis userRedis = new UserRedis();
        userRedis.setId(1L);
        userRedis.setFirstName("Flavio");
        userRedis.setLastName("Pagano");
        userRedis.setProfilePicture("00000.jpg");
        userRedis.setEmail("email@email.com");
        userRedis.setPasswordEncrypted("password");
        userRedis.setDomicileAddress("Via Roma");
        userRedis.setDomicileCity("Roma");
        userRedis.setDomicileNumber("10");
        userRedis.setDomicileState("Italy");
        userRedis.setFiscalCode("AAA000111");


        UserRedis userSavedInRedisCache = userRepositoryRedis.save(userRedis);

        Assertions.assertNotNull(userSavedInRedisCache);
    }

    @Test
    public void shouldCreateUser(){
        UserJPA userJPA = new UserJPA();
        userJPA.setId(1L);
        userJPA.setFirstName("Flavio");
        userJPA.setLastName("Pagano");
        userJPA.setProfilePicture("00000.jpg");
        userJPA.setEmail("email@email.com");
        userJPA.setPasswordEncrypted("password");
        userJPA.setDomicileAddress("Via Roma");
        userJPA.setDomicileCity("Roma");
        userJPA.setDomicileNumber("10");
        userJPA.setDomicileState("Italy");
        userJPA.setFiscalCode("AAA000111");

        UserJPA userSavedInDB = userRepositoryJPA.save(userJPA);

        Assertions.assertNotNull(userSavedInDB);
    }

    @Test
    public void shouldGetUserFromCache(){
        //userService.readOne()
    }

    @Test
    public void shouldDeleteUser(){
        //userService.delete();
    }

    @Test
    public void shouldUpdateUser(){
        //userService.update();
    }
}
