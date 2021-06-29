package umela.inteligencia.fiit.zadanie04.vlkolensky.mark;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class StringMaker {
	
	public static ArrayList<String> pravidla = new ArrayList<String>();
	public static ArrayList<Pravidlo> rules = new ArrayList<>();
	
	
	//zacita a vytvori pravidla
	
	public void readPravidlo() throws FileNotFoundException {
			
			//File file = new File("C:\\JavaProgramok\\UIZadanie4\\UIZadanie4\\src\\Pravidla.txt");
			
			URL url = getClass().getResource("Pravidla.txt");
			File file = new File(url.getPath());
			
			Scanner scanner = new Scanner(file);
			
			String veta = null;
			
			while(scanner.hasNext()) {
				
				pravidla.add(scanner.nextLine());
				
			}
			
			for(int i = 0; i < pravidla.size();i++) {
				
				veta = pravidla.get(i);
				veta = veta.replace(")(", ",");
				veta = veta.replace("(", "");
				veta = veta.replace(")", "");
				veta = veta.replace("AK ","");
				veta = veta.replace("POTOM ","");
				pravidla.set(i, veta);
				
				if(pravidla.get(i).equals("")) {
					pravidla.remove(i);
				}
				
			}
		
	}
	
	
	
	/* vypise pravidala
	public void printPravidla() {
		
		for(int i=0;i<pravidla.size();i++) {
			System.out.println(pravidla.get(i));
		}
		
	}
	
	*/
	// zoberie podmienky na vety
	public String[] makePodmienky(String s) {
		
			String[] podmienky = s.split(",");
			
			return podmienky;
		
	}
	//urobit zoznam rules
	public void makeRules() {
		
		int i = 0;
		String podmienka;
		
		while(true) {
			
			Pravidlo r = new Pravidlo();
			
			
			r.setName(pravidla.get(i++));
			r.setPodmienka(makePodmienky(pravidla.get(i++)));
			r.setPrikaz(pravidla.get(i++));
			
			
			rules.add(r);
			

			if(i==pravidla.size()) {
				break;
			}
			
		}
		
		
	}
	
	
	/* vypise rules
	public void printRules() {
		
		for(int i = 0 ; i <rules.size();i++) {
			System.out.println();
			System.out.println(rules.get(i).getName()+" "+rules.get(i).getPrikaz());
		}
		
	}
	*/
	//make search string
	
	//tu kontrolujem ci dany fakt a podmienka je podobny alebo nie
	
	public boolean isSimilar(Pravidlo pravidlo,String faktum,int num) {
		
		boolean isIt = true;
		
		String[] prav = pravidlo.getPodmienka()[num].split(" ");
		String[] fakt = faktum.split(" ");
		
		if(fakt.length!=prav.length) {
			return false;
		}else {
			
			for(int i = 0;i<prav.length;i++) {
				
				if(prav[i].charAt(0)=='?') {
					continue;
				}else if(prav[i]!=fakt[i]) {
					return false;
				}
				
			}
			
		}
		
		//ked je vsetko ok vytvorim novy pravidlo
		
		Pravidlo nPravidlo = new Pravidlo();
		
		
		nPravidlo.setName(pravidlo.getName());
		nPravidlo.setPodmienka(pravidlo.getPodmienka());
		nPravidlo.setPrikaz(pravidlo.getPrikaz());
		
		//do noveho zapisem variables
		
		String premenna;
		
		for(int i = 0;i<prav.length;i++) {
			
			if(prav[i].charAt(i)=='?') {
				
				premenna=prav[i];
				for(int j =0;j<nPravidlo.getPodmienka().length;j++) {
					
					nPravidlo.getPodmienka()[j].replace(premenna, fakt[i]);
					
				}
				
			}
			
		}
		
		
		return isIt;
		
	}
	
	

}
