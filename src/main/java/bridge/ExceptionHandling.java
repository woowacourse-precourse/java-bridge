package bridge;

public class ExceptionHandling {
    public static void instanceChangeChecking(String input){
        try{
            int result = Integer.parseInt(input);
        }catch (NumberFormatException numberFormatException){
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void numberBoundaryChecking(int input){
        if(input <3 || input > 20){
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
