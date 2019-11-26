package de.FirstMove.demo.controller;

import de.FirstMove.demo.entity.User;
import de.FirstMove.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(
            path = "/person",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public User getuser ()
    {
        /*List<Integer> test = new ArrayList<Integer>();
        test.add(4);
        test.add(20);*/
        User b_user = new User();
        //b_user.setPreferences(test);
        b_user.setName("Martin");
        b_user.setSurname("Doof");
        b_user.setCity("Aachen");

        User user = new User(b_user.getName(),b_user.getSurname(),b_user.getCity());
        return user;
    }

    public List<User> getUserList(){

        List<User> userList = userRepository.findAll();
        return userList;
    }

    @PostMapping(
            path = "/person",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE

    )
    public User saveUser(@RequestBody User user){

        return userRepository.save(user);
    }

}
