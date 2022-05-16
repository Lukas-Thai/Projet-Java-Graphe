package algorithme;

import java.util.ArrayList;
import java.util.HashMap;

public class PCCDijkstra {
	public static ArrayList<Integer> algo(IGraph g, int a , int b){
		if(!estOK(g)) {
			throw new ArcNégatifEx();
		}
		ArrayList<Integer> rep=new ArrayList<>();
		boolean[] traite=new boolean[g.getNbNoeuds()];
		ArrayList<Integer[]> main=new ArrayList<>();;
		for(int i=0;i<traite.length;++i) {
			traite[i]=false;	//cette liste sert a determiner quel sommet a ete traite
			main.add(new Integer[2]); // la liste d'entier stock le cout total pour acceder a la case et le predecesseur pour y acceder
			main.get(i)[0]=null;
			main.get(i)[1]=null;
		}
		main.get(a-1)[0]=0;
		int posactuelle=a;
		HashMap<Integer,Integer> atest=new HashMap<>(); // on retient les chemins possible pour chaque sommet
		while(!traite[b-1]) {
			atest.putAll(g.getsucc(posactuelle)); //on met tout les successeur du sommet qu'on traite
			for(int i=0;i<g.getNbNoeuds();++i) {
				if(atest.containsKey(i)) {
					if(traite[i] ) {
					atest.remove(i);
					}
				}
			}
			if(atest.isEmpty()) { // on  a traite ce qu'on a pu
				break;
			}
			for(Integer i:atest.keySet()) {
				int poidstest=main.get(atest.get(i))[0]+g.getval(atest.get(i)+1,i+1); //on calcule le poids qu'il le poids total avec le poids du predecesseur + celui de l'arc
				if(main.get(i)[0]==null) { //cas du premier du chemin
					main.get(i)[0]=poidstest;
					main.get(i)[1]=atest.get(i);
				}
				else {
					if(main.get(i)[0]>poidstest) { //cas ou le chemin trouve est meilleur que l'ancien
						main.get(i)[0]=poidstest;
						main.get(i)[1]=atest.get(i);
					}
				}
			}
			traite[posactuelle-1]=true; //le sommet a trouve son chemin optimal
			posactuelle=min(atest,main,g.getNbNoeuds()); // on cherche le chemin le plus petit parmis les successeur du sommet qu'on vient de traiter
		}
		if (main.get(b-1)[0]==null) {
			throw new NoPathEx();
		}
		posactuelle=b-1;
		rep.add(b);
		while(true) {
			if(main.get(posactuelle)[1]==null) {
				break;
			}
			rep.add(0,main.get(posactuelle)[1]+1);
			posactuelle=main.get(posactuelle)[1];
		}
		return rep;
	}
	
	private static int min(HashMap<Integer, Integer> atest,ArrayList<Integer[]> main,int size) {
		int minpos=-1;
		int mini=Integer.MAX_VALUE;
		for(Integer i:atest.keySet()) {
			if(mini>main.get(i)[0]) {
				mini=main.get(i)[0];
				minpos=i;

			}
		}
		return minpos+1;
	}

	private static boolean estOK(IGraph g) {
		int size=g.getNbNoeuds();
		for(int i =1;i<=size;++i) {
			for(int j=1;j<=size;++j) {
				if(g.aArc(i, j)) {
					if(g.getval(i, j)<0) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
