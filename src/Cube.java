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

    public Node[] getNeighbors(Node node, int iPosition, int jPosition, String face){
        Node [] neighbors = [];
        Node[][] referenceFace = switch (face){
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
                refrerenceFace = downFace;
                break;
        }

        //Left neighbor
        if(iPosition = 0){
            neighbors.push(getCaseNeighbor("left", face, iPosition, jPosition));
        }else {
            neighbors.push(referenceFace[iPosition - 1][jPosition]);
        }

        //Right neighbor
        if(iPosition = 2){
            neighbors.push(getCaseNeighbor("right", face, iPosition, jPosition));
        }else {
            neighbors.push(referenceFace[iPosition + 1][jPosition]);
        }

        //Lower neighbor
        if(jPosition = 0){
            neighbors.push(getCaseNeighbor("down", face, iPosition, jPosition));
        }else {
            neighbors.push(referenceFace[iPosition][jPosition-1]);
        }

        //Upper neighbor
        if(jPosition = 2){
            neighbors.push(getCaseNeighbor("up", face, iPosition, jPosition));
        }else {
            neighbors.push(referenceFace[iPosition][jPosition+1]);
        }

    }

    public Node getCaseNeighbor(String direction, String face, int i, int j){
        Node neighbor;
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
                    case "down"
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
                System.out.print("Error: invalid face specified.")
                break;
        }

    }

    public void nodeColor() { 
    	
    }
    
    public void cubeScramble() { 
    	
    }  
     
    
}