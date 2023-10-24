package AppLetsLearnEnglish.Api;

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
@RequestMapping("/chanel")
public class TOPICApplicationVideoTopic {
	@Autowired
    private ResourceLoader resourceLoader;

    public ResponseEntity<byte[]> getVideo(String video) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:static/videos/"+ video);
        try (InputStream inputStream = resource.getInputStream()) {
            byte[] bytes = IOUtils.toByteArray(inputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(ContentDisposition.builder("inline").filename(video).build());
            headers.setContentType(MediaType.parseMediaType("video/mp4"));
            headers.setContentLength(bytes.length);

            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/video/{namevideo}")
    public ResponseEntity<byte[]> BenefitsofLearningaNewLanguage__MotivationalEnglishSpeechbyJackMa(@PathVariable String namevideo) throws IOException {
        return getVideo(namevideo);
    }
//    @GetMapping("/api/video/LearnEnglishwithHERCULES.mp4")
//    public ResponseEntity<byte[]> LearnEnglishwithHERCULES() throws IOException {
//        return getVideo( "Learn English with HERCULES _ #shorts");
//    }
//    @GetMapping("/api/video/Iwanttobeakidagain.mp4")
//    public ResponseEntity<byte[]> Iwanttobeakidagain() throws IOException {
//        return getVideo("I want to be a kid again");
//    }
//    @GetMapping("/api/video/LearnEnglishthroughFunnyStory.mp4")
//    public ResponseEntity<byte[]> LearnEnglishthroughFunnyStory() throws IOException {
//        return getVideo("Learn English through Funny Story");
//    }
//    @GetMapping("/api/video/LearnEnglishThroughStory__EnglishlisteningPractice.mp4")
//    public ResponseEntity<byte[]> LearnEnglishThroughStory__EnglishlisteningPractice() throws IOException {
//        return getVideo("Learn English Through Story _  _ English listening Practice");
//    }
//    @GetMapping("/api/video/YouabsolutelyhavetoknowthisexpressioninEnglish.mp4")
//    public ResponseEntity<byte[]> YouabsolutelyhavetoknowthisexpressioninEnglish() throws IOException {
//        return getVideo("You absolutely have to know this expression in English");
//    }

}
