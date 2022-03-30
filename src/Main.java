
public class Main {
	public static void main(String[] args) {
		Cube testCube = new Cube();
		Solver solver = new Solver(testCube);
		
		//System.out.println(testCube.toString()); 
		
		//Cube cube1 = new Cube(); 
		//cube1.move("R");
		//System.out.println(cube1.toString());
		//cube1.move("U");
		//System.out.println(cube1.toString());
		testCube.move("L");
		testCube.move("L");
		// testCube.cubeScramble(2);
		solver.BFS(testCube);
	}
}