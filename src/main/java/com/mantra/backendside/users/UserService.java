package com.mantra.backendside.users;

import org.springframework.beans.factory.annotation.Autowired;
import com.mantra.backendside.users.Users;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<Users> listAll() {
        return this.userRepository.findAll();
    }

    public void saveOrUpdate(Users users)
    {
        userRepository.save(users);
    }
    public Users getUserById(long id)
    {
        return userRepository.findById(id).get();
    }
    public void update(Users users, int id)
    {
        userRepository.save(users);
    }

    public void delete(long id)
    {
        userRepository.deleteById(id);
    }
}
