package br.com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;

/*
 * Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
public class GoogleShortner {

	public static void main(String[] args) throws JSONException, IOException {
		String urlShort = shortURL("www.globo.com");
		System.out.println("URL Shortener: " + urlShort);
	}

	public static String shortURL(String url) throws JSONException, IOException {
		// String host = "https://www.googleapis.com/urlshortener/v1/url";
		String host = "https://www.googleapis.com/urlshortener/v1/url?key=AIzaSyA_w5VCHFUNWdRKhPsH3Fa8zaMlFo8UCnE";
		URL obj = new URL(host);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		con.setRequestProperty("Content-Type", "application/json");
		// add reuqest header
		con.setRequestMethod("POST");
		// con.setRequestProperty("User-Agent", "Mozilla/5.0");
		// con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "{\"longUrl\": \"" + url + "\"}";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + host);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		JSONObject object = new JSONObject(response.toString());

		return object.getString("id");

	}

}
