package AppLetsLearnEnglish.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import AppLetsLearnEnglish.Dao.AccountRepository;
@Service
public class AccountService {
	
    @Autowired
    AccountRepository accountRepository;
    
	public List<Integer> getid(){
		List<Integer> u  = accountRepository.getid();
		for (Integer us : u) {
            System.out.println(us);
        }
		return u;
	}
}
