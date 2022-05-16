package algorithme;

import java.util.ArrayList;
import java.util.HashMap;

public class PCCBellman {
	public static ArrayList<Integer> algo(IGraph g,int a,int b){
		ArrayList<Integer> rep=new ArrayList<>();
		if(!estOK(g)) {
			throw new CircuitEx();
		}
		HashMap<Integer,Integer> tabpred=new HashMap<>();
		HashMap<Integer,Integer> tab=new HashMap<>();
		HashMap<Integer,Integer> succ;
		Integer[] pred=new Integer[g.getNbNoeuds()];
		for(int i=0;i<g.getNbNoeuds();++i) {
			if(i==a-1) {
				tabpred.put(i, 0);
				tab.put(i, 0);
				pred[i]=null;
				continue;
			}
			tabpred.put(i, null);
			tab.put(i, null);
			pred[i]=null;
		}
		for(int i=1;i<g.getNbNoeuds();++i) {
			for(int j=0;j<g.getNbNoeuds();++j) {
				if(tabpred.get(j)!=null) {
					succ=g.getsucc(j+1);
					for(Integer inte:succ.keySet()) {
						int poidstest=g.getval(j+1, inte+1)+tabpred.get(j);
						if(tabpred.get(inte)==null) {
							tab.put(inte, poidstest);
							pred[inte]=j;
						}
						else {
							if(tabpred.get(inte)>poidstest) {
								tab.put(inte, poidstest);
								pred[inte]=j;
							}
						}
					}
				}
			}
			tabpred.clear();
			tabpred.putAll(tab);
		}
		if(tab.get(b-1)==null) {
			throw new NoPathEx();
		}
		int pos=b;
		rep.add(pos);
		while(true) {
			if(pos==a) {
				break;
			}
			rep.add(0,pred[pos-1]+1);
			pos=pred[pos-1]+1;
		}
		return rep;
	}
	
	private static boolean estOK(IGraph g) {
		ArrayList<ArrayList<Integer>> pred=new ArrayList<>();
		ArrayList<Integer> a_retirer=new ArrayList<>();
		Boolean[] fait=new Boolean[g.getNbNoeuds()];
		for(int i=0;i<g.getNbNoeuds();++i) {
			pred.add(g.getpred(i+1));
			fait[i]=false;
			if(pred.get(i).isEmpty()) {
				a_retirer.add(i);
				fait[i]=true;
			}
		}
		while(!pred.isEmpty()) {
			if(a_retirer.isEmpty()) {
				return false;
			}
			for(int i=0;i<g.getNbNoeuds();++i) {
				for(int j=0;j<a_retirer.size();++j) {
					pred.get(i).remove(a_retirer.get(j));
				}
			}
			a_retirer.clear();
			for(int i=0;i<pred.size();++i) {
				if((!fait[i])&&pred.get(i).isEmpty()) {
					a_retirer.add(i);
					fait[i]=true;
				}
			}
			for(int i=0;i<pred.size();++i) {
				if(!pred.get(i).isEmpty()) {
					break;
				}
				else if(i+1==pred.size()) {
					pred.clear();
				}
			}
		}
		return true;
	}



}
