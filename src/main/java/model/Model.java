package model;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import classes.Movie;

import utils.Subject;
import utils.Observer;

import com.pengrad.telegrambot.model.Update;

public class Model implements Subject {
	
	private List<Observer> observers = new LinkedList<Observer>();
	private List<Movie> movies = new LinkedList<Movie>();
	
	private Set<Movie> moviesSorted = new LinkedHashSet<Movie>();
	private List<Movie> moviesFound = new LinkedList<Movie>();
	
	private static Model uniqueInstance;
	private Model() {}
	
	public static Model getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Model();
		}
		return uniqueInstance;
	}
	
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void notifyObservers(long chatId, String moviesData) {
		for(Observer observer: observers){
			observer.update(chatId, moviesData);
		}
	}
	
	public void addMovie(Movie movie) {
		this.movies.add(movie);
	}

	public void searchMovie(Update update) {
		moviesFound.clear();
		moviesSorted.clear();
		
		String moviesData = null;
		
		for(Movie movie: movies) {
			if(movie.getGenre().toString().toLowerCase().equals(update.message().text().toLowerCase())) {
				moviesFound.add(movie);
			}
		}
		
		if (moviesFound.size() > 0) {
			Collections.shuffle(moviesFound);
			for (int i = 0; i <= 2; i++) {
				moviesSorted.add(moviesFound.get(i));
			}
			
			for (Movie movie: moviesSorted) {
				moviesData = movie.getResumeMovie();
				if (moviesData != null) {
					this.notifyObservers(update.message().chat().id(), moviesData);
				} else {
					this.notifyObservers(update.message().chat().id(), "Movie not found");
				}
			}
		}
	}
	
	public void aboutMovie(Update update) {
		String allInfoMovies = null;
		
		for(Movie movie: movies) {
			if(movie.getId().equals(update.message().text())) {
				allInfoMovies = movie.getMovie();
			}
		}
	
		if (allInfoMovies != null) {
			this.notifyObservers(update.message().chat().id(), allInfoMovies);
		}
	}
	
	@Override
	public void registerObserver(java.util.Observer observer) {
		// TODO Auto-generated method stub
		
	}

}
