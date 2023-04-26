package ie.tudublin;

import java.util.ArrayList;

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
		String[] lines = loadStrings("data/longertest.txt");
		ArrayList<String> words = new ArrayList<String>();
		

		for (int i = 0; i < lines.length; i++) {
            String[] tokens = split(lines[i], " ");
            for (int j = 0; j < tokens.length; j++) {
                if (j == tokens.length - 1) {
                    //no word after
                    words.add(tokens[j]);
                } else {
                    //Add word and next word
                    words.add(tokens[j] + " " + tokens[j+1]);
                }
            }
        }

		println(words);

		//COWABUNGA

		ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> firstWords = new ArrayList<String>();

        for (String element : words) {
            String[] wordList = element.split(" ");
            String firstWord = wordList[0];

            if (firstWords.contains(firstWord)) 
			{
                for (String existingElement : result) 
				{
                    if (existingElement.startsWith(firstWord)) 
					{
                        String newElement = existingElement;


                        for (int i = 1; i < wordList.length; i++) 
						{
                            newElement += " " + wordList[i];
                        }

						
                        result.set(result.indexOf(existingElement), newElement);
                        break;
                    }
                }
            } 
			else 
			{
                firstWords.add(firstWord);
                result.add(element);
            }
        }

        println(result);

		
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
