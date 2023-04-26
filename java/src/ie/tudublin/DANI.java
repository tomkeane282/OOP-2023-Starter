package ie.tudublin;

import java.util.ArrayList;
import processing.data.TableRow;
import processing.data.Table;
import processing.core.PApplet;

public class DANI extends PApplet {

	

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

    String[] sonnet;

    public String[] writeSonnet()
    {
        return null;
    }

	
	public void setup() {
		colorMode(HSB);
		
		//Load file
		String[] lines = loadStrings("data/small.txt");

		
		for (String line : lines) 
		{
		  String[] words = split(line, " ");

		  // Print words
		  for (String word : words) {
			System.out.println(word);
		  }
		}

		
	}

	public void keyPressed() {

	}

	float off = 0;

	public void draw() 
    {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
        textAlign(CENTER, CENTER);
        
	}
}
