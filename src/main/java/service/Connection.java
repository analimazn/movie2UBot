package service;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Connection {
	public static JsonArray getMovies() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpUriRequest httpUriRequest = new HttpGet("http://0.0.0.0:6060/movies");
		httpUriRequest.addHeader("accept", "application/json");
		HttpResponse response = client.execute(httpUriRequest);
		String json = EntityUtils.toString(response.getEntity());
		JsonParser parser = new JsonParser();
		JsonArray rootObj = parser.parse(json).getAsJsonArray();    
		return rootObj;
	}
}
