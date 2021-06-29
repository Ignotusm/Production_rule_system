package umela.inteligencia.fiit.zadanie04.vlkolensky.mark;

public class Prikaz {

	Potencial pot = new Potencial();
	Fakty fakty = new Fakty();
	
	public boolean vykonajPrykaz() {
		
		boolean isOK=true;
		int num=0;
		
		
		//pozriam se na potencialnych
		for(int potNum = 0 ; potNum <pot.potencial.size();potNum++) {
			
			isOK = true;
			
			//rozoberam prikaz na nacasti aby som dostal vety
			String[] prikazy = pot.potencial.get(potNum).getPrikaz().split(",");
			
			//skontrolujem ci su dobre
			for(int i = 0 ; i < prikazy.length;i++) {
				
				if(checkPrikaz(prikazy[i])==false) {
					
					isOK=false;
					
				}
				
			}
			
			if(isOK == true) {
				num = potNum;
				
	
				break;
			}else {
				
				continue;	
			}
			
			
		}
		
		if(isOK) {

		//vykoname prikaz ked vsetko je dobre
		
		//rozoberema na vety a urobime prikazy
			
		String[] orders = pot.potencial.get(num).getPrikaz().split(",");
		
		for(int i = 0;i<orders.length;i++) {
			
	
			doTheOrder(orders[i]);
			
		}
	
		
			return true;
		}else {
			return false;
		}
		
	}
	
	
	//tu vykoname prikazy
	
	public void doTheOrder(String order) {
		
		
		String[] prikazy = order.split(",");
		
		for(int i = 0 ; i < prikazy.length;i++) {
			
			if(prikazy[i].contains("pridaj")) {
				
				String prikaz = prikazy[i];
				
				prikaz=prikaz.replace("pridaj ", "");
				
				fakty.fakty.add(prikaz);
				
			}else if(prikazy[i].contains("vymaz")) {
				
				String prikaz = prikazy[i];
				
				prikaz=prikaz.replace("vymaz ", "");
				
				for(int j = 0 ; j < fakty.fakty.size();j++) {
					if(prikaz.equals(fakty.fakty.get(j))) {
						fakty.fakty.remove(j);
						break;
					}
				}
				
			}else if(prikazy[i].contains("sprava")) {
				
				String prikaz = prikazy[i];
				
				prikaz=prikaz.replace("sprava ", "");
				
				System.out.println(prikaz);
				
			}
			
		}
		
		
	}
	
	//kontruljeme ci prikaz co chceme vykonat je dobr
	public boolean checkPrikaz(String prikaz) {
		
		boolean isOk=false;
		
		//kontroluje pri pridanie ci este neexistuje fakt ktori chceme pridat
		if(prikaz.contains("pridaj")) {
			
			prikaz = prikaz.replace("pridaj ", "");
			
			return hladajFakt(prikaz);
			
			//kontroluje ci existuje fakt ktrory chcem vymazat zo zoznam faktov
		}else if (prikaz.contains("vymaz")) {
			
			prikaz = prikaz.replace("vymaz ", "");
			
			if(hladajFakt(prikaz)==false) {
				return true;
			}else {
				return false;
			}
			//ked je to sprava tak vrati true lebo to iba vypisuje spravu
		}else if (prikaz.contains("sprava")) {
			
			prikaz = prikaz.replace("sprava ", "");
			
			return true;
			
		}
		
		return isOk;
	}
	
	//tu kontrulje ci uz existuje dany fakt alebo nie
	
	public boolean hladajFakt(String prikaz) {
		
		for(int i = 0 ; i < fakty.fakty.size();i++) {
			
			if(prikaz.equals(fakty.fakty.get(i))) {
				return false;
			}
			
		}
		
		return true;
		
	}
	
}
