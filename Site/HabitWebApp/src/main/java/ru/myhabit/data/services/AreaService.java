package ru.myhabit.data.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myhabit.data.dao.AreaDao;
import ru.myhabit.data.domain.Area;
import ru.myhabit.data.repository.AreaRepository;

import java.util.List;

@Service
public class AreaService implements AreaDao{

    @Autowired
    AreaRepository repository;

    public List<Area> getAll() {

        return repository.findAll();
    }

    public Area getById(Long id) {

        return repository.findById(id).orElseGet(()-> new Area());
    }

    public Area update(Area area) {
        return repository.save(area);
    }

    public void delete(Area area) {
        repository.delete(area);
    }
}
