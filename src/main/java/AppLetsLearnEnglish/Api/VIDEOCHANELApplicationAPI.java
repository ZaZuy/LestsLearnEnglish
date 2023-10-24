package AppLetsLearnEnglish.Api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import AppLetsLearnEnglish.Entity.Chanel;
import AppLetsLearnEnglish.Entity.Topic;
import AppLetsLearnEnglish.Entity.Video;
import AppLetsLearnEnglish.Service.ChanelService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/chanel")
public class VIDEOCHANELApplicationAPI {
	@Autowired
	ChanelService chanelService;
	@Autowired
	String GetIPAddress;
	
	@GetMapping("/GetIPAddress")
	public String GetIPAddress() {
		return GetIPAddress;
	}
	
	@GetMapping("/all")
	public String APIChanel() {
		List<Chanel> chanels =  chanelService.getallChanel();
		List<Chanel> allchanel = new ArrayList<>();
		Chanel c = new Chanel();
		for (Chanel chanel : chanels) {
			c.setIdchanel(chanel.getIdchanel());
			c.setImagechanel(GetIPAddress+chanel.getImagechanel());
			c.setNamechanel(chanel.getNamechanel());
			allchanel.add(c);
			c = new Chanel();
		}
		Gson gson = new Gson();
		String json =gson.toJson(allchanel);
		return json;
	}
	@GetMapping("/list")
	public String APIlistvideoChanel() {
		List<Chanel> chanels =  chanelService.getallChanel();
		List<listvideos> APIvideo = new ArrayList<>();
		List<String> namevideo=new ArrayList<>();
		List<String> vid=new ArrayList<>();
		List<String> imagevid=new ArrayList<>();
		List<Integer> numhumanwatched=new ArrayList<>();
		listvideos c = new listvideos();
		for (Chanel chanel : chanels) {			
			for (Video video : chanel.getVideos()) {
				if(chanel.getIdchanel() == video.getIdchanel()) {
				imagevid.add(GetIPAddress+video.getImagevideo());
				namevideo.add(video.getNamevideo());
				vid.add(GetIPAddress+video.getLinkvideo());
				numhumanwatched.add(video.getNumhumanwatched());
				}			
			}
			c.setChude(chanel.getNamechanel());
			c.setId(chanel.getIdchanel());
			c.setNamevideo(namevideo);
			c.setVieo(vid);
			c.setImagevideo(imagevid);
			c.setNumhumanwatched(numhumanwatched);
			APIvideo.add(c);
			
			namevideo=new ArrayList<>();
			vid=new ArrayList<>();
			numhumanwatched=new ArrayList<>();
			imagevid=new ArrayList<>();
			c = new listvideos();
		}
		Gson gson = new Gson();
		String json =gson.toJson(APIvideo);
		return json;
	}
	@GetMapping("/list/{id}")
	public String APIlistvideo(@PathVariable int id) {
		List<Chanel> chanels =  chanelService.getallChanel();
		String apivideo = null;
		for (Chanel chanel : chanels) {			
			for (Video video : chanel.getVideos()) {
				if(video.getIdvideo()==id) {
					apivideo = GetIPAddress+video.getLinkvideo();
				}
			}
		}
		return apivideo;
	}
	class listvideos {
		int id;
		String chude;
		List<String> imagevideo;
		List<String> namevideo;
		List<String> video;
		List<Integer> numhumanwatched;
		
		public List<String> getImagevideo() {
			return imagevideo;
		}
		public void setImagevideo(List<String> imagevideo) {
			this.imagevideo = imagevideo;
		}
		public List<String> getVideo() {
			return video;
		}
		public void setVideo(List<String> video) {
			this.video = video;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getChude() {
			return chude;
		}
		public void setChude(String chude) {
			this.chude = chude;
		}
		
		public List<String> getNamevideo() {
			return namevideo;
		}
		public void setNamevideo(List<String> namevideo) {
			this.namevideo = namevideo;
		}
		public List<String> getVieo() {
			return video;
		}
		public void setVieo(List<String> vieo) {
			this.video = vieo;
		}
		public List<Integer> getNumhumanwatched() {
			return numhumanwatched;
		}
		public void setNumhumanwatched(List<Integer> numhumanwatched) {
			this.numhumanwatched = numhumanwatched;
		}
		
	}
}

