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
@Table(name = "topic")
public class Topic {
	@Id
	int idtopic;
	String name_topic;
	String img_topic;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idtopic")
	@OrderBy("idlession ASC")
	Set<Lession> lessions ;
	
	public Set<Lession> getLessions() {
		return lessions;
	}
	public void setLessions(Set<Lession> lessions) {
		this.lessions = lessions;
	}
	public int getIdtopic() {
		return idtopic;
	}
	public void setIdtopic(int idtopic) {
		this.idtopic = idtopic;
	}
	public String getName_topic() {
		return name_topic;
	}
	public void setName_topic(String name_topic) {
		this.name_topic = name_topic;
	}
	public String getImg_topic() {
		return img_topic;
	}
	public void setImg_topic(String img_lesson) {
		this.img_topic = img_lesson;
	}
	
}
