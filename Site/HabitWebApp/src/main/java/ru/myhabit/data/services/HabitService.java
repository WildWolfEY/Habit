package ru.myhabit.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myhabit.data.dao.HabitDao;
import ru.myhabit.data.domain.Habit;
import ru.myhabit.data.repository.HabitRepository;

import java.util.List;

@Service
public class HabitService implements HabitDao{
    @Autowired
    HabitRepository repository;

    @Override
    public List<Habit> getAll() {
        return repository.findAll();
    }

    @Override
    public Habit getById(Long id) {
        return repository.findById(id).orElseGet(()-> new Habit());
    }

    @Override
    public Habit update(Habit habit) {
        return repository.save(habit);
    }

    @Override
    public void delete(Habit habit) {
        repository.delete(habit);
    }
}
