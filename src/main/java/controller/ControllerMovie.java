package controller;

import com.pengrad.telegrambot.model.Update;
import model.Model;
import view.View;

public class ControllerMovie implements ControllerSearch {
	private Model model;
	private View view;
	
	public ControllerMovie(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void search(Update update) {
		view.sendTypingMessage(update);
		model.searchMovie(update);
		model.aboutMovie(update);
	}
}
