import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {


    //Data
    private Scanner fileLink;
    private ArrayList<Node> nodes;
    private int currentIndex = 0;
    private Scanner io;

    public Server()  throws FileNotFoundException {
        java.io.File prc = new java.io.File("src/Nodes.csv");
        fileLink = new Scanner(prc);
        nodes = new ArrayList<Node>();
        io = new Scanner(System.in);
        while(hasAnotherLine()){
            //System.out.println(getLine());
            String[] lineArray = getLine().split("\\s*,\\s*");
          Node n = new Node();
          try {//come back here to remove the try catch block
              n.setNodeId(Integer.parseInt(lineArray[0]) );
              n.setLeftPathID(Integer.parseInt(lineArray[1]));
              n.setRightPathID(Integer.parseInt(lineArray[2]));
              n.setForwardPathID(Integer.parseInt(lineArray[3]));
              n.setText(lineArray[4]);
          }
          catch (NumberFormatException e) {
              e.printStackTrace();
          }
            nodes.add(n);
        }
    }

    public String toString() {

        String s = "";

        for(Node n : nodes){
            s += n.toString() + "\n";
        }

        return s;
    }

    public Node getNode(int Id){
        for(Node n: nodes){
            if(n.getNodeId() == Id){
                return n;
            }
        }
        return null;
    }

    public String getLine() {
        return fileLink.nextLine();
    }
    public boolean hasAnotherLine(){
        return fileLink.hasNext();
    }
}