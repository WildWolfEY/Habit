package ru.myhabit.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myhabit.data.dao.StatusDao;
import ru.myhabit.data.domain.Status;
import ru.myhabit.data.repository.StatusRepository;

import java.util.List;
@Deprecated
@Service
public class StatusService implements StatusDao {
    @Autowired
    StatusRepository repository;

    @Override
    public List<Status> getAll() {
        return repository.findAll();
    }

    @Override
    public Status getById(Long id) {
        return repository.findById(id).orElseGet(()-> new Status());
    }

    @Override
    public Status update(Status object) {
        return repository.save(object);
    }

    @Override
    public void delete(Status object) {
        repository.delete(object);
    }
}
