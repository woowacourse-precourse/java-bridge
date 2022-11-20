package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final String readBridgeSizeMessage = "다리의 길이를 입력해주세요.";
    private final String readMovingMessage = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String readGameCommandMessage = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(readBridgeSizeMessage);
        String bridgeSize = readLine();
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(readMovingMessage);
        String userAnswer = readLine();
        return userAnswer;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(readGameCommandMessage);
        String userCommand = readLine();
        return userCommand;
    }
}
