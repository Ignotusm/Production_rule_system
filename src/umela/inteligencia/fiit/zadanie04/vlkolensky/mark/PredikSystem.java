package umela.inteligencia.fiit.zadanie04.vlkolensky.mark;

import java.io.FileNotFoundException;

public class PredikSystem {

	
	public void predikSys() throws FileNotFoundException {
	
	StringMaker sm = new StringMaker();
	Fakty f = new Fakty();
	PravidloFinder pf = new PravidloFinder();
	Potencial pot = new Potencial();
	Prikaz prikaz = new Prikaz();
	
	boolean running = true;
	
	//nacita fajly a urobi z tych potrebne zoznamy 
	
	f.nacitajFakty();
	sm.readPravidlo();
	sm.makeRules();
	
	//zacina 
	while(true) {
		
		//vyhladame potencialnych
		
		pf.searchForPotencial();
		
		if(pot.potencial.isEmpty()) {
			break;
		}
		
		//hladame naviazenie pre potencialov
		
		pot.searchForAllVariables();
		
		//ked sme hotovy tak idem vyrieset potencialnych
		
		pot.vyriesSpecial();
		
		//urobim prvy prykaz co mozem
		
		running = prikaz.vykonajPrykaz();
		
		if(running == false) {
			break;
		}
		
		
	}
		
	System.out.println();
	//ked uz urobili sme vsetko tak koncime a vypiseme fakty co sme dostali pocas behu programu
	f.printFakty();
	
	
	}
}
