package ru.myhabit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myhabit.data.domain.Status;
@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {
}
