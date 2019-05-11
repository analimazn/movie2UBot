
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import classes.*;
import model.*;
import view.*;
import service.*;

public class MainClass {

	private static Model model;
	
	public static void main(String[] args) throws ClientProtocolException, IOException {

		model = Model.getInstance();
		initializeModel(model);
		View view = new View(model);
		model.registerObserver(view); //connection Model -> View
		view.receiveUsersMessages();
	}
	
	public static void initializeModel(Model model) throws ClientProtocolException, IOException {
		JsonArray result = Connection.getMovies();
		for (JsonElement movie : result) {
			JsonObject mv = movie.getAsJsonObject();
			String id = mv.get("id").getAsString();
			String name = mv.get("name").getAsString();
			String director = mv.get("director").getAsString();
			String genre = mv.get("genre").getAsString();
			String year = mv.get("year").getAsString();
			model.addMovie(new Movie(id, name, director, genre, year));
		}
	}
}