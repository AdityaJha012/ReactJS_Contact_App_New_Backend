package com.contact.app.Controllers;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.contact.app.Models.User;
import com.contact.app.Repositories.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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

    @CrossOrigin
    @DeleteMapping("/deleteContactDetails/{userId}")
    public String deleteContactDetails(@PathVariable("userId") String userId) {
        User user = this.userRepository.findById(userId).get();
        user.setValidFlag("N");
        user.setUpdatedBy("AKJ2");
        user.setUpdationDate(new Timestamp(System.currentTimeMillis()));
        this.userRepository.save(user);
        return "Contact Details Deleted Successfully!";
    }

    @CrossOrigin
    @PutMapping("restoreContactDetails/{userId}")
    public String restoreContactDetails(@PathVariable("userId") String userId) {
        User user = this.userRepository.findById(userId).get();
        user.setValidFlag("Y");
        user.setUpdatedBy("AKJ3");
        user.setUpdationDate(new Timestamp(System.currentTimeMillis()));
        this.userRepository.save(user);
        return "Contact Details Restored Successfully!";
    }
}
