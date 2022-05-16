package algorithme;

import java.util.ArrayList;

public class ChoixAlgo {
	public static void choix(IGraph g,int d,int a) {
		ArrayList<Integer> rep;
		try{
			rep=PCCBellman.algo(g, d, a);
			System.out.println("Bellman sans circuit");
		}
		catch(CircuitEx e) {
			try {
				rep=PCCDijkstra.algo(g, d, a);
				System.out.println("Dijkstra");
			}
			catch(ArcNégatifEx ex){
				throw new RuntimeException("Le graphe est incompatible avec les deux algorithmes");
			}
			catch(NoPathEx exc) {
				System.out.println("pas de chemin entre "+d+" et "+a);
				return;
			}
		}
		catch(NoPathEx ex) {
			System.out.println("pas de chemin entre "+d+" et "+a);
			return;
		}
		System.out.println(longueur(g,rep));
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<rep.size();++i) {
			sb.append(rep.get(i)+" ");
		}
		System.out.println(sb.toString());
	}
	private static int longueur(IGraph g,ArrayList<Integer> liste) {
		int rep=0;
		for(int i=1;i<liste.size();++i) {
			rep+=g.getval(liste.get(i-1),liste.get(i));
		}
		return rep;
	}
}
