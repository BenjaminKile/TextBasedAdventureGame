import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Objects;
import javax.swing.*;

public class Main_GUI {
    //Data
    private static Server server;
    private static int endNode = 39;
    private static String introToNode = "You arrive at a junction with a ";
    // useless data
    static String leftPathTxt = "1 to go left";
    static String rightPathTxt = "2 to go right";
    static String forwardPathTxt = "3 to go forward";

    public static void main(String[] args) throws FileNotFoundException {
        server = new Server();
        JLabel label1 = new mylabel();
        label1.setBounds(0, 0, 800, 50);
        JLabel label2 = new mylabel();
        label2.setBounds(0, 50, 800, 50);
        JLabel label3 = new mylabel();
        label3.setBounds(0, 100, 800, 50);

        //label.setText("You enter the Maze.");
        /*label.setForeground(Color.BLACK);
        label.setFont(new Font("Comic Sans", Font.PLAIN,20));
        label.setBounds(0,0,800, 400);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.LEFT);*/


        JFrame frame = new Myframe();
        /*frame.setTitle("Maze Adventure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.setVisible(true);*/
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);


        while(true){
            System.out.println("You enter the Maze.");
            label1.setText("You enter the Maze");
            Node n = server.getNode(1);
            decisionLoop(n, label1, label2, label3);
            System.out.println("Would you like the play again?\nEnter any key to continue and n to stop.");
            label3.setText("Would you like the play again? (Yes / No)");// yes no will be buttons
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
    private static void decisionLoop(Node n, JLabel label1, JLabel label2, JLabel label3)  {
        while(true){
            //debug
            //System.out.println(n.toString());

            int nextNodeId;
            /*if (n.getLeftPathID() == n.getRightPathID() && n.getRightPathID() == n.getForwardPathID() && n.getLeftPathID() != -1){//
                System.out.println(n.getText());
                label3.setText(n.getText());

                label3.setVisible(true);
                label1.setEnabled(false);
                label2.setEnabled(false);
                nextNodeId = n.getLeftPathID();
            }*/
            if(n.getNodeId() == endNode){
                System.out.println(n.getText());
                label1.setText(n.getText());
                label2.setText("");
                break;
            }
            else {
                if(!(n.getLeftPathID() == n.getRightPathID() && n.getRightPathID() == n.getForwardPathID() && n.getLeftPathID() != -1)){
                    System.out.println(introToNode + n.getSymbol() + " symbol. ");
                    label1.setText(introToNode + n.getSymbol() + " symbol. ");
                }

                System.out.println(n.getText());

                label2.setText(n.getText());
                //label1.setEnabled(true);
                //label2.setEnabled(true);
                label3.setVisible(false);
                //put into method to break up the code a bit to make it more readable
                int input = getDecision(-1, false, n);
                nextNodeId = getPathId(input, n);

                //debug
                //System.out.println(nextNodeId);
            }
            n = server.getNode(nextNodeId);
        }
    }

    //Old method for getting input from the scanner *******************************************************************************************
    // ****************************************************************************************************************************************
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

    //method to return true if it's a node where it's a dead end
    private static boolean returnNodeCondtion(Node n){
        if(n.getLeftPathID() == n.getRightPathID() && n.getRightPathID() == n.getForwardPathID() && n.getLeftPathID() == -1){
            return true;
        }
        else {
            return false;
        }
    }
}
