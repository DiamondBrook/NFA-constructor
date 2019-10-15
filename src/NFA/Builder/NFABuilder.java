package NFA.Builder;

import NFA.utilities.InputConversion;
import NFA.NFADataStructures.NFA;
import NFA.NFADataStructures.Node;
import NFA.NFADataStructures.Transition;

import java.util.ArrayList;

public class NFABuilder {
    int totalStates = 0;

    public NFABuilder() {}

    public NFA buildNFA(String inputString) {
        InputConversion iC = new InputConversion();
        NFAStack stack = new NFAStack();
        int[] input = iC.charToInt(inputString);

        //for every symbol in the input
        for (int i = 0; i < input.length; i++) {
            int symbol = input[i];

            //UNION OPERATOR
            if (symbol == 6) {
                NFA nfa1 = stack.pop();
                NFA nfa2 = stack.pop();
                NFA nfa = this.union(nfa1, nfa2);
                stack.push(nfa);
                continue;
            }
            //CONCATENATION OPERATOR
            if (symbol == 7) {
                NFA nfa2 = stack.pop();
                NFA nfa1 = stack.pop();
                NFA nfa = this.concatenate(nfa1, nfa2);
                stack.push(nfa);
                continue;
            }
            //STAR OPERATOR
            if (symbol == 8) {
                NFA nfa1 = stack.pop();
                NFA nfa = this.kleeneStar(nfa1);
                stack.push(nfa);
            }
            //create an NFA that accepts the single symbol transition
            else {
                NFA E = this.createNFA(symbol);
                stack.push(E);
            }
        }
        NFA nfa = stack.pop();
        totalStates = 0;
        return nfa;
    }

    /*performs the kleene star operation on the passed NFA*/
    private NFA kleeneStar(NFA nfa1){
        //create one new node and two new transitions
        Node newStart = createNewNode();
        Transition E1 = new Transition(0, newStart);
        Transition E2 = new Transition(0, nfa1.startState);

        //add the new epsilon transitions to the newly added node and the accept node
        nfa1.acceptState.addTransition(E1);
        newStart.addTransition(E2);
        nfa1.addNode(newStart);

        //lump all nodes into one collection for NFA constructor
        ArrayList<Node> allNodes = new ArrayList<Node>(0);
        allNodes.addAll(nfa1.states);

        //construct and return
        return new NFA(allNodes, newStart, newStart);
    }

    /*performs concatenation on nfa1 and nfa2
    * nfa1, nfa2 -> (nfa1 & nfa2)*/
    private NFA concatenate(NFA nfa1, NFA nfa2) {
        //create a single epsilon transition
        Transition t = new Transition(0, nfa2.startState);
        nfa1.acceptState.addTransition(t);
        ArrayList<Node> allNodes = new ArrayList<Node>(0);
        allNodes.addAll(nfa1.states);
        allNodes.addAll(nfa2.states);
        return new NFA(allNodes, nfa1.startState, nfa2.acceptState);
    }

    /*performs the union operation on nfa1 and nfa2
    * nfa1, nfa2 -> (nfa1 U nfa2)*/
    private NFA union(NFA nfa1, NFA nfa2) {
        //create two new nodes and four new epsilon transitions
        Node newStart = createNewNode();
        Node newAccept = createNewNode();
        Transition E1 = new Transition(0, nfa1.startState);
        Transition E2 = new Transition(0, nfa2.startState);
        Transition E3 = new Transition(0, newAccept);
        Transition E4 = new Transition(0, newAccept);

        //connect the new start node to the two old start nodes using epsilon transitions
        newStart.addTransition(E1);
        newStart.addTransition(E2);

        //connect the two old accept states to the new accept state using epsilon transitions
        nfa1.acceptState.addTransition(E3);
        nfa2.acceptState.addTransition(E4);

        //hook everything up. too lazy to finish commenting
        ArrayList<Node> allNodes = new ArrayList<Node>(0);
        allNodes.addAll(nfa1.states);
        allNodes.addAll(nfa2.states);
        allNodes.add(newStart);
        allNodes.add(newAccept);
        return new NFA(allNodes, newStart, newAccept);
    }

    /*Creates a new NFA object that accepts the single character symbol*/
    private NFA createNFA(int symbol) {
        Node start = createNewNode();
        Node accept = createNewNode();
        Transition t = new Transition(symbol, accept);
        start.addTransition(t);
        ArrayList<Node> nodeList = new ArrayList<Node>(2);
        nodeList.add(start);
        nodeList.add(accept);
        NFA newNFA = new NFA(nodeList, start, accept);
        return newNFA;
    }

    private Node createNewNode(){
        Node temp = new Node(totalStates);
        totalStates++;
        return temp;
    }
}
