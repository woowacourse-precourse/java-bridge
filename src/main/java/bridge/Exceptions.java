package bridge;

public class Exceptions {

    public static String validateBridgeLength(String readLine) {
        try {
            if (!readLine.matches("^[0-9]*?") || Integer.parseInt(readLine) < 3 || Integer.parseInt(readLine) > 20) {
                throw new IllegalArgumentException("[ERROR] 3이상 20이하의 숫자만 입력하세요.");
            }
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return readLine;
    }
}
