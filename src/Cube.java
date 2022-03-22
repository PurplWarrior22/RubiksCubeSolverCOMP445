public class Cube{
    Node[][] frontFace;
    Node[][] backFace;
    Node[][] rightFace;
    Node[][] leftFace;
    Node[][] upFace;
    Node[][] downFace;

    public Cube(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                frontFace[i][j] = new Node("f");
                backFace[i][j] = new Node("b");
                rightFace[i][j] = new Node("r");
                leftFace[i][j] = new Node("l");
                upFace[i][j] = new Node("u");
                downFace[i][j] = new Node("d");
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