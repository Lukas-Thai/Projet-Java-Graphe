package graphes;

import java.util.ArrayList;
import java.util.HashMap;

import algorithme.IGraph;

public class GrapheLA implements IGraph{
	private ArrayList<HashMap<Integer,Integer>> liste_adj;

	public GrapheLA(int taille) {
		liste_adj=new ArrayList<HashMap<Integer,Integer>>();

		for(int i=0;i<taille;++i) {
				liste_adj.add(new HashMap<Integer,Integer>());
		}
	}
	public int getNbNoeuds() {
		return liste_adj.size();
	}
	public void ajouterArc(int a,int b,int c) {
		assert(a>0 && b>0);
		assert(a<=getNbNoeuds() && b<=getNbNoeuds());
		assert(!aArc(a,b));
		liste_adj.get(a-1).put(b-1,c);
	}
	public boolean aArc(int a,int b) {
		assert(a>0 && b>0);
		assert(a<=getNbNoeuds() && b<=getNbNoeuds());
		return liste_adj.get(a-1).containsKey(b-1);
	}
	public int dOut(int a) {
		assert(a>0 && a<=getNbNoeuds());
		return liste_adj.get(a-1).size();
	}
	public int dIn(int a) {
		assert(a>0 && a<=getNbNoeuds());
		int rep=0;
		for (int i =0;i<this.getNbNoeuds();++i) {
			if(liste_adj.get(i).containsKey(a-1)) {
				++rep;
			}
		}
		return rep;
	}
	@Override
	public String toString() {
		StringBuilder rep=new StringBuilder();
		for(int i =1;i<=this.getNbNoeuds();++i) {
			rep.append(""+(i)+" -> ");
			HashMap<Integer,Integer> tmp=getsucc(i);
			for(Integer j:tmp.keySet()) {
					rep.append(""+(j+1)+" ");
			}
			rep.append("\n");
		}
		return rep.toString();
	}
	@Override
	public int getval(int a, int b) {
		assert aArc(a,b);
		return liste_adj.get(a-1).get(b-1);
	}
	@Override
	public HashMap<Integer,Integer> getsucc(int a) { 
		assert(a>0 && a<=getNbNoeuds());
		HashMap<Integer,Integer> rep=new HashMap<>();
		for (Integer i:liste_adj.get(a-1).keySet()) {
			rep.put(i,a-1);
		}
		return rep;
	}
	@Override
	public ArrayList<Integer> getpred(int a) {
		assert(a>0 && a<=getNbNoeuds());
		ArrayList<Integer> rep=new ArrayList<Integer>();
		for(int i=0;i<liste_adj.size();++i) {
			if(aArc(i+1,a)) {
				rep.add(i);
			}
		}

		return rep;
	}
	
}

