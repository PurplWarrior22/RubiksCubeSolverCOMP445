
public class Main {
	public static void main(String[] args) {
		Cube testCube = new Cube();
		Solver solver = new Solver();
		
		//testCube.move("B2");

		//testCube.printCube();
		//Cube cube1 = new Cube(); 
		//cube1.move("R");
		//System.out.println(cube1.toString());
		//cube1.move("U");
		//System.out.println(cube1.toString());
		testCube.move("L");
		testCube.move("L");
		//testCube.move("R");
		//testCube.move("R");
		//testCube.cubeScramble(2);
		//System.out.println(testCube.toString());
		solver.BFS(testCube);
		solver.advancedBFS(testCube);
	}
}