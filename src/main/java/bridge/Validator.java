package bridge;

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
            outputView.printStatements("");
            throw exit_Program;
        }
    }
}
