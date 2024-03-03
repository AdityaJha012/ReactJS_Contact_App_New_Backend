package com.contact.app.Controllers;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.contact.app.Models.User;
import com.contact.app.Repositories.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/rest")
public class UserController {
    
    @Autowired UserRepository userRepository;

    @CrossOrigin
    @GetMapping("/fetchContactDetails")
    public List<User> fetchContactDetails() {
        List<User> userList = this.userRepository.findAll();
        return userList;
    }

    @CrossOrigin
    @PostMapping("/addContactDetails")
    public User addContactDetails(@RequestBody User user) {
        user.setValidFlag("Y");
        user.setCreatedBy("AKJ1");
        user.setCreationDate(new Timestamp(System.currentTimeMillis()));
        User saveUser = this.userRepository.save(user);
        return saveUser;
    }    
    
}
