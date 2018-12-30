package ru.myhabit.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myhabit.data.dao.TestDao;
import ru.myhabit.data.domain.Test;
import ru.myhabit.data.repository.TestRepository;

import java.util.List;
@Service
public class TestService implements TestDao {
    @Autowired
    TestRepository repository;

    @Override
    public List<Test> getAll() {
        return repository.findAll();
    }

    @Override
    public Test getById(Long id) {
        return repository.findById(id).orElseGet(()-> new Test());
    }

    @Override
    public Test update(Test object) {
        return repository.save(object);
    }

    @Override
    public void delete(Test object) {
        repository.delete(object);
    }
}
