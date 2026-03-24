package com.dsgymhouse.api.workout;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WorkoutRepository extends JpaRepository<Workout, Long>, JpaSpecificationExecutor<Workout> {
    Optional<Workout> findByIdAndPublishedTrue(Long id);
}