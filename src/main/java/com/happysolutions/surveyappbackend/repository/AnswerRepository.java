package com.happysolutions.surveyappbackend.repository;

import com.happysolutions.surveyappbackend.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
