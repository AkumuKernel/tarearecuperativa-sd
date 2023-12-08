package peersim.pastry;

public class PastryDeleteMessage {

    private final int sourceNodeId;
    private final int key;
    private final MSPastryProtocol sender;

    public PastryDeleteMessage(int sourceNodeId, int key, MSPastryProtocol sender) {
        this.sourceNodeId = sourceNodeId;
        this.key = key;
        this.sender = sender;
    }

}
