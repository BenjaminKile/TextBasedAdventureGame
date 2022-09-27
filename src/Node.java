//(NodeId, LeftPathID, RightPathID, ForwardPathID, Text)
public class Node {

    private int NodeId;;
    private int LeftPathID;
    private int RightPathID;
    private int ForwardPathID;
    public String Text;
    private String Symbol;

    public Node() {
    }

    //not used but kept for future development/ completeness
    public Node(int nodeId, int leftPathID, int rightPathID, int forwardPathID, String text, String symbol) {
        this.NodeId = nodeId;
        this.LeftPathID = leftPathID;
        this.RightPathID = rightPathID;
        this.ForwardPathID = forwardPathID;
        this.Text = text;
        this.Symbol = symbol;
    }


    public int getNodeId() {
        return NodeId;
    }

    public void setNodeId(int nodeId) {
        NodeId = nodeId;
    }

    public int getLeftPathID() {
        return LeftPathID;
    }

    public void setLeftPathID(int leftPathID) {
        LeftPathID = leftPathID;
    }

    public int getRightPathID() {
        return RightPathID;
    }

    public void setRightPathID(int rightPathID) {
        RightPathID = rightPathID;
    }

    public int getForwardPathID() {
        return ForwardPathID;
    }

    public void setForwardPathID(int forwardPathID) {
        ForwardPathID = forwardPathID;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    @Override
    public String toString() {
        return "Node{" +
                "NodeId=" + NodeId +
                ", LeftPathID=" + LeftPathID +
                ", RightPathID=" + RightPathID +
                ", ForwardPathID=" + ForwardPathID +
                ", Text='" + Text + '\'' +
                ", Symbol='" + Symbol + '\'' +
                '}';
    }
}
