public class Cube{
    Node[][][] goalCube;
    Node[][][] colorNodes;

    public Cube(){
        int counter = 1;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k<3; k++){
                	this.colorNodes[i][j][k] = new Node("");
                    counter++;
                }
            }
        }
    }
    

    public void nodeColor() { 
    	
    }
    
    public void goalCube() { 
    	for(int i = 0; i < 3; i++) { 
    		
    	}
    }
    
    public void cubeScramble() { 
    	
    }  
     
    
}