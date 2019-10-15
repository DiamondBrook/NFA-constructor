package NFA.utilities;

public class inputChecker {

    public inputChecker(){}

    public boolean checkInput(String input){
        for(int i = 0; i < input.length(); i ++){
            if(input.charAt(i) == 'a' ||
                    input.charAt(i) == 'b' ||
                    input.charAt(i) == 'c' ||
                    input.charAt(i) == 'd' ||
                    input.charAt(i) == 'e' ||
                    input.charAt(i) == 'E' ||
                    input.charAt(i) == '|' ||
                    input.charAt(i) == '&' ||
                    input.charAt(i) == '*'){}
            else{return false;}
        }
        return true;
    }
}
