package com.datanauts.rest.controller;

import java.net.URI;
import java.util.logging.Logger;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.datanauts.rest.dao.UserDAO;
import com.datanauts.rest.model.User;
import com.datanauts.rest.model.Users;


@RestController
@RequestMapping(path = "/users")
public class UserController 
{
	private static Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserDAO userDao;
    
    @GetMapping(path="", produces = "application/json")
    public Users getUsers() 
    {
    	logger.info("getUsers()");
        return userDao.getAllUsers();
    }
    
    @GetMapping(path="/{userId}", produces = "application/json")
    public User getUserByUserId(@PathVariable @NotNull @DecimalMin("0") Integer userId) 
    {
    	logger.info("getUserByUserId(" + userId + ")");
        return userDao.getUserByUserId(userId);
    }
    
    @DeleteMapping(path="/{userId}", produces = "application/json")
    public Boolean deleteUserByUserId(@PathVariable @NotNull @DecimalMin("0") Integer userId) 
    {
    	logger.info("deleteUserByUserId(" + userId + ")");
        return userDao.deleteUserByUserId(userId);
    }
    
    @PostMapping(path= "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addUser(
                        @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
                        @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "UK") String headerLocation,
                        @RequestBody User user) 
                 throws Exception 
    {       
        //Generate resource id
        Integer id = userDao.getAllUsers().getUserList().size() + 1;
        user.setUserId(id);
        
        logger.info("addUser(" + user.toString() + ")");
        
        //add resource
        userDao.addUser(user);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(user.getUserId())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
