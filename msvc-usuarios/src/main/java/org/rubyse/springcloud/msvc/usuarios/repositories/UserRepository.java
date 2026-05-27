package org.rubyse.springcloud.msvc.usuarios.repositories;

import org.rubyse.springcloud.msvc.usuarios.models.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long>{

}
