import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solver {
	public static String allMoves[] = { "R", "L", "F", "B", "U", "D", 
											"R1", "L1", "F1", "B1", "U1", "D1",
												"R2", "L2", "F2", "B2", "U2", "D2",};

	public void BFS(Cube cb) {
		Queue<Cube> q = new LinkedList<>();
		Cube currentCube = new Cube();
		q.add(cb);

		while (!q.isEmpty()) {
			currentCube = q.remove();
			for (int i = 0; i < allMoves.length; i++) {
				Cube nextCube = new Cube(currentCube);
				nextCube.move(allMoves[i]);
				System.out.println(nextCube.toString());
				nextCube.numMoves++;
				if (isGoal(nextCube)) {
					System.out.println("Breadth-first search " + nextCube.numMoves);
					return; 
				}
				q.add(nextCube);
			}
		}	
	}

	public void aBFS(Cube cb) {
		Queue<Cube> q = new LinkedList<>();
		Cube currentCube = new Cube();
		q.add(cb);

		while (!q.isEmpty()) {
			currentCube = q.remove();
			//System.out.println(currentCube.toString());
			for (int i = 0; i < allMoves.length; i++) {
				Cube nextCube = new Cube(currentCube);
				nextCube.move(allMoves[i]);
				nextCube.setHeuristic(); 
				nextCube.numMoves++;
				if (isGoal(nextCube)) {
					System.out.println("A* search " + nextCube.numMoves);
					return;
				}
				q.add(nextCube);
				Collections.sort((List)q, new sortByMoves());
			}
		}
	}

	public static boolean isGoal(Cube cb) {
		boolean goalState = false;
		if (cb.toStringFace(cb.frontFace).equals("fffffffff") && cb.toStringFace(cb.leftFace).equals("lllllllll")
				&& cb.toStringFace(cb.rightFace).equals("rrrrrrrrr") && cb.toStringFace(cb.backFace).equals("bbbbbbbbb")
				&& cb.toStringFace(cb.upFace).equals("uuuuuuuuu") && cb.toStringFace(cb.downFace).equals("ddddddddd")) {
			goalState = true;
		}
		return goalState;
	}
	
	class sortByMoves implements Comparator<Cube>
	{
		// Used for sorting in ascending order of
		// roll number
		public int compare(Cube a, Cube b)
		{
			return (a.numMoves + a.heuristic) - (b.numMoves + b.heuristic);
		}
	}
}
