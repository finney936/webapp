package com.training.maven.dao;

import org.springframework.data.repository.CrudRepository;

import com.training.maven.beans.User;

public interface UserRepo extends CrudRepository<User, String> {

}
