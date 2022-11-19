package bridge;

public class Validation {
    private final String BRIDGE_MESSAGE = "[ERROR] 다리 길이 입력은 3이상 20이하의 숫자를 입력할 수 있습니다.";
    private void notNumberFormat(String input){
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(BRIDGE_MESSAGE);
        }
    }
}
