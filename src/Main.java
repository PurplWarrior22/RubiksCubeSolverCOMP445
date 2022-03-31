
public class Main {
	public static void main(String[] args) {
		Solver solver = new Solver(); 
		// Test Cube 1 with 4 random moves away from the goal cube 
		System.out.println("Starting cube 1:"); 
		Cube testCube = new Cube();
		testCube.cubeScramble(4);
		System.out.println(testCube.toString()); 
		solver.BFS(testCube);
		solver.advancedBFS(testCube);
		
		// Test Cube 2 that is 2 Left Move away from the goal cube. 
		// Since L2 is a move, expected result for the two search is one
		System.out.println("Starting cube 2: ");  
		Cube testCube1 = new Cube();
		testCube1.move("L");
		testCube1.move("L");
		System.out.println(testCube1.toString()); 
		solver.BFS(testCube1); 
		solver.advancedBFS(testCube1);
		
		
		//Test Cube 3 
		
		

	}
}