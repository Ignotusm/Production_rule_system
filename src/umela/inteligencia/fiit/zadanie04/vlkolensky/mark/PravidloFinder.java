package umela.inteligencia.fiit.zadanie04.vlkolensky.mark;

public class PravidloFinder {

	//Vyhladat potencialne
	
	StringMaker sm = new StringMaker();
	Fakty fakt = new Fakty();
	Potencial pot = new Potencial();
	
	public void searchForPotencial() {
	
		boolean isIt = true;
		
	//1. hladam take fakty do coho mozem napisat premanna , ked existuje similarne fakty ako podmienky tak prepisem v instancii nezname co su vo faktoch
		
		//pozriem na vsetke pravidla
		for(int i=0;i<sm.rules.size();i++) {
			
		
			//kontrolujem similarity pre kazde podmienku co maju 
			for(int j = 0 ; j<sm.rules.get(i).getPodmienka().length;j++) {
			
			
				
				//pozriem vsetke fakty
				for(int k = 0 ; k < fakt.fakty.size();k++) {

					//kontrolujem ci sa podobaju
					
					String[] prav = sm.rules.get(i).getPodmienka()[j].split(" ");
					String[] faktum = fakt.fakty.get(k).split(" ");
					

					//kontrolujem ci je ozaj sa podobaju aj vo velkosti 
					
					if(faktum.length!=prav.length) {
						isIt=false;
						
					}else {
						
						for(int l = 0;l<prav.length;l++) {
							
							if(prav[l].charAt(0)=='?') {
								continue;
							}
							if(prav[l].equals(faktum[l])==false) {
								
								
								isIt=false;
								break;
							}
							
						}
						
					}
				
					//ked sa nepodobaju tak idem dalej 
					
					if(isIt==false) {
				
						isIt=true;
						continue;
					}
					

					
	//2. ked najdem podobny fakt ako podmienka tak prepisem z toho nezname 
					//vytvorim novu instancii pravidlo
					
					Pravidlo nPravidlo = new Pravidlo();
					
					nPravidlo.setName(sm.rules.get(i).getName());
					nPravidlo.setPodmienka(sm.rules.get(i));
					nPravidlo.setPrikaz(sm.rules.get(i).getPrikaz());
					
					//do noveho zapisem variables
					
					String premenna;
					
					
					for(int a = 0;a<prav.length;a++) {
						
						if(prav[a].charAt(0)=='?') {
							
							premenna=prav[a];
							

							for(int b =0;b<nPravidlo.getPodmienka().length;b++) {
								
								nPravidlo.getPodmienka()[b]=nPravidlo.getPodmienka()[b].replace(premenna, faktum[a]);
							
							}
							
							nPravidlo.setPrikaz(nPravidlo.getPrikaz().replace(premenna, faktum[a]));
							
						}
						
					}

	//3. pridam do potencialnych
					
					pot.potencial.add(nPravidlo);
						
					
				}
			}
		}
		
	}
}
