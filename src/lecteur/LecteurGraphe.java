package lecteur;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import algorithme.IGraph;
import algorithme.ChoixAlgo;
import graphes.GrapheLA;


public class LecteurGraphe{
	public static void main(String args[]) {
		File f= new File("Graphe1.txt");
		try {
			Scanner sc=new Scanner(f);
			String lecture=sc.nextLine();
			int nbNoeuds=Integer.parseInt(lecture.trim());
			IGraph g=new GrapheLA(nbNoeuds);
			while(sc.hasNextLine()) {
				lecture=sc.nextLine();
				if(lecture.trim()=="") {
					continue;
				}
				String[] s=lecture.split(" ");
				int depart=Integer.parseInt(s[0]);
				int arrive=Integer.parseInt(s[2]);
				if (!sc.hasNextLine()) {
					ChoixAlgo.choix(g, depart, arrive);
					sc.close();
					System.exit(0);
				}
				else {
					int val=Integer.parseInt(s[1]);
					g.ajouterArc(depart, arrive, val);
				}
			}
			sc.close();
			throw new RuntimeException("Le départ et l'arrivé sont introuvables");
		} catch (FileNotFoundException e) {
			System.out.println("Le fichier est introuvable");
			System.exit(1);
		}

	}
}