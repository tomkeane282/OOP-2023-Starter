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
		String[] lines = loadStrings("data/shakespere.txt");
		ArrayList<String> words = new ArrayList<String>();
		
		for (int i = 0; i < lines.length; i++) {
			String[] lineWords = split(lines[i], " ");
			for (int j = 0; j < lineWords.length; j++) {
				String w = lineWords[j].replaceAll("[^\\w\\s]",""); //punctuation
				String lowerW = w.toLowerCase(); //lowercase
				if (j == lineWords.length - 1) {
					//no word after
					words.add(lowerW);
				} else {    //Add word
					
					String nextW = lineWords[j+1].replaceAll("[^\\w\\s]",""); //Remove punctuation
					String lowerNextW = nextW.toLowerCase();   //lowercase
					words.add(lowerW + " " + lowerNextW);
				}
			}
		}
		//array before removing copies
		//println(words);

		/*

		Deleting duplicate words and appending the words that follow them

		*/


		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> firstWords = new ArrayList<String>();

		for (String element : words) 
		{
			String[] wordList = element.split(" ");
			/*String firstWord = wordList[0];*/
			//String[] wordList = { "" };
			String firstWord = "";
			if (wordList.length > 0) {
				firstWord = wordList[0];
			}


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

		//println(result);


		for (int i = 0; i < 14; i++) {
			// Pick a random starting element from the array
			String randomElement = result.get((int) random(result.size()));
		
			while (true) {
				// Split the element into words
				String[] words3 = randomElement.split(" ");
		
				// Pick a random word from the element (excluding the first word)
				int randomIndex = (int) random(1, words3.length);
				String randomWord = words3[randomIndex];
		
				// Print the first word and the random word (if there is one)
				System.out.print(words3[0] + " ");
				if (words3.length > 1) 
				{
					System.out.print(randomWord + " ");
				} 
				else 
				{
					break;  // exit loop if one-word element is picked
				}
		
				// Search for the element where the second word is the first word
				boolean found = false;
				for (String element : result) 
				{
					String[] words2 = element.split(" ");
					if (words2.length > 1 && words2[0].equals(randomWord)) 
					{
						randomElement = element;
						found = true;
						break;
					}
				}
				if (!found) 
				{
					break;  //exit loop 
				}
			}
		
			//new line after each sentence
			System.out.println();
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
