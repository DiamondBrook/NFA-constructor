import NFA.Builder.*;
import NFA.NFADataStructures.NFA;
import NFA.utilities.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class main {
    public static void main(String[] args) {
        NFABuilder builder = new NFABuilder();
        inputChecker iC = new inputChecker();
        String fileName = args[0];
        try {
            BufferedReader input = new BufferedReader (new InputStreamReader(new FileInputStream(fileName)));
            String line;
            while ((line = input.readLine()) != null){
                String expr = line;
                if(!iC.checkInput(expr)){
                    System.out.println("Incorrect input format. Check your input file.\nOFFENDING EXPRESSION: " + expr);
                    break;
                }
                System.out.println("<><><><><><><><><><><><><><<>\n" + expr);
                NFA nfa = builder.buildNFA(expr);
                System.out.println(nfa.toString());

            }
            input.close();
        }
        catch (Exception e) {
            System.out.println("Error reading input file");
            System.exit(1);
        }
    }
}
