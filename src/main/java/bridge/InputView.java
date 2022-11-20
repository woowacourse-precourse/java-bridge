package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String ONLY_CONTAINS_NUMBER_REGEX = "^[0-9]*$";
    private static final String RANGE_ERROR = "[ERROR] 3에서 20까지의 숫자를 입력해 주시기 바랍니다.";
    private static final String NUMBER_ERROR = "[ERROR] 올바른 숫자가 아닙니다.";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        String readLine = Console.readLine();
        validateRange(readLine);
        validateType(readLine);
        return Integer.parseInt(Console.readLine());
    }

    private void validateRange(String readLine){
        int readLength= Integer.parseInt(readLine);
        if(readLength > MAX_BRIDGE_SIZE || readLength < MIN_BRIDGE_SIZE ){
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    private void validateType(String readLine){
        if(readLine.matches(ONLY_CONTAINS_NUMBER_REGEX)){
            throw new IllegalArgumentException(NUMBER_ERROR);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
