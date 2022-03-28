import java.util.LinkedList;
import java.util.Queue;

public class Solver {

		private solvingCube;
		private moves = {"U", "D", "L", "R", "F", "B", "U'", "D'", "L'", "R'", "F'", "B'", "LM", "RM", "UM", "DM"}

		public Solver(Cube cb) { 
			solvingCube = cb;
		}
		
		public void BFS(Cube cb) {
			boolean visited[] = new boolean[18]; 
			Queue<Cube> q = new LinkedList<>(); 
			Cube currentCube = null;
			q.add(cb);
			
			while(!q.isEmpty()) {
				currentCube = q.remove();
				if (isGoal(currentCube)) {
					int totalMoves = currentCube.getNumMoves();
					System.out.println("A goal state was found in " + totalMoves + " moves!");
					break;
				}
				for (String move:moves) {
					nextCube = currentCube.move(move);
					nextCube.setNumMoves(currentCube.getNumMoves() + 1);
					q.add(nextCube);
				}
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
