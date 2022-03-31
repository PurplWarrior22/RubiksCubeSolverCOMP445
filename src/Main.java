
public class Main {
	public static void main(String[] args) {
		Solver solver = new Solver(); 
		
		//Test Cube 1 with 1 - 6 (safely 4) random moves away from the goal cube 
		System.out.println("Starting cube 1:"); 
		Cube testCube = new Cube();
		System.out.println(testCube.toString()); 
		testCube.cubeScramble(4);
		System.out.println(testCube.toString()); 
		long startTime = System.nanoTime(); 
		solver.BFS(testCube);
		long endTime = System.nanoTime(); 
		long duration = (endTime - startTime) / 100000; 
		System.out.println(testCube.toString() + "\n BFS: " + duration + "ms"); 
		
		long startTime1 = System.nanoTime(); 
		solver.aBFS(testCube);
		long endTime1 = System.nanoTime(); 
		long duration1 = (endTime1 - startTime1) / 100000;
		System.out.println(testCube.toString() + "\n A: " + duration1 + "ms");
		
		// Test Cube 2 that is 2 Left Move away from the goal cube. 
		// Since L2 is a move, expected result for the two search is one
		System.out.println("Starting cube 2: ");  
		Cube testCube1 = new Cube();
		testCube1.move("L");
		testCube1.move("L");
		System.out.println(testCube1.toString()); 
		solver.BFS(testCube1); 
		solver.aBFS(testCube1);
	

		

	}
}