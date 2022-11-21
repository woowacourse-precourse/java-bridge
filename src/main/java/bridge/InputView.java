package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
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
        try {
            validateRange(readLine);
            validateType(readLine);
            return Integer.parseInt(readLine);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void validateRange(String readLine){
        int readLength= Integer.parseInt(readLine);
        if(readLength > MAX_BRIDGE_SIZE || readLength < MIN_BRIDGE_SIZE ){
            System.out.println(RANGE_ERROR);
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    private void validateType(String readLine){
        if(!readLine.matches(ONLY_CONTAINS_NUMBER_REGEX)){
            System.out.println(NUMBER_ERROR);
            throw new IllegalArgumentException(NUMBER_ERROR);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgeEnum readMoving() {
        System.out.println(INPUT_MOVING);
        String readMove = Console.readLine();
        return BridgeEnum.createBridgeStringType(readMove);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
