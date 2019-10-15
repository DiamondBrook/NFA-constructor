package NFA.NFADataStructures;

public class Transition {
    /*Since it is easier to compute integers than strings,
    our symbol characters will be represented with integers instead

    SYMBOL KEY:
    0 = epsilon
    1 = 'a'
    2 = 'b'
    3 = 'c'
    4 = 'd'
    5 = 'e'
    */

    public int symbol;
    public Node nextState;

    public Transition(int symbol, Node nextState){
        this.symbol = symbol;
        this.nextState = nextState;
    }
}
