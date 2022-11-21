package bridge;

import Statements.ErrorStatements;

public class Validator {

    private static IllegalArgumentException exit_Program = new IllegalArgumentException();
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();

    public static void isNumber(String input) {
        char[] inputCharacters = input.toCharArray();
        for (int i = 0; i < inputCharacters.length; i += 1) {
            if ((int) inputCharacters[i] < 48 || (int) inputCharacters[i] > 57) {
                throw exit_Program;
            }
        }
    }

    public static void tryCatchIsNumber(String input){
        try{
         isNumber(input);
        }catch(IllegalArgumentException e){
            outputView.printStatements(ErrorStatements.NOT_NUMBER_ERROR.warned());
            outputView.printStatements("");
            throw exit_Program;
        }
    }

    public static void isNumberInValidRange(int number) {
        if (number < 3 || number > 20) {
            throw exit_Program;
        }
    }

    public static void tryCatchIsNumberInValidRange(int input){
        try{
            isNumberInValidRange(input);
        }catch(IllegalArgumentException e){
            outputView.printStatements(ErrorStatements.NUMBER_RANGE_ERROR.warned());
            outputView.printStatements("");
            throw exit_Program;
        }
    }

    public static String isUorD(String uOrD){
        if(uOrD=="U"){
            return uOrD;
        }
        if(uOrD=="D"){
            return uOrD;
        }
        throw exit_Program;
    }

    public static String tryCatchIsUorD(String input){
        try{
            return isUorD(input);
        }catch(IllegalArgumentException e){
            outputView.printStatements(ErrorStatements.INVALID_FORMAT_ERROR.warned());
            outputView.printStatements("");
            throw exit_Program;
        }
    }
}
