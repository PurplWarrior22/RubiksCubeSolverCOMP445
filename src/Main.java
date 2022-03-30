
public class Main {
	public static void main(String[] args) {
		Cube testCube = new Cube();
		testCube.cubeScramble(3);
		Solver solver = new Solver(testCube);
		System.out.println("BFS: ");
		solver.BFS(testCube);
	}
}
