package umela.inteligencia.fiit.zadanie04.vlkolensky.mark;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Fakty {

	public static ArrayList<String> fakty = new ArrayList<>(); 
	
	public void nacitajFakty() throws FileNotFoundException {
		
		//File file = new File("C:\\JavaProgramok\\UIZadanie4\\UIZadanie4\\src\\Fakty.txt");
		
		//keby nenasiel fakty.txt tak mozeme pouzivat kod co je hore a pridat cely path pre file
		
		URL url = getClass().getResource("Fakty.txt");
		File file = new File(url.getPath());
		
		Scanner scanner = new Scanner(file);
		
		//nacitam do faktoch
		
		while(scanner.hasNext()) {
			
			fakty.add(scanner.nextLine());
			
		}

		String sentence;

		//prepisem fakty tak ako preman vyhovuje , cize zostanu iba vety.
		
		for(int i=0;i<fakty.size();i++) {
			sentence = fakty.get(i).replace("(", "");
			sentence = sentence.replace(")", "");
			fakty.set(i, sentence);
		}
		
	}
	
	//vypise vsetky fakty
	public void printFakty() {
		
		for(int i=0;i<fakty.size();i++) {
			System.out.println(fakty.get(i));
		}
		
	}
	
}
