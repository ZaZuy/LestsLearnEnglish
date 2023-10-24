package AppLetsLearnEnglish;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import AppLetsLearnEnglish.Dao.AccountRepository;
import AppLetsLearnEnglish.Dao.TopicRepository;
import AppLetsLearnEnglish.Entity.Lession;
import AppLetsLearnEnglish.Entity.Topic;
import AppLetsLearnEnglish.Entity.Vocabulary;
//import AppLetsLearnEnglish.Service.TopicService;
import AppLetsLearnEnglish.Service.TopicService;



@SpringBootApplication
public class Application {
	
//	@Autowired
//	private AccountRepository accountRepository;
	
	@Autowired
	private TopicService topicService;
	@Autowired
	TopicRepository topicRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	@PostConstruct
//	protected void init() {
//		
//		authority a = new authority();
//		a.setID(1);
//		a.setRolecode("ADMIN");
//		a.setRoledescription("ADMIN NHE");
//		Set<authority> authorities = new HashSet<>();
//		authorities.add(a);
//		
//		account ac = new account();
//		ac.setID(1);
//		ac.setUsername("D");
//		ac.setBcryptpassword("123");
//		ac.setAuthorities(authorities);
//		
//		accountRepository.save(ac);
//		
//	}
//	
//	@PostConstruct
//	protected void init() {
//		Topic topic = new Topic();
//		topic.setIdtopic(1);
//		topic.setIdlesson(1);
//		topic.setImg_topic("http://192.168.55.2:8081/topic/api/image/Travel");
//		topic.setName_topic("Education");
////		topic.setSound("http://192.168.55.2:8081/topic/api/sound/Travel/Lession1/sister__gb_2.mp3");
//		
//		Lession lession = new Lession();
//		lession.setIdlession(1);
//		lession.setIdtopic(1);
//		lession.setIdvocabulary(1);
//		lession.setName_lession("Lession 2");
//		Set<Lession> lessions = new HashSet<>();
//		lessions.add(lession);
//		
//		Vocabulary vocabulary = new Vocabulary();
//		vocabulary.setIdvocabulary(1);
//		vocabulary.setIdlession(1);
//		vocabulary.setVoca_eng("school");
//		vocabulary.setVoca_vi("truong");
//		
//		Set<Vocabulary> vocabularies = new HashSet<>();
//		vocabularies.add(vocabulary);
//		
//		lession.setVocabularies(vocabularies);
//		
//		topic.setLessions(lessions);
//		
//		topicService.addTopic(topic);
////		topicRepository.save(topic);	
//	}
}