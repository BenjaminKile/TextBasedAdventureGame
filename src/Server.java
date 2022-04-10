import java.util.ArrayList;
import java.util.Scanner;

public class Server {


    //private Node[] nodes;
    private ArrayList<Node> nodes;
    private int currentIndex = 0;
    private Scanner io;

    public Server()   {
        //nodes = new Node[size]; (int size)
        nodes = new ArrayList<Node>();
        io = new Scanner(System.in);
    }

    public int size() {
        //return nodes.length;
        return nodes.size();
    }

    public void add(Node n){
        /*nodes[currentIndex] = n;
        if(currentIndex < size()) currentIndex++;*/
        nodes.add(n);
    }

    public String toString() {

        String s = "";

        for(Node n : nodes){
            s += n.toString() + "\n";
        }

        return s;
    }
    public String getString() {
        String input = "";
        input += io.nextLine();
        return input;
    }

    public int getInt() {
        int input = 0;
        input += io.nextInt();
        io.nextLine();
        return input;
    }

}