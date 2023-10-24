package AppLetsLearnEnglish.AIAPI;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.CookieGenerator;
import org.springframework.web.util.UriUtils;

import AppLetsLearnEnglish.AIdto.ChatGPTRequest;
import AppLetsLearnEnglish.AIdto.ChatGptResponse;

@RestController
@RequestMapping("/bot")
public class APIchatbot {

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @GetMapping("/chat/{mess}")
    public String chat(@PathVariable("mess") String prompt,HttpServletResponse response,ModelMap map){
        ChatGPTRequest requests=new ChatGPTRequest(model, prompt);
        ChatGptResponse chatGptResponse = template.postForObject(apiURL, requests, ChatGptResponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent().toString();
    }   
}