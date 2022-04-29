import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Server server = new Server();
        Scanner io = new Scanner(System.in);
        //System.out.println("How many records do you want");
        System.out.println(server.toString());
        Node n = server.getNode(1);
        while(true){
            System.out.println(n.toString());

            //maybe put this in the get input method
            // try catch block ready check?
            int input = -1;
            boolean isOkInput = false;
            //https://stackoverflow.com/questions/45509594/getting-input-in-java-using-nextint
            while (!isOkInput){
                try {
                    while ((input < 0 || input > 3)){//would be nice if this was in the catch block as invalid input
                        System.out.println("Enter 1 for left, 2 for right or 3 for forward");
                        input = getInput(io);
                    }
                    isOkInput = true;

                } catch (InputMismatchException e) {
                    System.out.println("not a valid number");
                    io.nextLine(); // to reset the scanner
                }
            }

            int nextNodeId= getPathId(input, n);

            System.out.println(nextNodeId);

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
