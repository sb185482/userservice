package com.datanauts.rest.dao;

import org.springframework.stereotype.Repository;

import com.datanauts.rest.model.User;
import com.datanauts.rest.model.Users;

@Repository
public class UserDAO 
{
    private static Users list = new Users();
    
    static 
    {
        list.getUserList().add(new User(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
        list.getUserList().add(new User(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
        list.getUserList().add(new User(3, "David", "Kameron", "titanic@gmail.com"));
    }
    
    public Users getAllUsers() 
    {
        return list;
    }
    
    public void addUser(User user) {
        list.getUserList().add(user);
    }
}
