package bridge.view;

import bridge.view.validation.InputValidation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private InputValidation validation = new InputValidation();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        boolean isDigit = false;
        String readLine = "";
        while (true) {
            System.out.println("다리의 길이를 입력해주세요.");
            readLine = Console.readLine();
            isDigit = validation.test(readLine, isDigit);

            if (isDigit) break;
        }
        return Integer.parseInt(readLine);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        boolean isPattern = false;
        String position = "";
        while (true) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            position = Console.readLine();
            isPattern = validation.test1(position, isPattern);
            if (isPattern) {
                break;
            }
        }
        return position;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return Console.readLine();
    }
}
