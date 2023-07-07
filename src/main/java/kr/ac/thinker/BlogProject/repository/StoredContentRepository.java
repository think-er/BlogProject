package kr.ac.thinker.BlogProject.repository;

import kr.ac.thinker.BlogProject.model.StoredContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoredContentRepository extends JpaRepository<StoredContent, Long> {

}
