package AppLetsLearnEnglish.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="vocabulary")
public class Vocabulary {
	
	@Id
	int idvocabulary;
	
	String voca_eng;
	String voca_vi;
	int idlession;
	String sound;
	public int getIdvocabulary() {
		return idvocabulary;
	}
	public void setIdvocabulary(int idvocabulary) {
		this.idvocabulary = idvocabulary;
	}
	public String getVoca_eng() {
		return voca_eng;
	}
	public void setVoca_eng(String voca_eng) {
		this.voca_eng = voca_eng;
	}
	public String getVoca_vi() {
		return voca_vi;
	}
	public void setVoca_vi(String voca_vi) {
		this.voca_vi = voca_vi;
	}
	public int getIdlession() {
		return idlession;
	}
	public void setIdlession(int idlession) {
		this.idlession = idlession;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
}
