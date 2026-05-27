package org.rubyse.springcloud.msvc.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.rubyse.springcloud.msvc.usuarios.models.entities.User;
import org.rubyse.springcloud.msvc.usuarios.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        
        return (List<User>)repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
       
        return repository.findById(id);

    }

    @Override
    @Transactional
    public User save(User user) {
        
        return repository.save(user);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        repository.deleteById(id);

    }

}
