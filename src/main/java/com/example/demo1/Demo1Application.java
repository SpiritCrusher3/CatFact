package com.example.demo1;

import com.google.gson.Gson;

import com.google.gson.internal.$Gson$Preconditions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to this application!\nHere you will get cat facts printed ordered.");
		//Choose what API to consume
		URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
		//Instantiate a Buffered Reader to consume the InputStream from the URL
		BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));
		//Map the data from Json to an object
		CatFact data = new Gson().fromJson(inputFromCatURL, CatFact.class);
		//Close the BufferedReader
		inputFromCatURL.close();

		System.out.println(data.toString());

		//Add the data to an arraylist and sort them
		ArrayList<CatFact> catFacts = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
			BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));
			CatFact data = new Gson().fromJson(inputFromCatURL, CatFact.class);
			catFacts.add(data);
			Collections.sort(catFacts);
			System.out.println(data);
		}

	}
}
