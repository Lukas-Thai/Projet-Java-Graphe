package graphes;

import java.util.ArrayList;
import java.util.HashMap;

import algorithme.IGraph;

public class GrapheMA implements IGraph{
	private boolean[][] matrice;
	private int[][] matriceval;
	public GrapheMA(int taille) {
		matrice=new boolean[taille][taille];
		matriceval=new int[taille][taille];
		for(int i=0;i<taille;++i) {
			for (int j=0;j<taille;++j) {
				matrice[i][j]=false;
			}
		}
	}
	public int getNbNoeuds() {
		return matrice.length;
	}
	public void ajouterArc(int a,int b,int c) {
		assert(a>0&&b>0);
		assert(a<=matrice.length && b<=matrice.length);
		matrice[a-1][b-1]=true;
		matriceval[a-1][b-1]=c;
	}
	public boolean aArc(int a,int b) {
		assert(a>0&&b>0);
		assert(a<=matrice.length && b<=matrice.length);
		return matrice[a-1][b-1];
	}
	public int dOut(int a) {
		assert(a>0 && a<=matrice.length);
		int rep=0;
		for (int i =0;i<this.getNbNoeuds();++i) {
			if(matrice[a-1][i]) {
				++rep;
			}
		}
		return rep;
	}
	public int dIn(int a) {
		assert(a>0 && a<=matrice.length);
		int rep=0;
		for (int i =0;i<this.getNbNoeuds();++i) {
			if(matrice[i][a-1]) {
				++rep;
			}
		}
		return rep;
	}
	@Override
	public String toString() {
		StringBuilder rep= new StringBuilder();
		for(int i =0;i<this.getNbNoeuds();++i) {
			for(int j=0;j<this.getNbNoeuds();++j) {
				if(matrice[i][j]) {
					rep.append("1 ");
				}
				else {
					rep.append("0 ");
				}
			}
			rep.append("\n");
		}
		return rep.toString();
	}
	@Override
	public int getval(int a, int b) {
		assert(aArc(a,b));
		return matriceval[a-1][b-1];
	}
	@Override
	public HashMap<Integer,Integer> getsucc(int a) {
		assert(a>0 && a<=matrice.length);
		HashMap<Integer,Integer> tmp=new HashMap<>();
		for(int i=0;i<matrice.length;++i) {
			if (matrice[a-1][i]) {
				tmp.put(i, a-1);
			}
		}
		return tmp;
	}
	@Override
	public ArrayList<Integer> getpred(int a) {
		assert(a>0 && a<=matrice.length);
		ArrayList<Integer> tmp=new ArrayList<>();
		for(int i=0;i<matrice.length;++i){
			if(matrice[i][a-1]) {
				tmp.add(i);
			}
		}
		return tmp;
	}
}
