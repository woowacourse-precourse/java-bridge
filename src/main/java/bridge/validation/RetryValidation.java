package bridge.validation;

public class RetryValidation {

    public static boolean retryValidation(String input){
        try {
            inNotValidation(input);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void inNotValidation(String input){
        if(!(input.equals("R") || input.equals("Q"))){
            System.out.println("[ERROR] R 또는 Q만 입력 가능합니다.");
            throw new IllegalArgumentException();
        }
    }
}
