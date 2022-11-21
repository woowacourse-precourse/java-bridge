package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    public static final String INPUT_BRIDGE_SIZE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String INPUT_MOVING_ERROR = "[ERROR] (위 : U, 아래 : D)만 입력 가능합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
            int bridgeSize = Integer.parseInt(Console.readLine());
            validateRange(bridgeSize);
            return bridgeSize;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(INPUT_BRIDGE_SIZE_ERROR);
        }
    }

    private void validateRange(int bridgeSize) {
        if(bridgeSize < 3 || bridgeSize > 20){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVING_MESSAGE);
        String moving = Console.readLine();
        validateUorD(moving);
        return moving;
    }

    private void validateUorD(String moving){
        if(!moving.equals("U") || !moving.equals("D")){
            throw new IllegalArgumentException(INPUT_MOVING_ERROR);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
