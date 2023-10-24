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
@Table(name = "chanel")
public class Chanel {
	@Id
	int idchanel;
	String namechanel;
	String imagechanel;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idchanel")
	@OrderBy("idvideo ASC")
	Set<Video> videos;
	public Set<Video> getVideos() {
		return videos;
	}
	public void setVideos(Set<Video> videos) {
		this.videos = videos;
	}
	public int getIdchanel() {
		return idchanel;
	}
	public void setIdchanel(int idchanel) {
		this.idchanel = idchanel;
	}
	public String getNamechanel() {
		return namechanel;
	}
	public void setNamechanel(String namechanel) {
		this.namechanel = namechanel;
	}
	public String getImagechanel() {
		return imagechanel;
	}
	public void setImagechanel(String imagechanel) {
		this.imagechanel = imagechanel;
	}
	
}
