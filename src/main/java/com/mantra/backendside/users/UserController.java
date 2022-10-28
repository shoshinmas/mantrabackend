package com.mantra.backendside.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.mantra.backendside.users.Users;
import org.springframework.web.bind.annotation.*;

@RestController

@CrossOrigin(origins="*")
public class UserController {
    @Autowired
    private UserService services;

    @GetMapping("/getall")
    public Iterable<Users>getUsers()
    {
        return services.listAll();
    }

    @PostMapping(value = "/save")
    private long saveTodo(@RequestBody Users users)
    {
        services.saveOrUpdate(users);
        return  users.getId();
    }

    @RequestMapping("/user/{id}")
    private Users getTodos(@PathVariable(name = "id") int userId)
    {
        return services.getUserById(userId);
    }

    @PutMapping("/edit/{id}")

    private Users update(@RequestBody Users users)
    {
        services.saveOrUpdate(users);
        return users;
    }

    @DeleteMapping("/delete/{id}")
    private void deleteUser(@PathVariable("id") int id)
    {
        services.delete(id);
    }

}
