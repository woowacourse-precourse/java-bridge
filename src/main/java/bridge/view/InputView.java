package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BridgeConstant.INPUT_BRIDGE_SIZE.getValue());
        String bridgeSizeInput = Console.readLine();
        // 예외 처리 하기(3,20 / 숫자만 입력)

        return Integer.parseInt(bridgeSizeInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(BridgeConstant.INPUT_MOVEMENT.getValue());
        String inputMoving = Console.readLine();
        //U , D 대문자만 입력 가능하도록, 숫자이면 예외, 공백도 예외
        return inputMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(BridgeConstant.RESTART.getValue());
        String inputGameCommand = Console.readLine();
        //예외처리 하기(Q, R만 입력하도록,숫자 다른언어 시 예외처리)
        return inputGameCommand;
    }
}
