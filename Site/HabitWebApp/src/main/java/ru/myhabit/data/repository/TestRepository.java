package ru.myhabit.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myhabit.data.domain.Test;
@Repository
public interface TestRepository extends JpaRepository<Test,Long> {
}
