//ARRIVATO A LL PASS BY VALUE O REFERENCE, TUTORIALSPOINT MODIFIER TYPES
package company;
//gui not added rn
import java.util.Scanner;

//to Rename to Calculator
public class Calculator {


    //TODO simple (gui) calculator and learn objects along the way
    public static void main(String[] args) {

        char escape = 'a';
        do{
            Scanner input = new Scanner(System.in);
            String toParse;
            toParse = input.nextLine();






            if (isStringLegal(toParse)) {
                //TODO parse the string
                String tempNum = "";
                float[] initializer = {1f};
                char[] cInitializer = {'+'};
                MyCharDynArray operators = new MyCharDynArray(cInitializer);
                MyFloatDynArray numbers = new MyFloatDynArray(initializer);
                boolean isFirstNumber = true;

                for (int i = 0; i < toParse.length(); ++i) {
                    if (Character.isDigit(toParse.charAt(i)) || toParse.charAt(i) == '.') {
                        tempNum += toParse.charAt(i);
                    } else if (isFirstNumber) {
                        numbers.current[0] = Float.parseFloat(tempNum);
                        isFirstNumber = false;
                        tempNum = "";
                        operators.current[0] = toParse.charAt(i);
                    } else {
                        numbers.append(Float.parseFloat(tempNum));
                        operators.append(toParse.charAt(i));
                        tempNum = "";

                    }
                }

                //At the end the last digit is appended
                numbers.append(Float.parseFloat(tempNum));


                //operate together
                float result = numbers.current[0];
                for (int i = 1; i < numbers.current.length; ++i){
                    if (operators.current[i-1] == '+'){
                        result += numbers.current[i];
                    }
                    if (operators.current[i-1] == '-'){
                        result -= numbers.current[i];
                    }
                    if (operators.current[i-1] == '/'){
                        if (numbers.current[i] == 0){
                            System.out.println("Error. Zero Divisor found");
                        }
                        else {
                            result /= numbers.current[i];
                        }
                    }
                    if (operators.current[i-1] == '*'){
                        result *= numbers.current[i];
                    }

                }

                System.out.print("Result is: ");
                System.out.println(result);

            }else{
                System.out.println("Illegal input.\nInput must contain only numbers and operators and not start or end with an operator");
            }




            System.out.print("Enter x to escape or other keys to repeat ");
            escape = input.next().charAt(0);

        }while(escape != 'x');



    }

    public static boolean isStringLegal(String toParse ){
        //è valida se sono tutti numeri o operatori e se c'è almeno un numero e un operatore e non inizia o finisce con un operatore
        //e non ripete un operatore
        //il punto non deve essere ripetuto o preceduto da operatore e non deve essere all'inizio/fine e deve essere seguito da un numero
        boolean isToParseLegal = false;
        boolean atLeastOneOperator = false;
        boolean atLeastOneNumber = false;
        boolean previousIsOperator = false;
        boolean operatorRepeats = false;
        char [] legalOperators = {'+','-','*','/','.'}; //dot behaves like an operator
        char [] legalNumbers = {'0','1','2','3','4','5','6','7','8','9'}; //adding this to float support
        int legalCharacterCounter = 0;

        for(int i = 0; i < toParse.length(); ++i){
            for (char j : legalNumbers){
                if (toParse.charAt(i) == j){
                    ++legalCharacterCounter;
                    atLeastOneNumber = true;
                    previousIsOperator = false;
                    break;
                }
            }
            for (char j : legalOperators){
                if (toParse.charAt(i) == j){
                    ++legalCharacterCounter;
                    atLeastOneOperator = true;
                    if (previousIsOperator){
                        operatorRepeats = true;
                    }
                    previousIsOperator = true;
                    break;
                }
            }
        }

        if (legalCharacterCounter == toParse.length() && atLeastOneNumber && atLeastOneOperator && !operatorRepeats){
            isToParseLegal = true;
        }

        for ( char j : legalOperators){
            if (toParse.charAt(0) == j || toParse.charAt(toParse.length()-1) == j){
                isToParseLegal = false;
                break;
            }
        }

        return isToParseLegal;
    }

}

