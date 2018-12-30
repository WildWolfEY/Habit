package ru.myhabit.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myhabit.data.dao.ProgressDao;
import ru.myhabit.data.domain.Progress;
import ru.myhabit.data.repository.ProgressRepository;

import java.util.List;
@Service
public class ProgressService implements ProgressDao {
    @Autowired
    ProgressRepository repository;

    @Override
    public List<Progress> getAll() {
        return repository.findAll();
    }

    @Override
    public Progress getById(Long id) {
        return repository.findById(id).orElseGet(()-> new Progress());
    }

    @Override
    public Progress update(Progress object) {
        return repository.save(object);
    }

    @Override
    public void delete(Progress object) {
        repository.delete(object);
    }
}
