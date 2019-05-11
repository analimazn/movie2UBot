package view;

import java.util.List;
import utils.Observer;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import controller.ControllerMovie;
import controller.ControllerSearch;

import model.Model;

@SuppressWarnings("deprecation")
public class View implements Observer {

	
	TelegramBot bot = TelegramBotAdapter.build("863572721:AAFBeRUCI50S6uDtfGfK36EIntTquHJg0_E");
	
	//Object that receives messages
	GetUpdatesResponse updatesResponse;
	//Object that send responses
	SendResponse sendResponse;
	//Object that manage chat actions like "typing action"
	BaseResponse baseResponse;
	
	String[] genres = { 
			"COMEDIA", 
			"SUSPENSE", 
			"FICCAO",
			"ACAO",
			"ANIMACAO",
			"AVENTURA",
			"CULT",
			"DOCUMENTARIO",
			"TRASH",
			"ROMANCE",
			"FANTASIA",
			"DRAMA"
	};
	
	int queuesIndex = 0;
	
	ControllerSearch controllerSearch; //Strategy Pattern -- connection View -> Controller
	
	boolean searchBehaviour = false;
	
	private Model model;
	
	public View(Model model){
		this.model = model; 
	}
	
	public void setControllerSearch(ControllerSearch controllerSearch) { //Strategy Pattern
		this.controllerSearch = controllerSearch;
	}
	
	public void receiveUsersMessages() {
		
		//infinity loop
		while (true){
			
			//taking the Queue of Messages
			updatesResponse =  bot.execute(new GetUpdates().limit(100).offset(queuesIndex));
			
			//Queue of messages
			List<Update> updates = updatesResponse.updates();

			//taking each message in the Queue
			for (Update update : updates) {
				
				//updating queue's index
				queuesIndex = update.updateId() + 1;
				
				if(this.searchBehaviour == true){
					this.callController(update);
					
				} else if (update.message().text().equals("/movie")) {
					setControllerSearch(new ControllerMovie(model, this));
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(),"Digite o ID do filme que deseja."));
					this.searchBehaviour = true;
					
				} else if (update.message().text().equals("/genres")) {
					setControllerSearch(new ControllerMovie(model, this));
					
					for (String genre: genres) {
						sendResponse = bot
								.execute(new SendMessage(update.message().chat().id(), genre));
					}	
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(),"Digite um dos gêneros indicados acima."));
					this.searchBehaviour = true;
				
				} else if (update.message().text().equals("/help")) {
					setControllerSearch(new ControllerMovie(model, this));
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(),
							"Comandos: " + "\n" +
								"/start - Inicia o bot" + "\n" +
								"/genres - Informa todos os gêneros disponíveis" + "\n" +
								"/movie - Para saber mais informações do filme indicado."));
					this.searchBehaviour = true;
				
				} else if (update.message().text().equals("/start")){
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(),"Olá, bem-vindo ao movie2U." + "\n" + 
									"Envie /help para qualquer dúvida."));
				} else {
					sendResponse = bot
						.execute(new SendMessage(update.message().chat().id(),"Digite /genres para verificar os gêneros de filme disponíveis."));
				}
				
			}

		}
		
	}
	
	public void callController(Update update){
		this.controllerSearch.search(update);
	}
	
	public void update(long chatId, String movieDatas){
		sendResponse = bot
				.execute(new SendMessage(chatId, movieDatas));
		this.searchBehaviour = false;
	}
	
	public void sendTypingMessage(Update update){
		baseResponse = bot
				.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.name()));
	}
}