package com.lambdaschool.ruralSchools.repository;

import com.lambdaschool.ruralSchools.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
