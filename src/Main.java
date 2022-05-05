import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Objects;


public class Main {
    //Data
    private static Server server;
    private static int endNode = 39;
    private static String introToNode = "You arrive at a junction with a ";
    // useless data
    static String leftPathTxt = "1 to go left";
    static String rightPathTxt = "2 to go right";
    static String forwardPathTxt = "3 to go forward";


    //GO BACK AND SPLIT THIS INTO OTHER METHODS
    public static void main(String[] args) throws FileNotFoundException {
        server = new Server();
        while(true){
            System.out.println("You enter the Maze.");
            Node n = server.getNode(1);
            decisionLoop(n);
            System.out.println("Would you like the play again?\nEnter n to stop.");
            //will need to change this variable
            String text = server.getString();
            if(Objects.equals(text, "n")){
               break;
            }
            /*else{
                System.out.println("not a n");
            }*/
        }
    }
    //A method to deal with the user input
    // and get the decision at each node
    private static int getDecision(int input, boolean isOkInput, Node n){
        // try catch block ready check?
        //https://stackoverflow.com/questions/45509594/getting-input-in-java-using-nextint
        while (!isOkInput){
            try {
                while ( (input <= 0 || input > 3) ){//would be nice if this was in the catch block as invalid input
                    //System.out.println(n.getText());
                    //to remove
                    System.out.println("Enter "+leftPathTxt +", "+ rightPathTxt+" or " +forwardPathTxt);

                    input = server.getInput();
                }
                if (getPathId(input, n) != 0){
                    isOkInput = true;
                }
                else {
                    if(input == 1){
                        System.out.println("You can't go left.");
                    }
                    if (input == 2){
                        System.out.println("You can't go right.");
                    }
                    else if(input == 3){
                        System.out.println("You can't go forwards.");
                    }
                    input = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("not a valid number");
                //io.nextLine(); // to reset the scanner
                server.nextLine();
            }
        }
        return input;
    }

    //A method to start the game
    private static void decisionLoop(Node n){
        while(true){
            //debug
            //System.out.println(n.toString());

            int nextNodeId;
            if (n.getLeftPathID() == n.getRightPathID() && n.getRightPathID() == n.getForwardPathID() && n.getLeftPathID() != -1){//
                System.out.println(n.getText());
                nextNodeId = n.getLeftPathID();
            }
            else if(n.getNodeId() == endNode){
                System.out.println(n.getText());
                break;
            }
            else {
                System.out.println(introToNode + n.getSymbol() + " symbol. ");
                System.out.println(n.getText());
                //put into method to break up the code a bit to make it more readable
                int input = getDecision(-1, false, n);
                nextNodeId = getPathId(input, n);

                //debug
                //System.out.println(nextNodeId);
            }
            n = server.getNode(nextNodeId);
        }
    }

    //Old method for getting input from the scanner
    /*public static int getInput(Scanner io){
        return io.nextInt();
    }*/

    //A method to get the path id based on input
    static int getPathId(int num, Node n){
        if (num == 1){
            return n.getLeftPathID();
        }
        if(num == 2){
            return n.getRightPathID();
        }
        else if(num == 3){
            return n.getForwardPathID();
        }
        return -1;
    }

    private static boolean returnNodeCondtion(Node n){
        if(n.getLeftPathID() == n.getRightPathID() && n.getRightPathID() == n.getForwardPathID() && n.getLeftPathID() == -1){
            return true;
        }
        else {
            return false;
        }
    }


}
