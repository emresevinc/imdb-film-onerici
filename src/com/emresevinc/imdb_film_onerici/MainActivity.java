package com.emresevinc.imdb_film_onerici;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.support.v7.app.ActionBarActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	ArrayList<StringBuilder> strs = null;
	String[] files={"imdb2.json","imdb3.json","imdb4.json","imdb5.json",
			"imdb6.json","imdb7.json","imdb8.json","imdb9.json"};
	ArrayList<JSONObject> JSONObjects= null;
	ArrayList<Movies> movies =null;
	ImageView imageView = null;
	TextView titTv, yearTv, ratedTv, relaesedTv, runtimeTv,genreTv,directorTv,writerTv,
		actorsTv, plotTv, languageTv,countryTv,awardsTv,metascoreTv,IMDBRatingTv,IMDBVotesTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strs = new ArrayList<StringBuilder>();
        JSONObjects = new ArrayList<JSONObject>();
        func(files);
        createJSONObjects(strs);
        movies = getJSONObjects();
        
        imageView = (ImageView)findViewById(R.id.imgView);
        titTv = (TextView) findViewById(R.id.titleTv);
        yearTv = (TextView) findViewById(R.id.yearTv);
        ratedTv = (TextView) findViewById(R.id.ratedTv);
        relaesedTv = (TextView) findViewById(R.id.relasedTv);
        runtimeTv = (TextView) findViewById(R.id.runtimeTv);
        genreTv = (TextView) findViewById(R.id.genreTv);
        directorTv = (TextView) findViewById(R.id.directorTv);
        writerTv = (TextView) findViewById(R.id.writerTv);
        actorsTv = (TextView) findViewById(R.id.actorsTv);
        plotTv = (TextView) findViewById(R.id.plotTv);
        languageTv = (TextView) findViewById(R.id.languageTv);
        countryTv = (TextView) findViewById(R.id.countryTv);
        awardsTv = (TextView) findViewById(R.id.awardsTv);
        metascoreTv = (TextView) findViewById(R.id.metascoreTv);
        IMDBRatingTv = (TextView) findViewById(R.id.imdbRatingTv);
        IMDBVotesTv = (TextView) findViewById(R.id.imdbVotesTv);
    }

    
    public void func(String[] dosyalar)
    {    	
    	StringBuilder buf = null;
    	InputStream is = null;
    	BufferedReader in = null;
        for(int i=0;i<dosyalar.length;i++){
	    	try {
	        	buf=new StringBuilder();
	            is = getAssets().open(dosyalar[i]);
	            in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	            String str;
	            while ((str=in.readLine()) != null) {
	               buf.append(str);
	            }
	            strs.add(buf);  			// json dosya içerikleri ekleniyor.
	    	}catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    	finally
	        {
	        	if (in != null) {
	                try {
	                    in.close();
	                } catch (IOException e) {
	                    Log.e("", "Buffered reader not closed.");
	                }
	            }
	        }
        }
    }
    
    public void createJSONObjects(ArrayList<StringBuilder> sbs)
    {
    	for (int i = 0; i < sbs.size(); i++) {
    		String s = sbs.get(i).toString();
			try {
				JSONObjects.add(new JSONObject(s)); //rootObjects added to list here. (jSON dosyalarýndaki ana yani üst objeler burada eklendi.)
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
    }
    
    // jSON dosyalarýnýn içerisindeki movies (filmler) bu fonksiyonla bir listeye ekleniyor.
    public ArrayList<Movies> getJSONObjects()
    {
    	ArrayList<Movies> movs = new ArrayList<Movies>();
    	try {
			for(JSONObject jObj : JSONObjects){
				JSONArray jArr = jObj.getJSONArray("movies"); // jSON dosyasýnda array olan movies'i deðiþkene atýyorum.
				int length = jArr.length(); // Array içindeki object sayýsý alýnýyor
				JSONObject jsonTemp = null;
				Movies movie = null;
				String title,year,rated,released,runtime,genre,director,writer,
					actors,plot,language,country,awards,poster,metascore,imdbRating,imdbVotes;
				for (int i = 0; i <length; i++) {
					jsonTemp = (JSONObject)jArr.get(i);
					title = jsonTemp.getString("Title");
					year = jsonTemp.getString("Year");
					rated = jsonTemp.getString("Rated");
					released = jsonTemp.getString("Released");
					runtime = jsonTemp.getString("Runtime");
					genre = jsonTemp.getString("Genre");
					director = jsonTemp.getString("Director");
					writer = jsonTemp.getString("Writer");
					actors = jsonTemp.getString("Actors");
					plot = jsonTemp.getString("Plot");
					language = jsonTemp.getString("Language");
					country = jsonTemp.getString("Country");
					awards = jsonTemp.getString("Awards");
					poster = jsonTemp.getString("Poster");
					metascore = jsonTemp.getString("Metascore");
					imdbRating = jsonTemp.getString("imdbRating");
					imdbVotes = jsonTemp.getString("imdbVotes");
					movie = new Movies(title, year, rated, released, runtime, genre, director,
							writer, actors, plot, language, country, awards, poster, metascore, imdbRating, imdbVotes);
					movs.add(movie);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
    	return movs;
    }
    
    static final Random random = new Random();
    public void showMovie(View v)
    {
    	
    	int i = random.nextInt(movies.size());
    	new Background().execute(movies.get(i).getPoster());
    	titTv.setText(movies.get(i).getTitle());
    	yearTv.setText(movies.get(i).getYear());
    	ratedTv.setText(movies.get(i).getRated());
    	relaesedTv.setText(movies.get(i).getReleased());
    	runtimeTv.setText(movies.get(i).getRuntime());
    	genreTv.setText(movies.get(i).getGenre());
    	directorTv.setText(movies.get(i).getDirector());
    	writerTv.setText(movies.get(i).getWriter());
    	actorsTv.setText(movies.get(i).getActors());
    	plotTv.setText(movies.get(i).getPlot());
    	languageTv.setText(movies.get(i).getLanguage());
    	countryTv.setText(movies.get(i).getCountry());
    	awardsTv.setText(movies.get(i).getAwards());
    	metascoreTv.setText(movies.get(i).getMetascore());
    	IMDBRatingTv.setText(movies.get(i).getImdbRating());
    	IMDBVotesTv.setText(movies.get(i).getImdbVotes());
    }
    
    public Bitmap LoadImageFromWebOperations(String url) {

		try {
			URL newurl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) newurl.openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream input = connection.getInputStream();
			Bitmap bitmap = BitmapFactory.decodeStream(input);
			return bitmap;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
    	
    }
    
  private class Background extends AsyncTask<String,Void,Bitmap> {

    	@Override
    	protected void onPreExecute() {
    		super.onPreExecute();
    		
    	}
    	
    	@Override
    	protected Bitmap doInBackground(String... params) {
    		
    		try {
    			URL newurl = new URL(params[0]);
    			HttpURLConnection connection = (HttpURLConnection) newurl.openConnection();
    			connection.setDoInput(true);
    			connection.connect();
    			InputStream input = connection.getInputStream();
    			Bitmap bitmap = BitmapFactory.decodeStream(input);
    			return bitmap;
    		} catch (MalformedURLException e) {
    			e.printStackTrace();
    			return null;
    		} catch (IOException e) {
    			e.printStackTrace();
    			return null;
    		} 
    	}

    	@Override
    	protected void onPostExecute(Bitmap result) {
    		super.onPostExecute(result);
    		imageView.setImageBitmap(result);
    	}


    }
}
