import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {


    //Data
    private Scanner fileLink;
    private ArrayList<Node> nodes;
    private  Scanner io;

    public Server()  throws FileNotFoundException {
        java.io.File prc = new java.io.File("src/Nodes.csv");
        fileLink = new Scanner(prc);
        nodes = new ArrayList<>();

        io = new Scanner(System.in);
        while(hasAnotherLine()){
            //debug
            //System.out.println(getLine());
            String[] lineArray = getLine().split("\\s*,\\s*");
            //debug
            //System.out.println(lineArray.length);
          Node n = new Node();
          //will cause errors if the csv file isn't setup properly

            n.setNodeId(Integer.parseInt(lineArray[0]) );
            n.setLeftPathID(Integer.parseInt(lineArray[1]));
            n.setRightPathID(Integer.parseInt(lineArray[2]));
            n.setForwardPathID(Integer.parseInt(lineArray[3]));
            n.setText(lineArray[4]);
            n.setSymbol(lineArray[5]);
            nodes.add(n);
        }
    }

    public String toString() {

        StringBuilder s = new StringBuilder();

        for(Node n : nodes){
            s.append(n.toString()).append("\n");
        }

        return s.toString();
    }

    public Node getNode(int Id){
        for(Node n: nodes){
            if(n.getNodeId() == Id){
                return n;
            }
        }
        return null;
    }

    public int getInput(){
        return io.nextInt();
    }

    public void nextLine(){
        io.nextLine();
    }

    public String getString(){
        return io.next();
    }


    public String getLine() {
        return fileLink.nextLine();
    }
    public boolean hasAnotherLine(){
        return fileLink.hasNext();
    }
}