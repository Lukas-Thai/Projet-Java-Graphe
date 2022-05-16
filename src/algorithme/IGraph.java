package algorithme;


import java.util.ArrayList;
import java.util.HashMap;

public interface IGraph {

	public int getNbNoeuds();
	public void ajouterArc(int a,int b,int c);
	public boolean aArc(int a,int b);
	public int dOut(int a);
	public int dIn(int a);
	public int getval(int a, int b);
	public HashMap<Integer,Integer> getsucc(int a);
	public ArrayList<Integer> getpred(int a);
}
