package ru.myhabit.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myhabit.data.dao.StepDao;
import ru.myhabit.data.domain.Step;
import ru.myhabit.data.repository.StepRepository;

import java.util.List;
@Service
public class StepService implements StepDao {
    @Autowired
    StepRepository repository;

    @Override
    public List<Step> getAll() {
        return repository.findAll();
    }

    @Override
    public Step getById(Long id) {
        return repository.findById(id).orElseGet(()-> new Step());
    }

    @Override
    public Step update(Step object) {

        return repository.save(object);
    }

    @Override
    public void delete(Step object) {
        repository.delete(object);
    }
}
