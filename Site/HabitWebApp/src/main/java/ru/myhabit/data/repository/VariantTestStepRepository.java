package ru.myhabit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myhabit.data.domain.VariantTestStep;
@Repository
public interface VariantTestStepRepository extends JpaRepository<VariantTestStep, Long> {
}
