package AppLetsLearnEnglish.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class Video {
	@Id
	int idvideo;
	String namevideo;
	String linkvideo;
	int numhumanwatched;
	int idchanel;
	String imagevideo;
	
	public String getImagevideo() {
		return imagevideo;
	}
	public void setImagevideo(String imagevideo) {
		this.imagevideo = imagevideo;
	}
	public int getIdvideo() {
		return idvideo;
	}
	public void setIdvideo(int idvideo) {
		this.idvideo = idvideo;
	}
	public String getNamevideo() {
		return namevideo;
	}
	public void setNamevideo(String namevideo) {
		this.namevideo = namevideo;
	}
	public String getLinkvideo() {
		return linkvideo;
	}
	public void setLinkvideo(String linkvideo) {
		this.linkvideo = linkvideo;
	}
	public int getNumhumanwatched() {
		return numhumanwatched;
	}
	public void setNumhumanwatched(int numhumanwatched) {
		this.numhumanwatched = numhumanwatched;
	}
	public int getIdchanel() {
		return idchanel;
	}
	public void setIdchanel(int idchanel) {
		this.idchanel = idchanel;
	}
}
