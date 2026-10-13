package com.rosake.mydb.repositories;

import com.rosake.mydb.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{

}
