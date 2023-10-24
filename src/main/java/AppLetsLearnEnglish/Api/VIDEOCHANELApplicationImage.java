package AppLetsLearnEnglish.Api;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/chanel")
public class VIDEOCHANELApplicationImage {
	@Autowired
	private ResourceLoader resourceLoader;
	
	@GetMapping("/api/image/{imgtopic}")
    public ResponseEntity<byte[]> imgtopic(@PathVariable String imgtopic) throws IOException {
    	 Resource resource = resourceLoader.getResource("classpath:static/images/"+imgtopic+".png");
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
//	@GetMapping("/api/image/Cartoon")
//    public ResponseEntity<byte[]> Cartoon() throws IOException {
//    	 Resource resource = resourceLoader.getResource("classpath:static/images/cartoon3.png");
// 	    if (resource.exists()) {
// 	        try (InputStream inputStream = resource.getInputStream()) {
// 	            byte[] bytes = IOUtils.toByteArray(inputStream); 
// 	            HttpHeaders headers = new HttpHeaders();
// 	            headers.setContentType(MediaType.IMAGE_JPEG);
//
// 	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
// 	        } catch (IOException e) {
// 	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// 	        }
// 	    } else {
// 	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// 	    }
//    }
//    @GetMapping("/api/image/Business")
//    public ResponseEntity<byte[]> Business() throws IOException {
//    	 Resource resource = resourceLoader.getResource("classpath:static/images/business.png");
// 	    if (resource.exists()) {
// 	        try (InputStream inputStream = resource.getInputStream()) {
// 	            byte[] bytes = IOUtils.toByteArray(inputStream); 
// 	            HttpHeaders headers = new HttpHeaders();
// 	            headers.setContentType(MediaType.IMAGE_JPEG);
//
// 	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
// 	        } catch (IOException e) {
// 	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// 	        }
// 	    } else {
// 	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// 	    }
//    }
//    @GetMapping("/api/image/Techlonogy")
//    public ResponseEntity<byte[]> Techlonogy() throws IOException {
//    	 Resource resource = resourceLoader.getResource("classpath:static/images/techlonogy.png");
// 	    if (resource.exists()) {
// 	        try (InputStream inputStream = resource.getInputStream()) {
// 	            byte[] bytes = IOUtils.toByteArray(inputStream); 
// 	            HttpHeaders headers = new HttpHeaders();
// 	            headers.setContentType(MediaType.IMAGE_JPEG);
//
// 	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
// 	        } catch (IOException e) {
// 	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// 	        }
// 	    } else {
// 	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// 	    }
//    }
//    @GetMapping("/api/image/Game")
//    public ResponseEntity<byte[]> Game() throws IOException {
//    	 Resource resource = resourceLoader.getResource("classpath:static/images/Game.jpg");
// 	    if (resource.exists()) {
// 	        try (InputStream inputStream = resource.getInputStream()) {
// 	            byte[] bytes = IOUtils.toByteArray(inputStream); 
// 	            HttpHeaders headers = new HttpHeaders();
// 	            headers.setContentType(MediaType.IMAGE_JPEG);
//
// 	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
// 	        } catch (IOException e) {
// 	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// 	        }
// 	    } else {
// 	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// 	    }
//    }
//    @GetMapping("/api/image/Natural")
//    public ResponseEntity<byte[]> Natural() throws IOException {
//    	 Resource resource = resourceLoader.getResource("classpath:static/images/Natural.png");
// 	    if (resource.exists()) {
// 	        try (InputStream inputStream = resource.getInputStream()) {
// 	            byte[] bytes = IOUtils.toByteArray(inputStream); 
// 	            HttpHeaders headers = new HttpHeaders();
// 	            headers.setContentType(MediaType.IMAGE_JPEG);
//
// 	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
// 	        } catch (IOException e) {
// 	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// 	        }
// 	    } else {
// 	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// 	    }
//    }
    @GetMapping("/api/imagesvideo/{nameimg}")
    public ResponseEntity<byte[]> YouabsolutelyhavetoknowthisexpressioninEnglish(@PathVariable String nameimg) throws IOException {
    	 Resource resource = resourceLoader.getResource("classpath:static/imagesvideo/"+nameimg+".jpg");
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

//    @GetMapping("/api/iimagesvideomage/Iwanttobeakidagain")
//    public ResponseEntity<byte[]> Iwanttobeakidagain() throws IOException {
//    	 Resource resource = resourceLoader.getResource("classpath:static/imagesvideo/I want to be a kid again.jpg");
// 	    if (resource.exists()) {
// 	        try (InputStream inputStream = resource.getInputStream()) {
// 	            byte[] bytes = IOUtils.toByteArray(inputStream); 
// 	            HttpHeaders headers = new HttpHeaders();
// 	            headers.setContentType(MediaType.IMAGE_JPEG);
//
// 	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
// 	        } catch (IOException e) {
// 	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// 	        }
// 	    } else {
// 	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// 	    }
//    }
//    @GetMapping("/api/imagesvideo/jackma")
//    public ResponseEntity<byte[]> jackma() throws IOException {
//    	 Resource resource = resourceLoader.getResource("classpath:static/imagesvideo/jackma.jpg");
// 	    if (resource.exists()) {
// 	        try (InputStream inputStream = resource.getInputStream()) {
// 	            byte[] bytes = IOUtils.toByteArray(inputStream); 
// 	            HttpHeaders headers = new HttpHeaders();
// 	            headers.setContentType(MediaType.IMAGE_JPEG);
//
// 	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
// 	        } catch (IOException e) {
// 	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// 	        }
// 	    } else {
// 	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// 	    }
//    }
//    @GetMapping("/api/imagesvideo/LearnEnglishthroughFunny")
//    public ResponseEntity<byte[]> LearnEnglishthroughFunny() throws IOException {
//    	 Resource resource = resourceLoader.getResource("classpath:static/imagesvideo/Learn English through Funny.jpg");
// 	    if (resource.exists()) {
// 	        try (InputStream inputStream = resource.getInputStream()) {
// 	            byte[] bytes = IOUtils.toByteArray(inputStream); 
// 	            HttpHeaders headers = new HttpHeaders();
// 	            headers.setContentType(MediaType.IMAGE_JPEG);
//
// 	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
// 	        } catch (IOException e) {
// 	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// 	        }
// 	    } else {
// 	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// 	    }
//    }
//    @GetMapping("/api/imagesvideo/LearnEnglishwithHERCULES")
//    public ResponseEntity<byte[]> LearnEnglishwithHERCULES() throws IOException {
//    	 Resource resource = resourceLoader.getResource("classpath:static/imagesvideo/Learn English with HERCULES.jpg");
// 	    if (resource.exists()) {
// 	        try (InputStream inputStream = resource.getInputStream()) {
// 	            byte[] bytes = IOUtils.toByteArray(inputStream); 
// 	            HttpHeaders headers = new HttpHeaders();
// 	            headers.setContentType(MediaType.IMAGE_JPEG);
//
// 	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
// 	        } catch (IOException e) {
// 	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// 	        }
// 	    } else {
// 	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// 	    }
//    }
//    @GetMapping("/api/imagesvideo/LearnEnglishThroughStory__EnglishlisteningPractice")
//    public ResponseEntity<byte[]> LearnEnglishThroughStory__EnglishlisteningPractice() throws IOException {
//    	 Resource resource = resourceLoader.getResource("classpath:static/imagesvideo/Learn English Through Story _  _ English listening Practice.jpg");
// 	    if (resource.exists()) {
// 	        try (InputStream inputStream = resource.getInputStream()) {
// 	            byte[] bytes = IOUtils.toByteArray(inputStream); 
// 	            HttpHeaders headers = new HttpHeaders();
// 	            headers.setContentType(MediaType.IMAGE_JPEG);
//
// 	            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
// 	        } catch (IOException e) {
// 	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// 	        }
// 	    } else {
// 	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// 	    }
//    }
}
