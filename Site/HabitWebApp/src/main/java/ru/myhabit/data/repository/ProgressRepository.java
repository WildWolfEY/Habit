package ru.myhabit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myhabit.data.domain.Progress;
@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
}
