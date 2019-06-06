package com.alten.status.checker.dao;

import com.alten.status.checker.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
