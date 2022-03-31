
public class Main {
	public static void main(String[] args) {
		Solver solver = new Solver(); 
		
		System.out.println("Starting cube 1:"); 
		Cube testCube = new Cube();
		System.out.println(testCube.toString()); 
		solver.BFS(testCube);
		solver.advancedBFS(testCube);
		
		System.out.println("Starting cube 2: ");  
		Cube testCube1 = new Cube();
		testCube1.move("L");
		testCube1.move("L");
		System.out.println(testCube1.toString()); 
		solver.BFS(testCube1); 
		solver.advancedBFS(testCube1);
		
		

	}
}