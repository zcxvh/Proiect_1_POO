import java.util.ArrayList;
import java.util.*;

public class Cititor {    //Clasa Cititor

	private String codInreg;    //atribute al clasei Cititor
	private String nume;
	private String prenume;

	private  ArrayList<Carte>imprList=new ArrayList<Carte>();   //Creare lista de carti pentru cititorul selectat  

	
	public String toString()    //metoda de reprezentare sub forma textuala a unui obiect
	{
		return "Aceasta persoana are numele "+this.nume+" "+this.prenume+" si are cod "+this.codInreg;
	}
	
	public void setcodinreg(String codInreg) {
		this.codInreg=codInreg;
	}
	
	public void setNume(String nume) {
		this.nume=nume;
	}
	
	public void setPrenume(String prenume) {
		this.prenume=prenume;
	}
	
	
	public String getCodinreg() {
		return codInreg;
	}
	
	
	public String getNume() {
		return nume;
	}
	
	public String getPrenume() {
		return prenume;
	}
	
	//int i=0;
	public void imprumut (Carte impr) {     //metoda de imprumut a cartii
		boolean imprDeja=false;
		
		for(Carte imp:imprList) {
			if(imp.getCod().equals(impr.getCod())) {
				imprDeja=true;
				break;
			}
		}
		if(!imprDeja) {
			imprList.add(impr);
			System.out.println("Cartea "+impr.getTitlu()+" a fost imprumutata cu succes");
		}
		else {
			System.out.println("Cartea "+impr.getTitlu()+" a mai fost imprumutata");
		}
	}
	
	
	public void returnare (Carte ret) {   //metoda de returnare a cartii
		
		boolean retDeja=false;
		for(Carte cart:imprList) {
			
				if(cart.getCod().equals(ret.getCod())) {
					retDeja=true;
					break;
				}
			}
		if(retDeja) {
			imprList.remove(ret);
			System.out.println("Cartea "+ret.getTitlu()+" a fost returnata cu succes");
		}
		else {
			System.out.println("Cartea "+ret.getTitlu()+" deja a mai fost returnata");
		}
			
	}
	
	
	public void showCarti() {    //metoda de interogare a cartilor
		if(imprList.isEmpty()) {
			System.out.println("Nu are carti imprumutate");
		}
		else {
			System.out.println("Cartile imprumutate sunt:");
			for(Carte cart:imprList) {
				System.out.println(cart.getCod()+" "+cart.getTitlu()); 
			}
		
		}		
	}
	
	
	public void stergere() {    //stergere lista de carti imprumutate
		imprList.clear();
	}
	

}
	

