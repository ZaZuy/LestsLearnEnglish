package AppLetsLearnEnglish.Dao;

import org.springframework.stereotype.Repository;

import AppLetsLearnEnglish.Entity.Lession;
import AppLetsLearnEnglish.Entity.Topic;
import AppLetsLearnEnglish.Entity.Vocabulary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Long>{
	@Query("SELECT topic FROM Topic topic")
	List<Topic> getall();

}
