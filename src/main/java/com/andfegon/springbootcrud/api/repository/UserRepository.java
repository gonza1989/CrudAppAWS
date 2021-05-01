package com.andfegon.springbootcrud.api.repository;

import com.andfegon.springbootcrud.api.model.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface UserRepository extends CrudRepository<User, String> {
}
