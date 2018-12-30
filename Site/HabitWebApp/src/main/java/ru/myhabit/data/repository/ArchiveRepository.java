package ru.myhabit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.myhabit.data.domain.Archive;
@Repository
public interface ArchiveRepository extends JpaRepository<Archive, Long> {
}
