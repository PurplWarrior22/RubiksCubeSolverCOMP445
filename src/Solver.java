import java.util.LinkedList;
import java.util.Queue;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Solver {

		private Cube solvingCube;
		private String[] moves = {"U", "D", "L", "R", "F", "B", "U'", "D'", "L'", "R'", "F'", "B'", "LM", "RM", "UM", "DM"};

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
				for (String move : moves) {
					Cube nextCube = deepCopyCube(currentCube);
					nextCube.move(move);
					nextCube.setNumMoves(currentCube.getNumMoves() + 1);
					q.add(nextCube);
				}
			}
			
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

		private static Cube deepCopyCube(Cube cube){
			Cube newCube = new Cube();
			newCube.setFrontFace(cube.getFrontFace());
			newCube.setBackFace(cube.getBackFace());
			newCube.setLeftFace(cube.getLeftFace());
			newCube.setRightFace(cube.getRightFace());
			newCube.setUpFace(cube.getUpFace());
			newCube.setDownFace(cube.getDownFace());
			newCube.setNumMoves(cube.getNumMoves());
			return newCube;
		}
}
