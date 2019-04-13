package myproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {
	
	private int[][] preD = new int[25][25];
	private int min = 99999, nextNode = 0; 
	
   // @SuppressWarnings("rawtypes")
	ArrayList<ArrayList<Integer>> shortestpath = new ArrayList<ArrayList<Integer>>();
	public int[][] distance = new int[25][25]; 
	
						//  0		1		2		3		4		5		6		7		8		9		10		11		12		13		14		15		16		17		18		19		20		21		22		23		24
	
	int[][] matrix = 	{ { 0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
			  { 1,0,0,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
			  { 0,0,0,1,1,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
			  { 1,1,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			  { 0,1,1,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			  { 0,1,0,0,1,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			  { 0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
			  { 0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},				
			  { 0,0,0,0,0,1,1,0,0,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0},
			  { 0,0,1,0,1,1,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			  { 0,0,0,0,0,1,0,0,0,1,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0},
			  { 1,0,1,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
			  { 0,0,1,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
			  { 0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,0,0,0,0,0,0},
			  { 0,0,0,0,0,0,0,0,0,1,1,0,0,1,0,1,0,0,0,0,0,0,0,0,0},
			  { 0,0,0,0,0,0,0,0,1,0,0,0,0,1,1,0,1,0,1,0,0,0,0,0,0},
			  { 0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,0,1,1,0,1,0,0,0,0},
			  { 0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0},
			  { 0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,1,1,0,0,0,1},
			  { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,1,1},
			  { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,1,1,0,0},
			  { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0},
			  { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,1},
			  { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1},
			  { 0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,1,0,0,0,1,0}
			  }; 
	
	int[][] vistd = new int[25][25];




	@SuppressWarnings({ "rawtypes", "unchecked" })
	
	
	public Dijkstra() {
		
		
		for(int a=0; a<25; a++){
			for(int b=0;b<25;b++){
				if(matrix[a][b]==0) matrix[a][b] = 99999; 
			}
		}
		
		for (int src = 0; src < 25; src++) {
			distance[src] = matrix[src]; 
			vistd[src][0] = 1;
			distance[src][src] = 0; 
									
			for (int counter = 0; counter < 25; counter++) {
				min = 99999;
				for (int i = 0; i < 25; i++) {
					if (min > distance[src][i] && vistd[src][i] != 1) {
						min = distance[src][i];
						nextNode = i;
					}
				}
				vistd[src][nextNode] = 1;
				for (int i = 0; i < 25; i++) {
					if (vistd[src][i] != 1) {
						if (min + matrix[nextNode][i] < distance[src][i]) {
							distance[src][i] = min + matrix[nextNode][i];
							preD[src][i] = nextNode;
						}
					}
				}
			}
		}
		
		for(int a=0; a<25; a++){
			for(int b=0;b<25;b++){
				distance[b][a]=distance[a][b]; 
			}
		}
		
		for(int src=0;src<25;src++){
			int j;
			for (int i = 0; i < 25; i++) {
					j=i;
					ArrayList temp = new ArrayList();
					temp.clear();
					temp.add(i);
					while (j != 0) {
						j = preD[src][j];
						if(j!=0) temp.add(j);
					} 
					temp.add(src);
					Collections.reverse(temp);
					shortestpath.add(temp);
			}
		}
	}
	
	
	//@SuppressWarnings("rawtypes")
	public ArrayList<Integer> getShortestPath(int src, int dst){
		return shortestpath.get(src*25+dst);
	}
	
	public int Cityid (String cityname) {
		int id=0;  
		 if (cityname.matches("Northborough, MA"))
				id=0;
			else if (cityname.matches("Edison, NJ"))
				id=1;
			else if (cityname.matches("Pittsburgh, PA"))
				 id=2;
			else if (cityname.matches("Allentown, PA"))
				 id=3;
			else if (cityname.matches("Martinsburg, WV"))
				 id=4;
			else if (cityname.matches("Charlotte, NC"))
				 id=5;
			else if (cityname.matches("Atlanta, GA"))
				 id=6;
			else if (cityname.matches("Orlando, FL"))
				 id=7;
			else if (cityname.matches("Memphis, TN"))
				 id=8;
			else if (cityname.matches("Grove City, OH"))
				 id=9;
			else if (cityname.matches("Indianapolis, IN"))
			     id=10;
			else if (cityname.matches("Detroit, MI"))
				 id=11;
			else if (cityname.matches("New Berlin, WI"))
				 id=12;
			else if (cityname.matches("Minneapolis, MN"))
				 id=13;
			else if (cityname.matches("St. Louis, MO"))
				 id=14;
			else if (cityname.matches("Kansas, KS"))
				 id=15;
			else if (cityname.matches("Dallas, TX"))
				 id=16;
			else if (cityname.matches("Houston, TX"))
				id=17;
			else if (cityname.matches("Denver, CO"))
				id=18;
			else if (cityname.matches("Salt Lake City, UT"))
				id=19;
			else if (cityname.matches("Phoenix, AZ"))
				id= 20;
			else if (cityname.matches("Los Angeles, CA"))
				id=21;
			else if (cityname.matches("Chino, CA"))
				id=22;
			else if (cityname.matches("Sacramento, CA"))
				id=23;
			else if (cityname.matches("Seattle, WA"))
				id=24;
			return id;
	}
	
	public String cityName(int cid){
		
		switch(cid){
		
		case 0  : return "Northborough, MA";
		case 1  : return "Edison, NJ";
		case 2  : return "Pittsburgh, PA";
		case 3  : return "Allentown, PA";
		case 4  : return "Martinsburg, WV";
		case 5  : return "Charlotte, NC";
		case 6  : return "Atlanta, GA";
		case 7  : return "Orlando, FL";
		case 8  : return "Memphis, TN";
		case 9  : return "Grove City, OH";
		case 10 : return "Indianapolis, IN";
		case 11 : return "Detroit, MI";
		case 12 : return "New Berlin, WI";
		case 13 : return "Minneapolis, MN";
		case 14 : return "St. Louis, MO";
		case 15 : return "Kansas, KS";
		case 16 : return "Dallas, TX";
		case 17 : return "Houston, TX";
		case 18 : return "Denver, CO";
		case 19 : return "Salt Lake City, UT";
		case 20 : return "Phoenix, AZ";
		case 21 : return "Los Angeles, CA";
		case 22 : return "Chino, CA";
		case 23 : return "Sacramento, CA";
		case 24 : return "Seattle, WA";
		default : return "City Error";
		}
	}
}