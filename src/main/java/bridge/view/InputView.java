package bridge.view;

import bridge.validation.Validation;
import bridge.validation.enumeration.Mode;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
        String userInput = Console.readLine().trim();
        Validation.verifyUserInputBridgeLength(userInput);
        return Integer.parseInt(userInput);
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String move = Console.readLine().trim();
        Validation.verifyUserInputIsCharacter(move, Mode.UpOrDown);
        return move;
    }

    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String retryOrQuit = Console.readLine().trim();
        Validation.verifyUserInputIsCharacter(retryOrQuit, Mode.RetryOrQuit);
        return retryOrQuit;
    }
}
