package NFA.NFADataStructures;

import NFA.utilities.InputConversion;

import java.util.ArrayList;

public class Node {
    int state;
    ArrayList<Transition> transitions = new ArrayList<Transition>(0);

    public Node(int state){
        this.state = state;
    }

    public void addTransition(Transition t){transitions.add(t); }

    public String toString(){
        String allTrans = "";
        InputConversion iC = new  InputConversion();
        for(int i = 0; i < transitions.size(); i++){
            Transition t = transitions.get(i);
            allTrans = allTrans + "(Q" + state + ", " + iC.translateSymbol(t.symbol) + ") -> Q" + t.nextState.state + " \n";
        }
        return allTrans;
    }
}
