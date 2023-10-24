package AppLetsLearnEnglish.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name ="lession")
public class Lession {
	@Id
	int idlession;
	String name_lession;
	int idtopic;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idlession")
	@OrderBy("idvocabulary ASC")
	Set<Vocabulary> vocabularies ;
	
	public Set<Vocabulary> getVocabularies() {
		return vocabularies;
	}
	public void setVocabularies(Set<Vocabulary> vocabularies) {
		this.vocabularies = vocabularies;
	}
	public int getIdlession() {
		return idlession;
	}
	public void setIdlession(int idlession) {
		this.idlession = idlession;
	}
	public String getName_lession() {
		return name_lession;
	}
	public void setName_lession(String name_lession) {
		this.name_lession = name_lession;
	}
	public int getIdtopic() {
		return idtopic;
	}
	public void setIdtopic(int idtopic) {
		this.idtopic = idtopic;
	}
	
}
