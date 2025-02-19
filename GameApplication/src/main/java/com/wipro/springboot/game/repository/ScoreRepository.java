package com.wipro.springboot.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.springboot.game.model.Score;
import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, Long> {
	Optional<Score> findByName(String name);
}
