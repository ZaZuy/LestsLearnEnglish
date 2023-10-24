package AppLetsLearnEnglish.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authority")
public class Authority {
	@Id
	private int ID;
	private String Rolecode;
	private String Roledescription;
	
	@ManyToMany
	@JoinTable(name="accountandauthority",
	joinColumns= {@JoinColumn(name="idauthority",referencedColumnName="ID")},
	inverseJoinColumns={@JoinColumn(name="idaccount",referencedColumnName="ID")})
	
	Set<Account> accounts;
	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getRolecode() {
		return Rolecode;
	}
	public void setRolecode(String rolecode) {
		this.Rolecode = rolecode;
	}
	public String getRoledescription() {
		return Roledescription;
	}
	public void setRoledescription(String roledescription) {
		this.Roledescription = roledescription;
	}
	
	
}
