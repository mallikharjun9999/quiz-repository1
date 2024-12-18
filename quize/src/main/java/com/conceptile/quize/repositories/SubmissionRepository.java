package com.conceptile.quize.repositories;

import com.conceptile.quize.entities.Submission;
import com.conceptile.quize.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findByUser(UserEntity user);
}
