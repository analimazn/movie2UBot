package classes;

public class Movie {
	private String id;
	private String name;	
	private String director;
	private Genre genre;
	private String year;
		
	public Movie(String id, String name, String director, Genre genre, String year){
		this.id = id;
		this.name = name;
		this.director = director;
		this.genre = genre;
		this.year = year;		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public boolean compare(Genre genre, String director, String year){
		if(genre.equals(this.genre) && director.equals(this.director) && year.equals(this.year)){
			return true;
		} else {
			return false;
		}
	}
	
	public String getMovie() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: " + this.id).append("\n");
		sb.append("Nome: " + this.name).append("\n");
		sb.append("Diretor " + this.director).append("\n");
		sb.append("Gênero: " + this.genre).append("\n");
		sb.append("Ano: " + this.year).append("\n");
		return sb.toString();
	}
	
	public String getResumeMovie() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: " + this.id).append("\n");
		sb.append("Nome: " + this.name).append("\n");
		return sb.toString();
	}
}
