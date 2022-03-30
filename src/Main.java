
public class Main {
	public static void main(String[] args) {
		Cube testCube = new Cube();
		Solver solver = new Solver(testCube);
		solver.BFS(testCube);
	}
}
