package com.contact.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.contact.app.Models.User;

public interface UserRepository extends JpaRepository<User, String>{
    
}
