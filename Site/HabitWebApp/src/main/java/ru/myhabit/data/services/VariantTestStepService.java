package ru.myhabit.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myhabit.data.dao.VariantTestStepDao;
import ru.myhabit.data.domain.VariantTestStep;
import ru.myhabit.data.repository.VariantTestStepRepository;

import java.util.List;
@Service
public class VariantTestStepService implements VariantTestStepDao{
    @Autowired
    VariantTestStepRepository repository;

    @Override
    public List<VariantTestStep> getAll() {
        return repository.findAll();
    }

    @Override
    public VariantTestStep getById(Long id) {
        return repository.findById(id).orElseGet(()-> new VariantTestStep());
    }

    @Override
    public VariantTestStep update(VariantTestStep object) {
        return repository.save(object);
    }

    @Override
    public void delete(VariantTestStep object) {
        repository.delete(object);
    }
}
