package AppLetsLearnEnglish.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
    @Id
    private int ID;

	private String Username;
    
    private String Bcryptpassword;
    
    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="accountandauthority",
    		joinColumns= {@JoinColumn(name="idaccount",referencedColumnName="ID")},
    		inverseJoinColumns={@JoinColumn(name="idauthority",referencedColumnName="ID")})
    
    Set<Authority> authorities;
    public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public void setBcryptpassword(String bcryptpassword) {
		this.Bcryptpassword = bcryptpassword;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public String getBcryptpassword() {
		return Bcryptpassword;
	}

    
}