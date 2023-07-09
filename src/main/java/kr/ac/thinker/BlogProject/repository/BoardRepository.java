package kr.ac.thinker.BlogProject.repository;

import kr.ac.thinker.BlogProject.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
