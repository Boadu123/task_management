package com.ben.spring_boot.repository;

import com.ben.spring_boot.models.TaskModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskModels, Long> {

}
