package test;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithme.CircuitEx;
import algorithme.PCCBellman;
import graphes.GrapheLA;
import graphes.GrapheMA;

public class PCCBellmanTest {

	@Test
	public void test() {
		//Exo 3.1
		
				System.out.println("Exercice 3.1");
				System.out.println();
				GrapheLA la=new GrapheLA(9);
				GrapheMA ma=new GrapheMA(9);
				la.ajouterArc(1, 4, 1);
				la.ajouterArc(1, 3, 2);
				la.ajouterArc(4, 3, 5);
				la.ajouterArc(4, 5, 3);
				la.ajouterArc(5, 3, 1);
				la.ajouterArc(4, 2, 3);
				la.ajouterArc(3, 8, 2);
				la.ajouterArc(5, 7, 3);
				la.ajouterArc(5, 8, 7);
				la.ajouterArc(2, 7, 3);
				la.ajouterArc(7, 2, 2);
				la.ajouterArc(8, 7, 2);	
				la.ajouterArc(7, 6, 1);
				la.ajouterArc(8, 6, 4);
				la.ajouterArc(9, 8, 10);
				ma.ajouterArc(1, 4, 1);
				ma.ajouterArc(1, 3, 2);
				ma.ajouterArc(4, 3, 5);
				ma.ajouterArc(4, 5, 3);
				ma.ajouterArc(5, 3, 1);
				ma.ajouterArc(4, 2, 3);
				ma.ajouterArc(3, 8, 2);
				ma.ajouterArc(5, 7, 3);
				ma.ajouterArc(5, 8, 7);
				ma.ajouterArc(2, 7, 3);
				ma.ajouterArc(7, 2, 2);
				ma.ajouterArc(8, 7, 2);	
				ma.ajouterArc(7, 6, 1);
				ma.ajouterArc(8, 6, 4);
				ma.ajouterArc(9, 8, 10);
				try {
					PCCBellman.algo(ma, 1, 9);
					fail();
				}
				catch(CircuitEx e) {
					try {
					PCCBellman.algo(la, 1, 9);
					fail();
					}
					catch(CircuitEx ex) {
						System.out.println("1->i : CircuitAbsorbantEx");
					}
				}
				//Exo 3.2
				System.out.println();
				System.out.println("Exercice 3.2");
				System.out.println();
				GrapheLA la2=new GrapheLA(10);
				GrapheMA ma2=new GrapheMA(10);
				la2.ajouterArc(1, 4, 3);
				la2.ajouterArc(1, 2, 8);
				la2.ajouterArc(4, 5, 2);
				la2.ajouterArc(2, 5, 5);
				la2.ajouterArc(4, 10, 1);
				la2.ajouterArc(2, 3, 4);
				la2.ajouterArc(5, 9, 2);
				la2.ajouterArc(5, 7, 3);
				la2.ajouterArc(10, 7, 6);
				la2.ajouterArc(10, 6, 6);
				la2.ajouterArc(3, 9,5 );
				la2.ajouterArc(3, 6, 1);
				la2.ajouterArc(9, 8, 2);
				la2.ajouterArc(7, 8, 4);
				la2.ajouterArc(6, 8, 5);
				ma2.ajouterArc(1, 4, 3);
				ma2.ajouterArc(1, 2, 8);
				ma2.ajouterArc(4, 5, 2);
				ma2.ajouterArc(2, 5, 5);
				ma2.ajouterArc(4, 10, 1);
				ma2.ajouterArc(2, 3, 4);
				ma2.ajouterArc(5, 9, 2);
				ma2.ajouterArc(5, 7, 3);
				ma2.ajouterArc(10, 7, 6);
				ma2.ajouterArc(10, 6, 6);
				ma2.ajouterArc(3, 9,5 );
				ma2.ajouterArc(3, 6, 1);
				ma2.ajouterArc(9, 8, 2);
				ma2.ajouterArc(7, 8, 4);
				ma2.ajouterArc(6, 8, 5);
				for (int i=1;i<=10;++i) {
					assertEquals(PCCBellman.algo(la2, 1, i),PCCBellman.algo(ma2,1, i));
					System.out.println("1->"+i + " : "+PCCBellman.algo(la2, 1, i));
				}
				
				//Exo  3.6
				System.out.println();
				System.out.println("Exercice 3.6.1");
				System.out.println();
				GrapheLA la3=new GrapheLA(7);
				GrapheMA ma3=new GrapheMA(7);

				la3.ajouterArc(1,2,7);
				la3.ajouterArc(1,3,1);
				la3.ajouterArc(3, 2, 5);
				la3.ajouterArc(2, 6, -3);
				la3.ajouterArc(3, 6, 7);
				la3.ajouterArc(2, 4, 4);
				la3.ajouterArc(2, 5, 2);
				la3.ajouterArc(6, 4, 5);
				la3.ajouterArc(3, 5, 2);
				la3.ajouterArc(6, 5, 3);
				la3.ajouterArc(4, 7, 4);
				la3.ajouterArc(5, 7, 10);
				ma3.ajouterArc(1,2,7);
				ma3.ajouterArc(1,3,1);
				ma3.ajouterArc(3, 2, 5);
				ma3.ajouterArc(2, 6, -3);
				ma3.ajouterArc(3, 6, 7);
				ma3.ajouterArc(2, 4, 4);
				ma3.ajouterArc(2, 5, 2);
				ma3.ajouterArc(6, 4, 5);
				ma3.ajouterArc(3, 5, 2);
				ma3.ajouterArc(6, 5, 3);
				ma3.ajouterArc(4, 7, 4);
				ma3.ajouterArc(5, 7, 10);
				for(int i=1;i<=7;++i) {
					assertEquals(PCCBellman.algo(la3, 1, i),PCCBellman.algo(ma3,1, i));

					System.out.println("1->"+i + " : "+PCCBellman.algo(la3, 1, i));
				}
				
				//Exo wikipedia
				System.out.println();
				System.out.println("Exercice Wikipedia");
				System.out.println();
				GrapheLA la4=new GrapheLA(4);
				GrapheMA ma4=new GrapheMA(4);
				la4.ajouterArc(1, 2, 5);
				la4.ajouterArc(1, 3, 4);
				la4.ajouterArc(3, 2, -6);
				la4.ajouterArc(2, 4, 3);
				la4.ajouterArc(4, 3, 2);
				ma4.ajouterArc(1, 2, 5);
				ma4.ajouterArc(1, 3, 4);
				ma4.ajouterArc(3, 2, -6);
				ma4.ajouterArc(2, 4, 3);
				ma4.ajouterArc(4, 3, 2);
				try {
					PCCBellman.algo(ma4, 1, 2);
					fail();
				}
				catch(CircuitEx e) {
					try {
					PCCBellman.algo(la4, 1, 2);
					fail();
					}
					catch(CircuitEx ex) {
						System.out.println("1->i : CircuitAbsorbantEx");
					}
				}
				
	}

}
