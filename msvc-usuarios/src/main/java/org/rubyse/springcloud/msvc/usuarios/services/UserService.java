package org.rubyse.springcloud.msvc.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.rubyse.springcloud.msvc.usuarios.models.entities.User;

public interface UserService {

    List<User> findAll();
    Optional<User> findById(Long id);
    User save(User user);
    void delete (Long id);

}
