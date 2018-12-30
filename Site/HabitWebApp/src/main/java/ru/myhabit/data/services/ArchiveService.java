package ru.myhabit.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myhabit.data.dao.ArchiveDao;
import ru.myhabit.data.domain.Archive;
import ru.myhabit.data.repository.ArchiveRepository;

import java.util.List;
@Service
public class ArchiveService implements ArchiveDao {
    @Autowired
    ArchiveRepository repository;
    @Override
    public List<Archive> getAll() {
        return repository.findAll();
    }

    @Override
    public Archive getById(Long id) {
        return repository.findById(id).orElseGet(()-> new Archive());
    }

    @Override
    public Archive update(Archive archive) {
        return repository.save(archive);

    }

    @Override
    public void delete(Archive archive) {
        repository.delete(archive);
    }
}
