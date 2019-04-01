
import classes.*;
import model.*;
import view.*;

public class MainClass {

	private static Model model;
	
	public static void main(String[] args) {

		model = Model.getInstance();
		initializeModel(model);
		View view = new View(model);
		model.registerObserver(view); //connection Model -> View
		view.receiveUsersMessages();

	}
	
	public static void initializeModel(Model model) {
		model.addMovie(new Movie("000", "Crazy, Stupid, Love", "Glenn Ficarra", Genre.COMEDIA, "2011"));
		model.addMovie(new Movie("001", "Easy A", "Will Gluck", Genre.COMEDIA, "2010"));
		model.addMovie(new Movie("002", "Mr. Right", "Paco Cabezas", Genre.COMEDIA, "2015"));
		model.addMovie(new Movie("003", "The Big Sick", "Michael Showalter", Genre.COMEDIA, "2017"));
		model.addMovie(new Movie("004", "Crazy Rich Asians", "Jon M. Chu", Genre.COMEDIA, "2018"));

		//Suspense
		model.addMovie(new Movie("005", "The Da Vinci Code", "Ron Howard", Genre.SUSPENSE, "2006"));
		model.addMovie(new Movie("006", "Miami Vice", "Michael Mann", Genre.SUSPENSE, "2006"));
		model.addMovie(new Movie("007", "The Prestige", "Christopher Nolan", Genre.SUSPENSE, "2006"));
		model.addMovie(new Movie("008", "Push", "Paul McGuigan", Genre.SUSPENSE, "2009"));
		model.addMovie(new Movie("009", "Stoker", "Park Chan-wook", Genre.SUSPENSE, "2013"));
		model.addMovie(new Movie("010", "Neon Demon", "Nicolas Winding Refn", Genre.SUSPENSE, "2016"));

		//Ficcao
		model.addMovie(new Movie("011", "District 9", "Neill Blomkamp", Genre.FICCAO, "2009"));
		model.addMovie(new Movie("012", "Arrival", "Denis Villeneuve", Genre.FICCAO, "2016"));
		model.addMovie(new Movie("013", "Avatar", "James Cameron", Genre.FICCAO, "2009"));
		model.addMovie(new Movie("014", "Inception", "Christopher Nolan", Genre.FICCAO, "2010"));
		model.addMovie(new Movie("015", "Edge of Tomorrow", "Doug Liman", Genre.FICCAO, "2014"));
		model.addMovie(new Movie("016", "Blade Runner 2049", "Denis Villeneuve", Genre.FICCAO, "2017"));

		//Acao
		model.addMovie(new Movie("017", "Avengers", "Joss Whedon", Genre.ACAO, "2012"));
		model.addMovie(new Movie("018", "Mad Max: Fury Road", "George Miller", Genre.ACAO, "2015"));
		model.addMovie(new Movie("019", "John Wick", "David Leitch", Genre.ACAO, "2014"));
		model.addMovie(new Movie("020", "300", "Zack Snyder", Genre.ACAO, "2006"));
		model.addMovie(new Movie("021", "Kick Ass", "Matthew Vaughn", Genre.ACAO, "2010"));

		//Animacao
		model.addMovie(new Movie("022", "Moana", "Ron Clements", Genre.ANIMACAO, "2016"));
		model.addMovie(new Movie("023", "Inside Out", "Pete Docter", Genre.ANIMACAO, "2015"));
		model.addMovie(new Movie("024", "Big Hero 6", "Don Hall", Genre.ANIMACAO, "2014"));
		model.addMovie(new Movie("024", "Coraline", "Henry Selick", Genre.ANIMACAO, "2009"));
		model.addMovie(new Movie("026", "Shrek", "Cicky Jenson", Genre.ANIMACAO, "2001"));

		//Aventura
		model.addMovie(new Movie("027", "Hunger Games", "Gary Ross", Genre.AVENTURA, "2012"));
		model.addMovie(new Movie("028", "The Hobbit", "Peter Jackson", Genre.AVENTURA, "2012"));
		model.addMovie(new Movie("029", "King Kong", "Peter Jackson", Genre.AVENTURA, "2005"));
		model.addMovie(new Movie("030", "Sherlock Holmes", "Guy Ritchie", Genre.AVENTURA, "2010"));
		model.addMovie(new Movie("031", "Star Trek", "J.J. Abrams", Genre.AVENTURA, "2009"));

		//Cult
		model.addMovie(new Movie("031", "Pulp Fiction", "Quentin Tarantino", Genre.CULT, "1994"));
		model.addMovie(new Movie("032", "Fight Club", "David Fincher", Genre.CULT, "1999"));
		model.addMovie(new Movie("033", "Clockwork Orange", "Stanley Kubrick", Genre.CULT, "1972"));
		model.addMovie(new Movie("034", "Scarface", "Brian De Palma", Genre.CULT, "1983"));
		model.addMovie(new Movie("035", "Showgirls", "Paul Verhoven", Genre.CULT, "1995"));

		//Documentario
		model.addMovie(new Movie("036", "Hot Girls Wanted", "Ronna Gradus", Genre.DOCUMENTARIO, "2015"));
		model.addMovie(new Movie("037", "Blackfish", "Gabriela Cowperthwaite", Genre.DOCUMENTARIO, "2013"));
		model.addMovie(new Movie("038", "Icaro", "Bryan Fogel", Genre.DOCUMENTARIO, "2017"));
		model.addMovie(new Movie("039", "Man on Wire", "James Marsh", Genre.DOCUMENTARIO, "2008"));
		model.addMovie(new Movie("040", "Jiro Dreams of Sushi", "David Gelb", Genre.DOCUMENTARIO, "2011"));

		//Thrash                                            
		model.addMovie(new Movie("041", "Machete", "Robert Rodriguez", Genre.TRASH, "2010"));
		model.addMovie(new Movie("042", "Plan 9 of Sidereal Space", "Ed Wood", Genre.TRASH, "1959"));
		model.addMovie(new Movie("043", "Drag me to Hell", "Sam Raimi", Genre.TRASH, "2009"));
		model.addMovie(new Movie("044", "Evil Dead 2", "Sam Raimi", Genre.TRASH, "1987"));
		model.addMovie(new Movie("045", "Sharknado", "David Michael Latt", Genre.TRASH, "2013"));

		//Romance
		model.addMovie(new Movie("046", "It Happened One Night", "James Wan", Genre.ROMANCE, "1934"));
		model.addMovie(new Movie("047", "Casablanca", "Frank Capra", Genre.ROMANCE, "1942"));
		model.addMovie(new Movie("048", "Carol", "Todd Haynes", Genre.ROMANCE, "2015"));
		model.addMovie(new Movie("049", "Singing in the Rain", "Gene Kelly", Genre.ROMANCE, "1952"));
		model.addMovie(new Movie("050", "Her", "Spike Jonze", Genre.ROMANCE, "2013"));

		//Fantasia                  
		model.addMovie(new Movie("051", "The Neverending Story", "Wolfgang Petersen", Genre.FANTASIA, "1984"));
		model.addMovie(new Movie("052", "Time Bandits", "Terry Gilliam", Genre.FANTASIA, "1981"));
		model.addMovie(new Movie("053", "Lost Horizon", "James Hilton", Genre.FANTASIA, "1937"));
		model.addMovie(new Movie("054", "Pan�s Labyrinth", "Guillermo del Toro", Genre.FANTASIA, "2006"));
		model.addMovie(new Movie("055", "Orlando", "Sally Potter", Genre.FANTASIA, "1992"));

		//Drama             
		model.addMovie(new Movie("056", "12 Years a Slave", "Steve McQueen", Genre.DRAMA, "2013"));
		model.addMovie(new Movie("057", "Citizen Kane", "Orson Welles", Genre.DRAMA, "1941"));
		model.addMovie(new Movie("058", "All About Eve", "Joseph L. Mankiewicz", Genre.DRAMA, "1950"));
		model.addMovie(new Movie("059", "Metropolis", "Fritz Lang", Genre.DRAMA, "1927"));
		model.addMovie(new Movie("060", "Moonlight", "Barry Jenkins", Genre.DRAMA, "2016"));
	}

}