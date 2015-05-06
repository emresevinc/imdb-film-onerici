package com.emresevinc.imdb_film_onerici;

public class Movies {

	String title;
	String year;
	String rated;
	String released;
	String runtime;
	String genre;
	String director;
	String writer;
	String actors;
	String plot;
	String language;
	String country;
	String awards;
	String poster;
	String metascore;
	String imdbRating;
	String imdbVotes;
	
	public Movies(String tit,String yea,String rat,String rel,String run,String gen,String dir,String wri,String act,
			String plo,String lan,String cou,String awa,String pos,String met,String imdbRat,String imdbVot) {
		this.title = tit;
		this.year = yea;
		this.rated = rat;
		this.released = rel;
		this.runtime=run;
		this.genre=gen;
		this.director=dir;
		this.writer=wri;
		this.actors=act;
		this.plot=plo;
		this.language=lan;
		this.country=cou;
		this.awards=awa;
		this.poster=pos;
		this.metascore=met;
		this.imdbRating=imdbRat;
		this.imdbVotes=imdbVot;
	}
	
	
	public String getTitle() {
		return title;
	}
	public String getYear() {
		return year;
	}
	public String getRated() {
		return rated;
	}
	public String getReleased() {
		return released;
	}
	public String getRuntime() {
		return runtime;
	}
	public String getGenre() {
		return genre;
	}
	public String getDirector() {
		return director;
	}
	public String getWriter() {
		return writer;
	}
	public String getActors() {
		return actors;
	}
	public String getPlot() {
		return plot;
	}
	public String getLanguage() {
		return language;
	}
	public String getCountry() {
		return country;
	}
	public String getAwards() {
		return awards;
	}
	public String getPoster() {
		return poster;
	}
	public String getMetascore() {
		return metascore;
	}
	public String getImdbRating() {
		return imdbRating;
	}
	public String getImdbVotes() {
		return imdbVotes;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public void setReleased(String released) {
		this.released = released;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	
	
}
