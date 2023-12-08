package peersim.pastry;

public class PastryFindMessage {

    private final int sourceNodeId;
    private final int destinationNodeId;
    private final MSPastryProtocol sender;

    public PastryFindMessage(int sourceNodeId, int destinationNodeId, MSPastryProtocol sender) {
        this.sourceNodeId = sourceNodeId;
        this.destinationNodeId = destinationNodeId;
        this.sender = sender;
    }

}