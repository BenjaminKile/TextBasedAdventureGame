import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {
    //Data
    static String leftPathTxt = "1 to go left";
    static String rightPathTxt = "2 to go right";
    static String forwardPathTxt = "3 to go forward";

    //GO BACK AND SPLIT THIS INTO OTHER METHODS
    public static void main(String[] args) throws FileNotFoundException {
        Server server = new Server();
        Scanner io = new Scanner(System.in);


        System.out.println(server.toString());
        Node n = server.getNode(1);
        while(true){
            System.out.println(n.toString());
            int nextNodeId;
            if (n.getLeftPathID() == n.getRightPathID() && n.getRightPathID() == n.getForwardPathID() && n.getLeftPathID() == -1){
                nextNodeId = n.getLeftPathID();
            }
            else {
                //maybe put this in the get input method
                // try catch block ready check?
                int input = -1;
                boolean isOkInput = false;
                //https://stackoverflow.com/questions/45509594/getting-input-in-java-using-nextint
                while (!isOkInput){
                    try {
                        while ( (input <= 0 || input > 3) ){//would be nice if this was in the catch block as invalid input
                            System.out.println("Enter "+leftPathTxt +", "+ rightPathTxt+" or " +forwardPathTxt);
                            //using a simple get input method
                            // to change
                            input = getInput(io);
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
                            else {
                                System.out.println("You can't go forwards.");
                            }
                            input = -1;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("not a valid number");
                        io.nextLine(); // to reset the scanner
                    }
                }

                nextNodeId= getPathId(input, n);

                System.out.println(nextNodeId);


            }
            n = server.getNode(nextNodeId);

        }

    }

    public static int getInput(Scanner io){
        return io.nextInt();
    }
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


}
