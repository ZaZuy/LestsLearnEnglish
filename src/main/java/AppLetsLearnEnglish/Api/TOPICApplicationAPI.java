package AppLetsLearnEnglish.Api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.google.gson.Gson;

import AppLetsLearnEnglish.Entity.Lession;
import AppLetsLearnEnglish.Entity.Topic;
import AppLetsLearnEnglish.Entity.Vocabulary;
import AppLetsLearnEnglish.Service.TopicService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/topic")
public class TOPICApplicationAPI {
	@Autowired
	TopicService topicService;
	@Autowired
	String GetIPAddress;
	
	@GetMapping("/")
	public String APItopicpage() {
		List<Topic> topics = topicService.getallTopic();
		List<Object> Lession_name = new ArrayList<>();		
		List<Topics> list  = new ArrayList<>();
		Topics top = new Topics();
		for (Topic topic : topics) {
			for (Lession lession : topic.getLessions()) {
				Lession_name.add(lession.getName_lession());
			}
			top.setId(topic.getIdtopic());
			top.setName_topic(topic.getName_topic());
			top.setImg_topic(GetIPAddress+topic.getImg_topic());
			top.setName_lesson(Lession_name);
			list.add(top);
			top = new Topics();
			Lession_name = new ArrayList<>();
		}
		Gson gson = new Gson();
		String json =gson.toJson(list);
		
		return json;
	}
	//topic/topicmodal {name_topic, name_lesson, voca_eng, voca_vi}
	@GetMapping("/topicmodal")
	public String APItopicmodalpage() {
		List<Topic> topics = topicService.getallTopic();
		List<String> lessionName = new ArrayList<>() ;
		List<String> voca_eng= new ArrayList<>();
		List<String> voca_vi =new ArrayList<>();
		topicmodal e = new topicmodal();
//		int dem = 0;
		List<topicmodal> modal = new ArrayList<TOPICApplicationAPI.topicmodal>();
		for (Topic topic : topics) {
			for (Lession lession : topic.getLessions()) {
				lessionName.add(lession.getName_lession());
				for (Vocabulary vocabulary : lession.getVocabularies()) {
					voca_eng.add(vocabulary.getVoca_eng());
					voca_vi.add(vocabulary.getVoca_vi());
				}
				
			}
//			Collections.sort(voca_eng, new Comparator<String>() {
//	            @Override
//	            public int compare(String s1, String s2) {	                
//	                return s1.compareTo(s2);
//	            }
//	        });
//			
//			Collections.sort(voca_vi, new Comparator<String>() {
//	            @Override
//	            public int compare(String s1, String s2) {	                
//	                return s1.compareTo(s2);
//	            }
//	        });
//			
//			Collections.sort(lessionName, new Comparator<String>() {
//	            @Override
//	            public int compare(String s1, String s2) {	                
//	                return s1.compareTo(s2);
//	            }
//	        });
			e.setName_lesson(lessionName);
			e.setId(topic.getIdtopic());
			e.setName_topic(topic.getName_topic());
			e.setVoca_eng(voca_eng);
			e.setVoca_vi(voca_vi);
			modal.add(e);
			lessionName = new ArrayList<>();
	        voca_eng = new ArrayList<>();
	        voca_vi = new ArrayList<>();
	        e = new topicmodal() ;
		}
		Gson gson = new Gson();
		String json =gson.toJson(modal);
		return json;
	}
	//topic/topicmodal/detailtopic {voca_eng, voca_vi, sound}
	@GetMapping("topicmodal/detailtopic")
	public String APIdetailtopicpage() {
		List<Topic> topics = topicService.getallTopic();
		List<String> voca_eng = new ArrayList<>();
		List<String> voca_vi = new ArrayList<>();
		List<String> sound = new ArrayList<>();
		
		detailtopic de = new detailtopic();
		List<detailtopic> listde = new ArrayList<>();
		for (Topic topic : topics) {
			for (Lession lession : topic.getLessions()) {
				for (Vocabulary vocabulary : lession.getVocabularies()) {
					voca_eng.add(vocabulary.getVoca_eng());
					voca_vi.add(vocabulary.getVoca_vi());
					sound.add(GetIPAddress+vocabulary.getSound());
				}
			}
//			Map<String, String> mapping = new HashMap<>();
//	        for (int i = 0; i < voca_eng.size(); i++) {
//	            mapping.put(voca_eng.get(i), voca_vi.get(i));
//	        }
//			Collections.sort(voca_eng, new Comparator<String>() {
//	            @Override
//	            public int compare(String s1, String s2) {	                
//	                return s1.compareTo(s2);
//	            }
//	        });
//	        voca_eng = new ArrayList<>(mapping.keySet());
//	        voca_vi = new ArrayList<>(mapping.values());
			de.setId(topic.getIdtopic());
			de.setVoca_eng(voca_eng);
			de.setVoca_vi(voca_vi);
			de.setSound(sound);
			listde.add(de);
			voca_eng = new ArrayList<>();
			voca_vi = new ArrayList<>();
		    sound = new ArrayList<>();
			de = new detailtopic();
		}
		Gson gson = new Gson();
		String json =gson.toJson(listde);
		
		return json;
	}
	@Autowired
	private ResourceLoader resourceLoader;
	@GetMapping("/api/image/Education")
	public ResponseEntity<byte[]> Education() throws IOException {
	    Resource resource = resourceLoader.getResource("classpath:static/images/Education.png");
	    if (resource.exists()) {
	        try (InputStream inputStream = resource.getInputStream()) {
	            byte[] bytes = IOUtils.toByteArray(inputStream); 
	            HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.IMAGE_JPEG);

	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
	        } catch (IOException e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
    @GetMapping("/api/image/Environment")
    public ResponseEntity<byte[]> Environment() throws IOException {
    	 Resource resource = resourceLoader.getResource("classpath:static/images/Environment.png");
 	    if (resource.exists()) {
 	        try (InputStream inputStream = resource.getInputStream()) {
 	            byte[] bytes = IOUtils.toByteArray(inputStream); 
 	            HttpHeaders headers = new HttpHeaders();
 	            headers.setContentType(MediaType.IMAGE_JPEG);

 	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
 	        } catch (IOException e) {
 	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
 	        }
 	    } else {
 	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 	    }
    }
    @GetMapping("/api/image/Health")
    public ResponseEntity<byte[]> Health() throws IOException {
    	 Resource resource = resourceLoader.getResource("classpath:static/images/Health.png");
 	    if (resource.exists()) {
 	        try (InputStream inputStream = resource.getInputStream()) {
 	            byte[] bytes = IOUtils.toByteArray(inputStream); 
 	            HttpHeaders headers = new HttpHeaders();
 	            headers.setContentType(MediaType.IMAGE_JPEG);

 	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
 	        } catch (IOException e) {
 	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
 	        }
 	    } else {
 	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 	    }
    }
    @GetMapping("/api/image/Family")
    public ResponseEntity<byte[]> Family() throws IOException {
    	 Resource resource = resourceLoader.getResource("classpath:static/images/Family.png");
 	    if (resource.exists()) {
 	        try (InputStream inputStream = resource.getInputStream()) {
 	            byte[] bytes = IOUtils.toByteArray(inputStream); 
 	            HttpHeaders headers = new HttpHeaders();
 	            headers.setContentType(MediaType.IMAGE_JPEG);

 	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
 	        } catch (IOException e) {
 	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
 	        }
 	    } else {
 	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 	    }
    }
    @GetMapping("/api/image/Travel")
    public ResponseEntity<byte[]> Travel() throws IOException {
    	 Resource resource = resourceLoader.getResource("classpath:static/images/Travel.png");
 	    if (resource.exists()) {
 	        try (InputStream inputStream = resource.getInputStream()) {
 	            byte[] bytes = IOUtils.toByteArray(inputStream); 
 	            HttpHeaders headers = new HttpHeaders();
 	            headers.setContentType(MediaType.IMAGE_JPEG);

 	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
 	        } catch (IOException e) {
 	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
 	        }
 	    } else {
 	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 	    }
    }
    @GetMapping("/api/image/Technology")
    public ResponseEntity<byte[]> Technology() throws IOException {   
    	 Resource resource = resourceLoader.getResource("classpath:static/images/Technology.png");
 	    if (resource.exists()) {
 	        try (InputStream inputStream = resource.getInputStream()) {
 	            byte[] bytes = IOUtils.toByteArray(inputStream); 
 	            HttpHeaders headers = new HttpHeaders();
 	            headers.setContentType(MediaType.IMAGE_JPEG);

 	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
 	        } catch (IOException e) {
 	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
 	        }
 	    } else {
 	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 	    }
    }
    
    
    
	class Topics{
		int id;
		String name_topic;
		List<Object> name_lesson;
		String img_topic;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName_topic() {
			return name_topic;
		}
		public void setName_topic(String name_topic) {
			this.name_topic = name_topic;
		}
		public List<Object> getName_lesson() {
			return name_lesson;
		}
		public void setName_lesson(List<Object> name_lesson) {
			this.name_lesson = name_lesson;
		}
		public String getImg_topic() {
			return img_topic;
		}
		public void setImg_topic(String img_topic) {
			this.img_topic = img_topic;
		}
	}
	class topicmodal{
		int id ;
		String name_topic ;
		List<String> name_lesson ;
		List<String> voca_eng = new ArrayList<>();
		List<String> voca_vi = new ArrayList<>();
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName_topic() {
			return name_topic;
		}
		public void setName_topic(String name_topic) {
			this.name_topic = name_topic;
		}
		public List<String> getName_lesson() {
			return name_lesson;
		}
		public void setName_lesson(List<String> name_lesson) {
			this.name_lesson = name_lesson;
		}
		public List<String> getVoca_eng() {
			return voca_eng;
		}
		public void setVoca_eng(List<String> voca_eng) {
			this.voca_eng = voca_eng;
		}
		public List<String> getVoca_vi() {
			return voca_vi;
		}
		public void setVoca_vi(List<String> voca_vi) {
			this.voca_vi = voca_vi;
		}
	}
	class detailtopic{
		int id;
		List<String> sound = new ArrayList<>();
		List<String> voca_eng = new ArrayList<>();
		List<String> voca_vi = new ArrayList<>();
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public List<String> getSound() {
			return sound;
		}
		public void setSound(List<String> sound) {
			this.sound = sound;
		}
		public List<String> getVoca_eng() {
			return voca_eng;
		}
		public void setVoca_eng(List<String> voca_eng) {
			this.voca_eng = voca_eng;
		}
		public List<String> getVoca_vi() {
			return voca_vi;
		}
		public void setVoca_vi(List<String> voca_vi) {
			this.voca_vi = voca_vi;
		}
	}

}
