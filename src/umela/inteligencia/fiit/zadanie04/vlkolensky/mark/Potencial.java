package umela.inteligencia.fiit.zadanie04.vlkolensky.mark;

import java.util.ArrayList;

public class Potencial {
	
	public static ArrayList<Pravidlo> potencial = new ArrayList<>();
	Fakty fakt = new Fakty();
	
	/* tot je len na vypisovanie potencielne aplikovatelnych
	public void printPotencial() {
		
		for(int i = 0 ; i < potencial.size();i++) {
			
			for(int j=0;j<potencial.get(i).getPodmienka().length;j++) {
				
				System.out.print(potencial.get(i).getPodmienka()[j]+"   ");
				
			}
			
			System.out.println();
			
		}
		
	}
	*/
	
	//vyhladam vsetky nezname premenna
	public void searchForAllVariables() {
		
		boolean isIt=true;
		boolean theEnd = false; 
		
		while(theEnd!=true) {
		
		//nacitam potencialnych do pomecneho listu a potom pridem iba odfiltrovane do potencialnych
		
		ArrayList<Pravidlo> pot = new ArrayList<>();
		
		for(int i = 0;i<potencial.size();i++) {
			pot.add(potencial.get(i));
		}
		
		potencial.clear();
		
		//1.kontrolujem vsetky potencialnych instancii
		
		for(int i = 0 ; i < pot.size();i++) {
		
		//2. vyberiem podmienku
		
			for(int j = 0 ; j < pot.get(i).getPodmienka().length;j++) {
				
	
		//3. hladam vsetke podmienky kde su este nezname premenna
				
				if(pot.get(i).getPodmienka()[j].indexOf('?')==-1) {
					theEnd=true;
					continue;
				}else {
					theEnd=false;

					
					//ked som to nasiel tak idem hladat ci existuje taka pravidlo ked hej tak dom do potencialnych este raz ked neexistuje take pravidlo
					//tak to odfiltrujem a nedam do potencialnych
					
					for(int k=0;k<fakt.fakty.size();k++) {
						
						String[] prav = pot.get(i).getPodmienka()[j].split(" ");
						String[] faktum = fakt.fakty.get(k).split(" ");
						

						if(faktum.length!=prav.length) {
							isIt=false;

						}else {
							
							for(int l =0 ;l < prav.length;l++) {
								if(prav[l].charAt(0)=='?') {
									continue;
								}
								if(prav[l].equals(faktum[l])==false) {
									
									isIt=false;
									
									break;
									
								}
								
							}
							
	
						}
						
						if(isIt==false) {
							
							isIt=true;
							continue;
						}
						
						
						//4. nezname premenna v instancii ked som nasiel fakt tak zmenim aj v instancii neznamu premennu na znamu fakt. 
						
						Pravidlo nPravidlo = new Pravidlo();
						nPravidlo.setName(pot.get(i).getName());
						nPravidlo.setPodmienka(pot.get(i));
						nPravidlo.setPrikaz(pot.get(i).getPrikaz());
						
						String premenna;
						
						for(int a=0;a<prav.length;a++) {
							
							if(prav[a].charAt(0)=='?') {
								
								premenna=prav[a];
	
								for(int b = 0 ; b < nPravidlo.getPodmienka().length;b++) {
									
									nPravidlo.getPodmienka()[b]=nPravidlo.getPodmienka()[b].replace(premenna, faktum[a]);
									
								}
								
								nPravidlo.setPrikaz(nPravidlo.getPrikaz().replace(premenna, faktum[a]));
								
							}
							
						}
						
						//pridam do potencialnyhc
						potencial.add(nPravidlo);
						
					}
					
				}
			
		
		//5. idem odfiltrovat aj ostatne
				
			}
				
		}
		
		}
		
	}
	
	
	//vyriesim specialnu pripady
	
	public void vyriesSpecial() {
		
		ArrayList<Pravidlo> pot = new ArrayList<>();
		boolean isOk = true;
		
		
		for(int i = 0;i<potencial.size();i++) {
			pot.add(potencial.get(i));
		}
		
		potencial.clear();
		
		
		//1.kontrolujem vsetky potencialny pirapad , ked tam existuje specialna podmiana tak to idem vyriesit
		
		for(int i = 0 ; i < pot.size();i++) {
		
		//2. vyhladam specialnu podmienku
		
			for(int j = 0 ; j < pot.get(i).getPodmienka().length;j++) {
		
				if(pot.get(i).getPodmienka()[j].contains("<>")) {
					
					String[] control = pot.get(i).getPodmienka()[j].split(" ");
					
					if(control[1].equals(control[2])) {
						isOk=false;
					}else {
						isOk=true;
					}
					
					
				}else {
					
					isOk=true;
					
				}
				
				
		//3.ked specialne podmienka je dobry tak pridam do potencialnych ked nie tak odfiltrujem to
			
			}
			
			if(isOk) {
				
				potencial.add(pot.get(i));
				
			}
		
		}
		
	}
	

}
