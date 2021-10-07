package com.javaMentor.SpringBoot.Security.config;

import com.javaMentor.SpringBoot.Security.model.Role;
import com.javaMentor.SpringBoot.Security.model.User;
import com.javaMentor.SpringBoot.Security.service.RoleService;
import com.javaMentor.SpringBoot.Security.service.UserService;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class PostConstructor {

    private final UserService userService;
    private final RoleService roleService;

    public PostConstructor(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void createUsers(){

        Role roleAdmin = new Role("ROLE_ADMIN");
        roleService.saveRole(roleAdmin);
        Set<Role> roleAdminSet = new HashSet<>();
        roleAdminSet.add(roleAdmin);

        Role roleUser = new Role("ROLE_USER");
        roleService.saveRole(roleUser);
        Set<Role> roleUserSet = new HashSet<>();
        roleUserSet.add(roleUser);

        userService.createUser(new User("admin", "adminLastName", 31, "admin@mail.ru", "0", roleAdminSet));
        userService.createUser(new User("user", "userLastName", 31, "user@mail.ru", "0", roleUserSet));
    }
}
