import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ClasaP {

	public static void main(String[] args) {
		ArrayList<Cititor>Slist=new ArrayList<Cititor>();  //LISTA PENTRU CITITOR    CREARE LISTA DE CITITORI
		ArrayList<Carte>Clist=new ArrayList<Carte>();   // LISTA PENTRU CARTE        CREARE LISTA DE CARTI
			
		String a[]=new String[100];
		String b[]=new String[100];
		String d[]=new String[100];

		{	
			try {
			BufferedReader reader=new BufferedReader(new FileReader("Carti.txt"));    //CITIREA DIN FISIER
			
			//AFISAREA LINIILOR CITITE
			//System.out.println(reader.readLine());
			
			int i=0;
			
			
			//Citirea liniilor din fiser si crearea obiectelor Carte
			while(reader.ready()) {
				Clist.add(new Carte());  
				a[i]=reader.readLine();
				b[i]=a[i].substring(0, 3);
				Clist.get(i).setCod(b[i]);
				d[i]=a[i].substring(4,a[i].length());
				Clist.get(i).setTitlu(d[i]);
	
				i++;
				}

			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		//Adaugarea cititorilor in lista Slist
		Slist.add(new Cititor());
		Slist.get(0).setcodinreg("123");
		Slist.get(0).setNume("Georgescu");
		Slist.get(0).setPrenume("Ionut");
			
			Slist.add(new Cititor());
			Slist.get(1).setcodinreg("345");
			Slist.get(1).setNume("Grigorescu");
			Slist.get(1).setPrenume("Maria");
			
		
			Slist.add(new Cititor());
			Slist.get(2).setcodinreg("567");
			Slist.get(2).setNume("Moldovan");
			Slist.get(2).setPrenume("Ioana");
			
			//AFISARE CITITORI
			System.out.println("CITITORI:");
			for(Cititor str:Slist) {
				System.out.println(str.toString());
			}
			
			//AFISARE CARTI
			System.out.println("CARTI:");
			for(Carte cart:Clist) {
				System.out.println(cart.toString());
				//System.out.println(cart.getCod()+" "+cart.getTitlu());
			}
			
			
			Scanner sc=new Scanner(System.in);
			int nr=0;
			String id;
			int cnt1;
			int cnt2;
			int opt=0;
			
		/*
			//PARCURGERE LISTA DE CARTI+AFISARE
			System.out.println("CARTI DISPONIBILE:");
			for(Carte cart:Clist) {
				//System.out.println(cart);
				//System.out.println("CARTI DISPONIBILE:");
				System.out.println(cart.getCod()+" "+cart.getTitlu());
			}*/
			
			System.out.println("Introduceti ID-ul cititorului:");
			String cod;
			cod=sc.next();
			for(Cititor cit:Slist) {   //Procesul de parcurgere a listei de cititori
				if(cit.getCodinreg().equals(cod)) {   
					System.out.println("S-a gasit codul corespunzator studentului");
					//AFISARE CITITOR
					System.out.println(cit.getCodinreg()+" "+cit.getNume()+" "+cit.getPrenume());
					
					while(true) {
						System.out.println("OPTIUNI:");
						System.out.println("1.Imprumutati o carte");
						System.out.println("2.Returnati o carte");
						System.out.println("3.Interogare carti");
						System.out.println("4.Reintroducere alta persona+revenire la meniul principal");
						System.out.println("5.Sfarsit program");
						
						System.out.println("Scrieti obtiunea: ");
						opt=sc.nextInt();
						
							 if(opt==1) {
								 System.out.println("Ati selectat obtiunea de imprumut");
									System.out.println("Scrieti nr de carti pe care doriti sa le imprumutati");
									int nrI=sc.nextInt();
									
									cnt1=0;
									while(cnt1<=nrI) {
										cnt1=cnt1+1;
										System.out.println("Scrieti ID-ul cartii: ");
										id=sc.next();
										System.out.println(id);
											for(Carte cart:Clist) {
												if(cart.getCod().equals(id)) {
													System.out.println("S-a gasit Id-ul corespunzator cartii");
													cit.imprumut(cart);
												}
											}
											cnt1=cnt1+1;
										}
							 }
					
							 else if (opt==2) {
									System.out.println("Ati selectat obtiunea de returnare a cartii");
									System.out.println("Cate carti doriti sa returnati:");
									int nrR=sc.nextInt();
										
									cnt2=0;
									while(cnt2<=nrR) {
										cnt2=cnt2+1;
										System.out.println("Scrieti ID-ul cartii: ");
											
										id=sc.next();
										System.out.println(id);
											for(Carte cart:Clist) {
												if(cart.getCod().equals(id)) {
													System.out.println("S-a gasit Id-ul corespunzator cartii");
													cit.returnare(cart);
												}
											}
											cnt2=cnt2+1;
										}
								 }
							 
								else if(opt==3) {
									for(Cititor citi:Slist) {
										
										if(citi.getCodinreg().equals(cod)) {
											//cit.setcodinreg(cod);
									System.out.println("Ati selectat obtiunea de interogare a cartilor:");
									System.out.println("Studentul "+citi.getNume()+"  "+citi.getPrenume()+" "+ 
												"cu ID-ul "+citi.getCodinreg()+" are imprumutate urmatoarele carti:");
									cit.showCarti();
								 }
									}
										}		
								else if(opt==4) {
									cit.stergere();			
									 System.out.println("Introduceti ID-ul  cititorului:");
									 cod=sc.next();
										for(Cititor ci:Slist) {
											if(ci.getCodinreg().equals(cod)) {
												System.out.println("S-a gasit codul corespunzator studentului");
												//AFISARE CITITOR
												System.out.println(ci.getCodinreg()+ci.getNume()+ci.getPrenume());		
											}
										}
								 }
							 
								else if(opt==5) {
									break;
							}
						}
					}
				 
				}
			}	
		}


