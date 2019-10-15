package NFA.NFADataStructures;

import java.util.ArrayList;

public class NFA {
    public ArrayList<Node> states;
    public Node startState;
    public Node acceptState;

    public NFA(ArrayList<Node> states, Node startNode, Node acceptNode){
        this.states = states;
        startState = startNode;
        acceptState = acceptNode;
    }

    public void addNode(Node n1){
        states.add(n1);
    }

    public String toString() {
        String allTrans = "Start State: " + startState.state + " | Accept state: " + acceptState.state + "\n======================\n";
        for (int i = 0; i < states.size(); i++) {
            allTrans = allTrans + states.get(i).toString();
        }
        return allTrans;
    }
}
