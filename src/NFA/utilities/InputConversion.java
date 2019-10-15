package NFA.utilities;

public class InputConversion {

    public InputConversion(){}

    /*//SYMBOL KEY
            e = 0
            a = 1
            b = 2
            c = 3
            d = 4
            e = 5
            | = 6
            & = 7
            * = 8*/
    public int[] charToInt(String input){
        int[] converted = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'E') {
                converted[i] = 0;
                continue;
            }
            if (input.charAt(i) == 'a' ||
                    input.charAt(i) == 'b' ||
                    input.charAt(i) == 'c' ||
                    input.charAt(i) == 'd' ||
                    input.charAt(i) == 'e') {
                converted[i] = input.charAt(i) - 96;
                continue;
            }

            if (input.charAt(i) == '|') {
                converted[i] = 6;
                continue;
            }
            if (input.charAt(i) == '&') {
                converted[i] = 7;
                continue;
            }
            if (input.charAt(i) == '*') {
                converted[i] = 8;
            }
        }
        return converted;
    }

    public char translateSymbol(int n){
        if(n == 0){
            return 'E';
        }
        if(n == 1){
            return 'a';
        }
        if(n == 2){
            return 'b';
        }
        if(n == 3){
            return 'c';
        }
        if(n == 4){
            return 'd';
        }
        if(n == 5){
            return 'e';
        }
        if(n == 6){
            return '|';
        }
        if (n == 7){
            return '&';
        }
        if(n == 8){
            return '*';
        }
        return 'Z';
    }
}
