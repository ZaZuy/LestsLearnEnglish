package AppLetsLearnEnglish.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AppLetsLearnEnglish.Dao.ChanelRepository;
import AppLetsLearnEnglish.Dao.TopicRepository;
import AppLetsLearnEnglish.Entity.Chanel;
import AppLetsLearnEnglish.Entity.Topic;

@Service
public class ChanelService {
	@Autowired
	ChanelRepository chanelRepository;
	
	public List<Chanel> getallChanel() {
		List<Chanel> chanel =  chanelRepository.getall();
		return chanel;
	}

}
