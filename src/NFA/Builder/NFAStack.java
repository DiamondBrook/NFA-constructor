package NFA.Builder;

import NFA.NFADataStructures.NFA;

public class NFAStack {
    private NFA[] nfaStack = new NFA[3];
    private int head = -1;

    //empty constructor
    NFAStack(){}

    public boolean push(NFA a){
        if(this.isFull()){
            return false;
        }
        head++;
        nfaStack[head] = a;
        return true;
    }

    public NFA pop(){
        if(this.isEmpty()){
            return null;
        }
        NFA temp = nfaStack[head];
        nfaStack[head] = null;
        head--;
        return temp;
    }

    public boolean isEmpty(){
        if (this.head == -1){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (this.head == 3) {
            return true;
        }
        return false;
    }

    public int getHead(){
        return head;
    }
}
