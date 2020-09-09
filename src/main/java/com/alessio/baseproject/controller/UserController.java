package com.alessio.baseproject.controller;

import com.alessio.baseproject.database.sql.dao.UserDao;
import com.alessio.baseproject.database.sql.dao.model.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping({"","/"})
    public String helloWorld(){
        return "hello world";
    }

    @PostMapping("/insert")
    public UserDto insert(@RequestBody UserDto userDto){
        return userDao.insert(userDto);
    }

    @GetMapping("/find-all")
    public List<UserDto> findAll(){
        return userDao.findAll();
    }
}
