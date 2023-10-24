package AppLetsLearnEnglish.Api;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AppLetsLearnEnglish.Dao.AccountRepository;
import AppLetsLearnEnglish.Entity.Account;
import AppLetsLearnEnglish.Entity.Authority;
import AppLetsLearnEnglish.Service.AccountService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping()
public class USERApplicationController {
	@Autowired
	AccountService accountService;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
    @PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/users")
	public String ADMIN() {
		return "user NHE";

	}
    @PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/admin")
	public String USER() {
//		String pwd = user.getBcryptpassword();@RequestBody Account user
//		String encryptPwd = passwordEncoder.encode(pwd);
//		user.setBcryptpassword(encryptPwd);
//		accountRepository.save(user);
		return "useraddsuccess";

	}

}