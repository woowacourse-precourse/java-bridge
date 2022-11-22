package bridge.view;

import bridge.validation.Validation;
import bridge.validation.enumeration.Mode;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String ENTER_THE_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY_OR_QUIT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int readBridgeSize() {
        System.out.println(START_MESSAGE);
        System.out.println();
        System.out.println(ENTER_THE_BRIDGE_SIZE_MESSAGE);
        String userInput = Console.readLine().trim();
        Validation.verifyUserInputBridgeLength(userInput);
        return Integer.parseInt(userInput);
    }

    public String readMoving() {
        System.out.println(MOVE_MESSAGE);
        String move = Console.readLine().trim();
        Validation.verifyUserInputIsCharacter(move, Mode.UpOrDown);
        return move;
    }

    public String readGameCommand() {
        System.out.println(RETRY_OR_QUIT_MESSAGE);
        String retryOrQuit = Console.readLine().trim();
        Validation.verifyUserInputIsCharacter(retryOrQuit, Mode.RetryOrQuit);
        return retryOrQuit;
    }
}
