package ru.myhabit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myhabit.data.domain.VariantTestHabit;
@Repository
public interface VariantTestHabitRepository extends JpaRepository<VariantTestHabit, Long> {
}
