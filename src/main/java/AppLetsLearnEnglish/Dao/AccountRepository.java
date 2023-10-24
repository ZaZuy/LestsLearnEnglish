package AppLetsLearnEnglish.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import AppLetsLearnEnglish.Entity.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	@Query("SELECT user.id FROM Account user")
	List<Integer> getid();
	@Query("SELECT user FROM Account user where user.Username = username")
	Account findByUsername(String username);
	

}
