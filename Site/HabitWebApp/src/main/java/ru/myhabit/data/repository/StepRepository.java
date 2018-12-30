package ru.myhabit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myhabit.data.domain.Step;
@Repository
public interface StepRepository extends JpaRepository<Step,Long> {
}
