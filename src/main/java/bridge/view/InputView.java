package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING_DIRECTION = "이동할 칸을 선택해 주세요. (위: U, 아래: D)";
    private static final String INPUT_RETRY_GAME = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        String bridgeSizeInput = Console.readLine();
        // 예외 처리 하기(3,20 / 숫자만 입력)

        return Integer.parseInt(bridgeSizeInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVING_DIRECTION);
        String inputMoving = Console.readLine();
        //U , D 대문자만 입력 가능하도록, 숫자이면 예외, 공백도 예외
        return inputMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_RETRY_GAME);
        String inputGameCommand = Console.readLine();
        //예외처리 하기(Q, R만 입력하도록,숫자 다른언어 시 예외처리)
        return inputGameCommand;
    }
}
