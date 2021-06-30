package uz.talaba.talabauz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uz.talaba.talabauz.entity.User;
import uz.talaba.talabauz.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(maxAge = 3600)
public class UserController {
    @Autowired
    UserService userService;





    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        try {
            return ResponseEntity.ok(userService.create(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user, HttpServletResponse hsr){
        try {
            User userBaza = userService.loadByUsername(user.getUsername());
            if(userBaza != null && userBaza.getPassword().equals(user.getPassword())){


                return ResponseEntity.ok(userBaza);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }



}
