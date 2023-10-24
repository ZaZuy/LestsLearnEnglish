package AppLetsLearnEnglish.AIdto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import AppLetsLearnEnglish.AIentity.Message;

public class ChatGPTRequest {

    private String model;
    private List<Message> messages;
    public ChatGPTRequest() {
    	
    }
    
    public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public ChatGPTRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user",prompt));
    }
}