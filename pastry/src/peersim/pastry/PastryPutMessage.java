package peersim.pastry;

public class PastryPutMessage {

    private final int sourceNodeId;
    private final int key;
    private final Object value;
    private final MSPastryProtocol sender;

    public PastryPutMessage(int sourceNodeId, int key, Object value, MSPastryProtocol sender) {
        this.sourceNodeId = sourceNodeId;
        this.key = key;
        this.value = value;
        this.sender = sender;
    }

}
