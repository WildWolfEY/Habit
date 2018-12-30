package ru.myhabit.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myhabit.data.dao.VariantTestHabitDao;
import ru.myhabit.data.domain.VariantTestHabit;
import ru.myhabit.data.repository.VariantTestHabitRepository;

import java.util.List;
@Service
public class VariantTestHabitService implements VariantTestHabitDao {

    @Autowired
    VariantTestHabitRepository repository;

    @Override
    public List<VariantTestHabit> getAll() {
        return repository.findAll();
    }

    @Override
    public VariantTestHabit getById(Long id) {
        return repository.findById(id).orElseGet(()-> new VariantTestHabit());
    }

    @Override
    public VariantTestHabit update(VariantTestHabit object) {
        return repository.save(object);
    }

    @Override
    public void delete(VariantTestHabit object) {
        repository.delete(object);
    }
}
