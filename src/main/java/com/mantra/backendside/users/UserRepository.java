package com.mantra.backendside.users;

import org.springframework.data.repository.CrudRepository;
import com.mantra.backendside.users.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
}
