	'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');

var stompClient = null;
var username = null;

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function connect(event) {
    username = document.querySelector('#name').value.trim();

    if(username) {
        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');

        var socket = new SockJS('/javatechie');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}


function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/public', onMessageReceived);

    // Tell your username to the server
    stompClient.send("/app/chat.register",
        {},
        JSON.stringify({sender: username, type: 'JOIN'})
    )

    connectingElement.classList.add('hidden');
}


function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}

var reponse;
function send(event) {
    var messageContent = ask;

    if(messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            content: messageContent,
            type: 'CHAT'
        };
        myFunction(messageContent).then(data =>{message.innerHTML = message.value+"\nBOT: " + data;
        speech.text = data;
    	window.speechSynthesis.speak(speech);});
        stompClient.send("/app/chat.send", {}, JSON.stringify(chatMessage));
    }
}


function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);

    var messageElement = document.createElement('li');

    if(message.type === 'JOIN') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' joined!';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' left!';
    } else {
        messageElement.classList.add('chat-message');

//        var avatarElement = document.createElement('i');
//        var avatarText = document.createTextNode(message.sender[0]);
//        avatarElement.appendChild(avatarText);
//        avatarElement.style['background-color'] = getAvatarColor(message.sender);
//
//        messageElement.appendChild(avatarElement);

//        var usernameElement = document.createElement('span');
//        var usernameText = document.createTextNode(message.sender);
//        usernameElement.appendChild(usernameText);
//        messageElement.appendChild(usernameElement);
    }

//    var textElement = document.createElement('p');
//    var messageText = document.createTextNode(message.content);
//    textElement.appendChild(messageText);
//
//    messageElement.appendChild(textElement);
//
//    messageArea.appendChild(messageElement);
//    messageArea.scrollTop = messageArea.scrollHeight;
}


function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }

    var index = Math.abs(hash % colors.length);
    return colors[index];
}

usernameForm.addEventListener('submit', connect, true)

var isRecording = false;
var recognition;
var day = new Date();
var ask;
var message = document.getElementById('convert_text');
function startRecording() {
	 if (!isRecording) {
		    isRecording = true;
		    window.SpeechRecognition = window.webkitSpeechRecognition;
		    recognition = new SpeechRecognition();
		    recognition.interimResults = true;
		    recognition.lang = 'en-US';
		    recognition.addEventListener('result', e => {
		      const transcript = Array.from(e.results)
		        .map(result => result[0])
		        .map(result => result.transcript)
		        .join(''); 
		      message.innerHTML = "YOU: "+transcript;
		      ask = transcript;
		      
		    });	    
	    recognition.addEventListener('end', () => {	
	    	send(true);
	    });
        recognition.start();
        setTimeout(() => {
            stopRecording();
        }, 3000);
    }
}

function stopRecording() {
    if (isRecording) {
        isRecording = false;
        recognition.stop();
    }
}
click_to_convert.addEventListener('click', startRecording);



async function myFunction(mess){
	mess = "I want you to answer in 50 words maximum and here is my question: "+mess;
	const response = await fetch(`http://localhost:8081/bot/chat/${mess}`);
	const data = await response.text();
    return data;
}

let speech = new SpeechSynthesisUtterance();

let voices = [];

let voiceSelect = document.querySelector("select");

window.speechSynthesis.onvoiceschanged = ()=>{
	voices = window.speechSynthesis.getVoices();
	speech.voice = voices[0];
	voices.forEach((voice,i)=>(voiceSelect.options[i]= new Option(voice.name,i)))
}

voiceSelect.addEventListener("change",()=>{
	speech.voice = voices[voiceSelect.value];
});
