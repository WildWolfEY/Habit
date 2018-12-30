package ru.myhabit.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myhabit.data.dao.AreaHabitDao;
import ru.myhabit.data.domain.AreaHabit;
import ru.myhabit.data.repository.AreaHabitRepository;


import java.util.List;
@Service
public class AreaHabitService implements AreaHabitDao {

    @Autowired
    AreaHabitRepository repository;

    public List<AreaHabit> getAll() {

        return repository.findAll();
    }

    public AreaHabit getById(Long id) {
        return repository.findById(id).orElseGet(()-> new AreaHabit());
    }

    public AreaHabit update(AreaHabit areaHabit) {
        return repository.save(areaHabit);
    }

    public void delete(AreaHabit areaHabit) {
        repository.delete(areaHabit);
    }
}
