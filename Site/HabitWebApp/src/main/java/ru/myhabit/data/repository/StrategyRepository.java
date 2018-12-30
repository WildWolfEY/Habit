package ru.myhabit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myhabit.data.domain.Strategy;
@Repository
public interface StrategyRepository extends JpaRepository<Strategy,Long> {
}
