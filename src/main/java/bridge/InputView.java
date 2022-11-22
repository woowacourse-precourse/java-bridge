package bridge;

import static bridge.Validate.validateInputMove;
import static bridge.Validate.validateInputNumber;
import static bridge.Validate.validateInputRetry;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public String readUserInput() {
        return Console.readLine();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String userInputConsole = readUserInput();
        validateInputNumber(userInputConsole);
        int userInput = Integer.parseInt(userInputConsole);
        System.out.println(" ");
        return userInput;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String userInputConsole = readUserInput();
        validateInputMove(userInputConsole);
        System.out.println(" ");
        return userInputConsole;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String userInputConsole = readUserInput();
        validateInputRetry(userInputConsole);
        return userInputConsole;
    }
}
