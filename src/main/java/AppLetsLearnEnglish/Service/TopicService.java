package AppLetsLearnEnglish.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AppLetsLearnEnglish.Dao.TopicRepository;
import AppLetsLearnEnglish.Entity.Lession;
import AppLetsLearnEnglish.Entity.Topic;

@Service
public class TopicService{
	@Autowired
	TopicRepository topicRepository;
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	public List<Topic> getallTopic() {
		List<Topic> topics =  topicRepository.getall();
//		for (Topic topic : topics) {
//		    System.out.println(topic.getName_topic());
//		}
		return topics;
	}

}
