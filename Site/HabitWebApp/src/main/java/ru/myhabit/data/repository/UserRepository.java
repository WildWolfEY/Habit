package ru.myhabit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myhabit.data.domain.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
