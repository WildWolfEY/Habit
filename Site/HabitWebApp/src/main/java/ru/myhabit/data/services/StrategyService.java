package ru.myhabit.data.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myhabit.data.dao.StrategyDao;
import ru.myhabit.data.domain.Strategy;
import ru.myhabit.data.repository.StrategyRepository;

import java.util.List;
@Service
public class StrategyService implements StrategyDao {
    @Autowired
    StrategyRepository repository;

    @Override
    public List<Strategy> getAll() {
        return repository.findAll();
    }

    @Override
    public Strategy getById(Long id) {
        return repository.findById(id).orElseGet(()-> new Strategy());
    }

    @Override
    public Strategy update(Strategy object) {
        return repository.save(object);
    }

    @Override
    public void delete(Strategy object) {
        repository.delete(object);
    }
}
