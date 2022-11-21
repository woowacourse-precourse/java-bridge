package bridge.util;

public class Utils {

    public static int inputToNumber(String input){
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
