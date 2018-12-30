package ru.myhabit.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myhabit.data.dao.UserDao;
import ru.myhabit.data.domain.User;
import ru.myhabit.data.repository.UserRepository;

import java.util.List;
@Service
public class UserService implements UserDao {
    @Autowired
    UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(Long id) {
        return repository.findById(id).orElseGet(()-> new User());
    }

    @Override
    public User update(User object) {
        return repository.save(object);
    }

    @Override
    public void delete(User object) {
        repository.delete(object);
    }
}
