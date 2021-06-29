package umela.inteligencia.fiit.zadanie04.vlkolensky.mark;

import java.util.ArrayList;

public class Pravidlo {
	
	//pravidlo class su pravidla ktore nacitam maju meno podmineky a prikaz
	
	private String name;
	private String[] podmienka;
	private String prikaz;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getPodmienka() {
		return podmienka;
	}
	
	public void setPodmienka(String[] podmienka) {
		this.podmienka=podmienka;
	}
	
	public void setPodmienka(Pravidlo p) {
		
		String[] pod = new String[p.getPodmienka().length];
		
		for(int i = 0 ; i < p.getPodmienka().length;i++) {
			pod[i]=p.getPodmienka()[i];
		}
		
		this.podmienka=pod;
		
	}
	public String getPrikaz() {
		return prikaz;
	}
	public void setPrikaz(String prikaz) {
		this.prikaz = prikaz;
	}
	
}
