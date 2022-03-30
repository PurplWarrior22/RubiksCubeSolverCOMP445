import java.util.ArrayList;
import java.util.Random;
public class Cube {
	Node[][] frontFace;
    Node[][] backFace;
    Node[][] rightFace;
    Node[][] leftFace;
    Node[][] upFace;
    Node[][] downFace;

    int numMoves;
    int heuristic;

    public Cube(){
    	frontFace = new Node[3][3]; 
    	backFace = new Node[3][3]; 
    	rightFace = new Node[3][3]; 
    	leftFace = new Node[3][3]; 
    	upFace = new Node[3][3]; 
    	downFace = new Node[3][3];
    	
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
        numMoves = 0;
        heuristic = setHeuristic();
    }

    public int setHeuristic(){
    	wrongCounter = 0;
    	for(int i = 0; i < 3; i++){
    		for(int j = 0; j < 3; j++){
    			if(frontFace[i][j].getColor() != "f"){
    				wrongCounter++;
				}
			}
		}
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(backFace[i][j].getColor() != "b"){
					wrongCounter++;
				}
			}
		}
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(leftFace[i][j].getColor() != "l"){
					wrongCounter++;
				}
			}
		}
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(rightFace[i][j].getColor() != "r"){
					wrongCounter++;
				}
			}
		}
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(upFace[i][j].getColor() != "u"){
					wrongCounter++;
				}
			}
		}
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(downFace[i][j].getColor() != "d"){
					wrongCounter++;
				}
			}
		}
		return wrongCounter;
	}

	public ArrayList<Node> getNeighbors(Node node, int iPosition, int jPosition, String face){
        ArrayList <Node> neighbors = new ArrayList<>();
        Node[][] referenceFace;
        switch (face){
            case "front":
                referenceFace = frontFace;
                break;
            case "back":
                referenceFace = backFace;
                break;
            case "left":
                referenceFace = leftFace;
                break;
            case "right":
                referenceFace = rightFace;
                break;
            case "up":
                referenceFace = upFace;
                break;
            case "down":
            default: 
                referenceFace = downFace;
                break;
        }

        //Left neighbor
        if(iPosition == 0){
            neighbors.add(getCaseNeighbor("left", face, iPosition, jPosition));
        }else {
            neighbors.add(referenceFace[iPosition - 1][jPosition]);
        }

        //Right neighbor
        if(iPosition == 2){
            neighbors.add(getCaseNeighbor("right", face, iPosition, jPosition));
        }else {
            neighbors.add(referenceFace[iPosition + 1][jPosition]);
        }

        //Lower neighbor
        if(jPosition == 0){
            neighbors.add(getCaseNeighbor("down", face, iPosition, jPosition));
        }else {
            neighbors.add(referenceFace[iPosition][jPosition-1]);
        }

        //Upper neighbor
        if(jPosition == 2){
            neighbors.add(getCaseNeighbor("up", face, iPosition, jPosition));
        }else {
            neighbors.add(referenceFace[iPosition][jPosition+1]);
        }

        return neighbors;
    }

    public Node getCaseNeighbor(String direction, String face, int i, int j){
        Node neighbor = null;
        switch (face){
            case "front":
                switch (direction){
                    case "left":
                        neighbor = leftFace[2][j];
                        break;
                    case "right":
                        neighbor = rightFace[0][j];
                        break;
                    case "up":
                        neighbor = upFace[i][0];
                        break;
                    case "down":
                        neighbor = downFace[i][2];
                        break;
                    default:
                        System.out.println("Error: wrong direction specified.");
                        break;
                }
                break;
            case "back":
                switch (direction){
                    case "left":
                        neighbor = rightFace[2][j];
                        break;
                    case "right":
                        neighbor = leftFace[0][j];
                        break;
                    case "up":
                        neighbor = upFace[i][2];
                        break;
                    case "down":
                        neighbor = downFace[i][0];
                        break;
                    default:
                        System.out.println("Error: wrong direction specified.");
                        break;
                }
                break;
            case "right":
                switch (direction){
                    case "left":
                        neighbor = frontFace[2][j];
                        break;
                    case "right":
                        neighbor = backFace[0][j];
                        break;
                    case "up":
                        neighbor = upFace[2][i];
                        break;
                    case "down": 
                        neighbor = downFace[2][2-i];
                        break;
                    default:
                        System.out.println("Error: wrong direction specified.");
                        break;
                }
                break;
            case "left":
                switch (direction){
                    case "left":
                        neighbor = backFace[2][j];
                        break;
                    case "right":
                        neighbor = frontFace[0][j];
                        break;
                    case "up":
                        neighbor = upFace[0][2-i];
                        break;
                    case "down":
                        neighbor = downFace[0][i];
                        break;
                    default:
                        System.out.println("Error: wrong direction specified.");
                        break;
                }
                break;
            case "top":
                switch (direction){
                    case "left":
                        neighbor = leftFace[2-j][2];
                        break;
                    case "right":
                        neighbor = rightFace[j][2];
                        break;
                    case "up":
                        neighbor = backFace[2-i][2];
                        break;
                    case "down":
                        neighbor = frontFace[i][2];
                        break;
                    default:
                        System.out.println("Error: wrong direction specified.");
                        break;
                }
                break;
            case "bottom":
                switch (direction){
                    case "left":
                        neighbor = leftFace[j][0];
                        break;
                    case "right":
                        neighbor = rightFace[2-j][0];
                        break;
                    case "up":
                        neighbor = frontFace[i][0];
                        break;
                    case "down":
                        neighbor = backFace[2-i][0];
                        break;
                    default:
                        System.out.println("Error: wrong direction specified.");
                        break;
                }
                break;
            default:
                System.out.print("Error: invalid face specified.");
                break;
                
        }
        return neighbor;

    }

    
    public void cubeScramble(int numMove) { 
    	Random rand = new Random(); 
    	String allMoves = "URFDLB"; 
    	String moveName = ""; 
    	for(int i = 0; i < numMove; i++) { 
    		int moveIndex = rand.nextInt(numMove + 1); 
    		moveName = String.valueOf(allMoves.charAt(moveIndex));
    		move(moveName); 
    	}
    } 
    
    public void move(String moveName) { 
    	if(moveName.equals("U")) { 
    		Node[] front = new Node[3]; 
    		Node[] left = new Node[3]; 
    		Node[] back = new Node[3]; 
    		Node[] right = new Node[3]; 
    		
    		for(int i = 0; i < 3; i++) { 
    			front[i] = new Node(frontFace[0][i].getColor());
    			left[i] = new Node(leftFace[0][i].getColor());
    			back[i] = new Node(backFace[0][i].getColor());
    			right[i] = new Node(rightFace[0][i].getColor());
    			
    			leftFace[0][i].color = front[i].color; 
    			backFace[0][i].color = left[i].color; 
    			rightFace[0][i].color = back[i].color;
    			frontFace[0][i].color = right[i].color;
    		}
    		
    		Node up00 = new Node(upFace[0][0].color); 
    		Node up01 = new Node(upFace[0][1].color);
    		Node up02 = new Node(upFace[0][2].color);
    		Node up12 = new Node(upFace[1][2].color);
    		Node up22 = new Node(upFace[2][2].color);
    		Node up21 = new Node(upFace[2][1].color);
    		Node up20 = new Node(upFace[2][2].color);
    		Node up10 = new Node(upFace[1][0].color);
    		
    		upFace[0][0].color = up20.color; 
    		upFace[0][1].color = up10.color; 
    		upFace[0][2].color = up00.color; 
    		upFace[1][2].color = up01.color; 
    		upFace[2][2].color = up02.color; 
    		upFace[2][1].color = up12.color; 
    		upFace[2][0].color = up22.color; 
    		upFace[1][0].color = up21.color; 
    	}
    	
    	if(moveName.equals("R")) { 
    		Node[] front = new Node[3]; 
    		Node[] up = new Node[3]; 
    		Node[] back = new Node[3]; 
    		Node[] down = new Node[3]; 
    		
    		for(int i = 0; i < 3; i++) { 
    			front[i] = new Node(frontFace[i][2].getColor());
    			up[i] = new Node(upFace[i][2].getColor());
    			back[i] = new Node(backFace[i][2].getColor());
    			down[i] = new Node(downFace[i][2].getColor());
    			
    			upFace[i][2].color = front[i].color; 
    			backFace[i][2].color = up[i].color; 
    			downFace[i][2].color = back[i].color;
    			frontFace[i][2].color = down[i].color;
    		}
    		
    		Node right00 = new Node(rightFace[0][0].color); 
    		Node right01 = new Node(rightFace[0][1].color);
    		Node right02 = new Node(rightFace[0][2].color);
    		Node right12 = new Node(rightFace[1][2].color);
    		Node right22 = new Node(rightFace[2][2].color);
    		Node right21 = new Node(rightFace[2][1].color);
    		Node right20 = new Node(rightFace[2][2].color);
    		Node right10 = new Node(rightFace[1][0].color);
    		
    		rightFace[0][0].color = right20.color; 
    		rightFace[0][1].color = right10.color; 
    		rightFace[0][2].color = right00.color; 
    		rightFace[1][2].color = right01.color; 
    		rightFace[2][2].color = right02.color; 
    		rightFace[2][1].color = right12.color; 
    		rightFace[2][0].color = right22.color; 
    		rightFace[1][0].color = right21.color; 
    	}
    	
    	if(moveName.equals("F")) { 
    		Node[] left = new Node[3]; 
    		Node[] up = new Node[3]; 
    		Node[] right = new Node[3]; 
    		Node[] down = new Node[3]; 
    		
    		for(int i = 0; i < 3; i++) { 
    			left[i] = new Node(leftFace[2][i].getColor());
    			up[i] = new Node(upFace[2][i].getColor());
    			right[i] = new Node(rightFace[2][i].getColor());
    			down[i] = new Node(downFace[2][i].getColor());
    			
    			upFace[2][i].color = left[i].color; 
    			rightFace[2][i].color = up[i].color; 
    			downFace[2][i].color = right[i].color;
    			leftFace[2][i].color = down[i].color;
    		}
    		
    		Node front00 = new Node(frontFace[0][0].color); 
    		Node front01 = new Node(frontFace[0][1].color);
    		Node front02 = new Node(frontFace[0][2].color);
    		Node front12 = new Node(frontFace[1][2].color);
    		Node front22 = new Node(frontFace[2][2].color);
    		Node front21 = new Node(frontFace[2][1].color);
    		Node front20 = new Node(frontFace[2][2].color);
    		Node front10 = new Node(frontFace[1][0].color);
    		
    		frontFace[0][0].color = front20.color; 
    		frontFace[0][1].color = front10.color; 
    		frontFace[0][2].color = front00.color; 
    		frontFace[1][2].color = front01.color; 
    		frontFace[2][2].color = front02.color; 
    		frontFace[2][1].color = front12.color; 
    		frontFace[2][0].color = front22.color; 
    		frontFace[1][0].color = front21.color; 
    	}
    	
    	if(moveName.equals("D")) { 
    		Node[] front = new Node[3]; 
    		Node[] left = new Node[3]; 
    		Node[] back = new Node[3]; 
    		Node[] right = new Node[3]; 
    		
    		for(int i = 0; i < 3; i++) { 
    			front[i] = new Node(frontFace[2][i].getColor());
    			left[i] = new Node(leftFace[2][i].getColor());
    			back[i] = new Node(backFace[2][i].getColor());
    			right[i] = new Node(rightFace[2][i].getColor());
    			
    			leftFace[0][i].color = back[i].color; 
    			backFace[0][i].color = right[i].color; 
    			rightFace[0][i].color = front[i].color;
    			frontFace[0][i].color = left[i].color;
    		}
    		
    		Node down00 = new Node(downFace[0][0].color); 
    		Node down01 = new Node(downFace[0][1].color);
    		Node down02 = new Node(downFace[0][2].color);
    		Node down12 = new Node(downFace[1][2].color);
    		Node down22 = new Node(downFace[2][2].color);
    		Node down21 = new Node(downFace[2][1].color);
    		Node down20 = new Node(downFace[2][2].color);
    		Node down10 = new Node(downFace[1][0].color);
    		
    		downFace[0][0].color = down20.color; 
    		downFace[0][1].color = down10.color; 
    		downFace[0][2].color = down00.color; 
    		downFace[1][2].color = down01.color; 
    		downFace[2][2].color = down02.color; 
    		downFace[2][1].color = down12.color; 
    		downFace[2][0].color = down22.color; 
    		downFace[1][0].color = down21.color; 
    	}
    	
    	if(moveName.equals("L")) { 
    		Node[] front = new Node[3]; 
    		Node[] up = new Node[3]; 
    		Node[] back = new Node[3]; 
    		Node[] down = new Node[3]; 
    		
    		for(int i = 0; i < 3; i++) { 
    			front[i] = new Node(frontFace[0][i].getColor());
    			up[i] = new Node(upFace[0][i].getColor());
    			back[i] = new Node(backFace[0][i].getColor());
    			down[i] = new Node(downFace[0][i].getColor());
    			
    			frontFace[0][i].color = up[i].color; 
    			upFace[0][i].color = back[i].color; 
    			backFace[0][i].color = down[i].color;
    			downFace[0][i].color = front[i].color;
    		}
    		
    		Node left00 = new Node(leftFace[0][0].color); 
    		Node left01 = new Node(leftFace[0][1].color);
    		Node left02 = new Node(leftFace[0][2].color);
    		Node left12 = new Node(leftFace[1][2].color);
    		Node left22 = new Node(leftFace[2][2].color);
    		Node left21 = new Node(leftFace[2][1].color);
    		Node left20 = new Node(leftFace[2][2].color);
    		Node left10 = new Node(leftFace[1][0].color);
    		
    		leftFace[0][0].color = left20.color; 
    		leftFace[0][1].color = left10.color; 
    		leftFace[0][2].color = left00.color; 
    		leftFace[1][2].color = left01.color; 
    		leftFace[2][2].color = left02.color; 
    		leftFace[2][1].color = left12.color; 
    		leftFace[2][0].color = left22.color; 
    		leftFace[1][0].color = left21.color; 
    	}
    	
    	if(moveName.equals("B")) { 
    		Node[] left = new Node[3]; 
    		Node[] up = new Node[3]; 
    		Node[] right = new Node[3]; 
    		Node[] down = new Node[3]; 
    		
    		for(int i = 0; i < 3; i++) { 
    			left[i] = new Node(leftFace[i][0].getColor());
    			up[i] = new Node(upFace[i][0].getColor());
    			right[i] = new Node(rightFace[i][0].getColor());
    			down[i] = new Node(downFace[i][0].getColor());
    			
    			leftFace[i][0].color = up[i].color; 
    			upFace[i][0].color = right[i].color; 
    			rightFace[i][0].color = down[i].color;
    			downFace[i][0].color = left[i].color;
    		}
    		
    		Node back00 = new Node(backFace[0][0].color); 
    		Node back01 = new Node(backFace[0][1].color);
    		Node back02 = new Node(backFace[0][2].color);
    		Node back12 = new Node(backFace[1][2].color);
    		Node back22 = new Node(backFace[2][2].color);
    		Node back21 = new Node(backFace[2][1].color);
    		Node back20 = new Node(backFace[2][2].color);
    		Node back10 = new Node(backFace[1][0].color);
    		
    		backFace[0][0].color = back20.color; 
    		backFace[0][1].color = back10.color; 
    		backFace[0][2].color = back00.color; 
    		backFace[1][2].color = back01.color; 
    		backFace[2][2].color = back02.color; 
    		backFace[2][1].color = back12.color; 
    		backFace[2][0].color = back22.color; 
    		backFace[1][0].color = back21.color; 
    	}
    }

	public int compareTo(Cube compareNode)
	{
		int compareCost = ((Cube)compareNode).getNumMoves();
		int compareHeuristic = ((Cube)compareNode).getHeuristic();

		//  For Ascending order
		return (this.numMoves+this.heuristic) - (compareCost+compareHeuristic);

		// For Descending order do like this
		// return compareCost-this.cost;
	}
    
    @Override
    public String toString() { 
    	String returnString; 
    	returnString = toStringFace(frontFace) + "\n"; 
    	returnString = returnString + toStringFace(backFace)  + "\n";
    	returnString = returnString + toStringFace(leftFace) + "\n";
    	returnString = returnString + toStringFace(rightFace) + "\n";
    	returnString = returnString + toStringFace(upFace) + "\n";
    	returnString = returnString + toStringFace(downFace)  + "\n";
    	
    	return returnString; 
    
    }

	public int getNumMoves(){
		return numMoves;
	}

	public void setNumMoves(int num){
		numMoves = num;
	}

	public Node[][] getBackFace() {
		return backFace;
	}

	public Node[][] getDownFace() {
		return downFace;
	}

	public Node[][] getFrontFace() {
		return frontFace;
	}

	public Node[][] getLeftFace() {
		return leftFace;
	}

	public Node[][] getRightFace() {
		return rightFace;
	}

	public Node[][] getUpFace() {
		return upFace;
	}

	public void setBackFace(Node[][] backFace) {
		this.backFace = backFace;
	}

	public void setDownFace(Node[][] downFace) {
		this.downFace = downFace;
	}

	public void setFrontFace(Node[][] frontFace) {
		this.frontFace = frontFace;
	}

	public void setLeftFace(Node[][] leftFace) {
		this.leftFace = leftFace;
	}

	public void setRightFace(Node[][] rightFace) {
		this.rightFace = rightFace;
	}

	public void setUpFace(Node[][] upFace) {
		this.upFace = upFace;
	}
    
    public String toStringFace(Node[][] nodes) { 
    	//String returnString = face + " ";
    	String returnString = ""; 
    	for(int i = 0; i < 3; i++) { 
    		for(int j = 0; j < 3; j++) { 
    			returnString = returnString + (nodes[i][j]);
    		}
    	}
    	return returnString; 
    }
     
}