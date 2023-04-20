package co.develhope.redisCache.controllers;

import co.develhope.redisCache.entities.User;
import co.develhope.redisCache.entities.jpa.UserJPA;
import co.develhope.redisCache.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**     Metodo per creare lo UserJPA
     *      CREATE
     */
    @PostMapping()
    public UserJPA create(@RequestBody UserJPA user){
        return userService.create(user);
    }


    /**     Metodo per leggere lo UserJPA, torna una lista di utenti
    *       READ
    */
    @GetMapping()
    public List<UserJPA> readAll(){
        return userService.readAll();
    }

    /**     Metodo per leggere solo un singolo UserJPA tramite ID
     *      READ
     */
    @GetMapping("/{id}")
    public UserJPA readOne(@PathVariable Long id){
        return userService.readOne(id);
    }


//     /**    Metodo per leggere lo UserJPA
//      *     READ
//      */
//    @GetMapping("/{id}/fast")
//    public void readOneFast(@PathVariable Long id){
//        userService.readOneFast(id);
//    }

    /**
     *      Metodo che ritorna un utente UserJPA con i parametri modificati
     *      UPDATE
     */
    @PutMapping("/{id}")
    public UserJPA update(@PathVariable Long id, @RequestBody UserJPA user){
        return userService.update(id, user);
    }

    /**
     *      Metodo che utilizza l'ID per identificare lo User ed eliminarlo
     *      DELETE
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
