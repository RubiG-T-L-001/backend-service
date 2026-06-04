package org.rubyse.springcloud.msvc.usuarios.controllers;

import java.util.List;
import java.util.Optional;

import org.rubyse.springcloud.msvc.usuarios.models.entities.User;
import org.rubyse.springcloud.msvc.usuarios.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> list() {

        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {

        Optional<User> userOptional = service.findById(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok().body(userOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {

        return service.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody User user, @PathVariable Long id) {
        Optional<User> o = service.findById(id);
        if (o.isPresent()) {
            User userDb = o.get();
            userDb.setName(user.getName());
            userDb.setEmail(user.getEmail());
            userDb.setPassword(user.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(userDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<User> o = service.findById(id);
        if (o.isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }    

        return ResponseEntity.notFound().build();

    }
}

