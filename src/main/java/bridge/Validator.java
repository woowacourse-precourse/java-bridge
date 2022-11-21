package bridge;

public class Validator {

    private static IllegalArgumentException exit_Program = new IllegalArgumentException();

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
            throw exit_Program;
        }
    }



}
