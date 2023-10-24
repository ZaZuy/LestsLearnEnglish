package AppLetsLearnEnglish.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import AppLetsLearnEnglish.Entity.Account;
import AppLetsLearnEnglish.Entity.Authority;

public class CustomAccountDetails implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Account account ;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> roles = account.getAuthorities();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Authority role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRolecode()));
        }
         
        return authorities;

	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return account.getBcryptpassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return account.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	

}
