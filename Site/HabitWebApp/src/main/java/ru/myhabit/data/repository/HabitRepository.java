package ru.myhabit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myhabit.data.domain.Habit;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {
}
