import java.util.LinkedList;
import java.util.Queue;

public class Solver {

		private solvingCube;

		public Solver(Cube cb) { 
			solvingCube = cb;
		}
		
		public void BFS(Cube cb) { 
			boolean visited[] = new boolean[18]; 
			Queue<Cube> q = new LinkedList<>(); 
			Cube currentCube = new Cube();
			q.add(cb);
			
			while(!q.isEmpty() && !isGoal(cb)) { 
				currentCube = q.remove(); 
			}

			System.out.println("Found goal!");
			
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
