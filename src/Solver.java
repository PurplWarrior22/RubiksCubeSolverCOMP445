import java.util.LinkedList;
import java.util.Queue;

public class Solver {
		public static String allMoves[] = {"R", "L", "F", "B", "U", "D"};
		public Solver(Cube cb) { 
		}
		
		public void BFS(Cube cb) { 
			Queue<Cube> q = new LinkedList<>(); 
			Cube currentCube = new Cube(); 
			q.add(cb); 
			
			while(!q.isEmpty() && !isGoal(cb)) {  
			//for(int j = 0; j < 15; j++) {
				currentCube = q.remove(); 
				//System.out.println(currentCube.toString());
				for(int i = 0; i < allMoves.length; i++) { 
					Cube nextCube = new Cube(currentCube); 
					nextCube.move(allMoves[i]);
					q.add(nextCube); 
				}
				
			}
			System.out.println("Breadth-first search " + currentCube.numMoves); 	
		}
		
		
		public void advancedBFS(Cube cb) { 
			
		}
		
		public static boolean isGoal(Cube cb) { 
			boolean goalState = false; 
			if(cb.toStringFace(cb.frontFace).equals("fffffffff") && 
					cb.toStringFace(cb.leftFace).equals("lllllllll") &&
					cb.toStringFace(cb.rightFace).equals("rrrrrrrrr") &&
					cb.toStringFace(cb.backFace).equals("bbbbbbbbb") &&
					cb.toStringFace(cb.upFace).equals("uuuuuuuuu") &&
					cb.toStringFace(cb.downFace).equals("ddddddddd")) { 
				goalState = true;
			}
			return goalState; 
		}	
}
