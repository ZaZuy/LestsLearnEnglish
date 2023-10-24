package AppLetsLearnEnglish.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import AppLetsLearnEnglish.Entity.Chanel;
import AppLetsLearnEnglish.Entity.Topic;

@Repository
public interface ChanelRepository extends JpaRepository<Chanel,Long>{
	@Query("SELECT chanel FROM Chanel chanel")
	List<Chanel> getall();

}
