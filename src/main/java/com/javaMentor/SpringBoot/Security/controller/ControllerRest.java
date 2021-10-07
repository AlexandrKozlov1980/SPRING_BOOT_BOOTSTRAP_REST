package com.javaMentor.SpringBoot.Security.controller;

import com.javaMentor.SpringBoot.Security.model.Role;
import com.javaMentor.SpringBoot.Security.model.User;
import com.javaMentor.SpringBoot.Security.service.RoleService;
import com.javaMentor.SpringBoot.Security.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerRest {

    private final UserService userService;
    private final RoleService roleService;

    public ControllerRest(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public ResponseEntity<List<User>> showAllUsers(){
        return new ResponseEntity<>(userService.showAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/admin/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(new ArrayList<>(roleService.allRoles()), HttpStatus.OK);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<User> showUser(@PathVariable("id") Integer id){
        return new ResponseEntity<>(userService.showUser(id), HttpStatus.OK);
    }

    @PostMapping("/admin")
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<User> delete(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/admin")
    public ResponseEntity<User> update(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
