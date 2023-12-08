package peersim.pastry;

import peersim.config.Configuration;
import peersim.core.CommonState;
import peersim.core.Network;
import peersim.core.Node;
import peersim.core.Control;
import peersim.edsim.EDSimulator;
import java.util.Random;

public class PastryOperations implements Control {

    // Constructor vacío
    public PastryOperations() {
        
    }    

    // Método para realizar una operación FIND en Pastry
    public static void findOperation(int sourceNodeId, int destinationNodeId) {
        Node sourceNode = Network.get(sourceNodeId);
        MSPastryProtocol sourcePastry = (MSPastryProtocol) sourceNode.getProtocol(Configuration.lookupPid("pastry"));

        // Simular una operación FIND
        long latency = calculateLatency(sourceNodeId, destinationNodeId);
        EDSimulator.add(latency, new PastryFindMessage(sourceNodeId, destinationNodeId, sourcePastry), sourceNode, Configuration.lookupPid("pastry"));
    }

    // Método para realizar una operación PUT en Pastry
    public static void putOperation(int sourceNodeId, int key, Object value) {
        Node sourceNode = Network.get(sourceNodeId);
        MSPastryProtocol sourcePastry = (MSPastryProtocol) sourceNode.getProtocol(Configuration.lookupPid("pastry"));

        // Simular una operación PUT
        long latency = calculateLatency(sourceNodeId, key);
        EDSimulator.add(latency, new PastryPutMessage(sourceNodeId, key, value, sourcePastry), sourceNode, Configuration.lookupPid("pastry"));
    }

    // Método para realizar una operación DELETE en Pastry
    public static void deleteOperation(int sourceNodeId, int key) {
        Node sourceNode = Network.get(sourceNodeId);
        MSPastryProtocol sourcePastry = (MSPastryProtocol) sourceNode.getProtocol(Configuration.lookupPid("pastry"));

        // Simular una operación DELETE
        long latency = calculateLatency(sourceNodeId, key);
        EDSimulator.add(latency, new PastryDeleteMessage(sourceNodeId, key, sourcePastry), sourceNode, Configuration.lookupPid("pastry"));
    }

    // Método auxiliar para calcular la latencia de la red
    private static long calculateLatency(int sourceNodeId, int destinationNodeId) {
        // Simulación de un retraso constante de 10 unidades de tiempo
        long baseLatency = 10;

        // Jitter aleatorio para introducir variabilidad en la latencia
        int jitterRange = 5; // Puedes ajustar este valor según tus necesidades
        Random random = new Random();
        long jitter = random.nextInt(jitterRange);

        return baseLatency + jitter;
    }
    // Constructor adicional que acepta un String, aunque no se utiliza
    public PastryOperations(String unused) {

    }

    @Override
    public boolean execute() {
        return false; // Devuelve true si la simulación debe continuar, false si debe detenerse
    }
}
