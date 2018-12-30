package ru.myhabit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myhabit.data.domain.AreaHabit;
@Repository
public interface AreaHabitRepository extends JpaRepository<AreaHabit, Long>{
}
