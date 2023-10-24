package AppLetsLearnEnglish.Api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ContentDisposition;
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
@RequestMapping("/topic")
public class TOPICApplicationSound {
	@Autowired
    private ResourceLoader resourceLoader;
	public ResponseEntity<byte[]> getSound(String topic,String lession, String sound) throws IOException{
		Resource resource = resourceLoader.getResource("classpath:static/sounds/"+topic+"/"+lession+"/"+sound);
        try (InputStream inputStream = resource.getInputStream()) {
            byte[] bytes = IOUtils.toByteArray(inputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(ContentDisposition.builder("inline").filename("sound.mp3").build());
            headers.setContentType(MediaType.parseMediaType("audio/mpeg"));
            headers.setContentLength(bytes.length);

            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	@GetMapping("/api/sound/{nametopic}/{nameless}/{namesound}")
	public ResponseEntity<byte[]> kindergarten__gb_4(@PathVariable String nametopic,@PathVariable String nameless,@PathVariable String namesound) throws IOException {
		return getSound(nametopic,nameless,namesound);
	}
}
