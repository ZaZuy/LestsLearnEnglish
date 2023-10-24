package AppLetsLearnEnglish.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import AppLetsLearnEnglish.Dao.AccountRepository;
import AppLetsLearnEnglish.Entity.Account;

@Service
public class CustomAccountServiceDetails implements UserDetailsService{
	@Autowired
	AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String Username) throws UsernameNotFoundException {
		Account acc = accountRepository.findByUsername(Username);
		CustomAccountDetails customAccountDetails=null;
		if(acc!=null) {
			customAccountDetails = new CustomAccountDetails();
			customAccountDetails.setAccount(acc);
		}
		else {
			throw new UsernameNotFoundException("User not exist with name "+ Username);
		}
	
		// TODO Auto-generated method stub
		return customAccountDetails;
	}

}
