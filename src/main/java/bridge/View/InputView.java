package bridge.View;

import camp.nextstep.edu.missionutils.Console;

import static bridge.RetryOrQuit.*;
import static bridge.UpDown.*;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    StaticView staticView = new StaticView();

    public static int bridgeSize;
    /**
     * 다리의 길이를 입력받는다.
     */
    public void readBridgeSize() { // validation 필요
        String input;

        while (true) {
            try {
                staticView.askSizeMsg();
                input = Console.readLine();
                toIntAndValidateIsNum(input);
                checkNumRange();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }


    }
//===========================================
    private static void checkNumRange() {
        if (3 > bridgeSize || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private static void toIntAndValidateIsNum(String input) throws IllegalArgumentException{
        try {
            bridgeSize = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
// ==============================================
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() { // validation 필요
        String moveInput;

        while (true) {
            try {
                staticView.askMoveMsg();
                moveInput = Console.readLine();

                if (!moveInput.equals(UP.getValue()) && !moveInput.equals(DOWN.getValue())) {
                    throw new IllegalArgumentException("[ERROR] U 또는 D 만 입력 가능합니다.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return moveInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String commandInput;
        while (true) {
            try {
                commandInput = Console.readLine();

                if (!commandInput.equals(RETRY.getMessage()) && !commandInput.equals(QUIT.getMessage())) {
                    throw new IllegalArgumentException("[ERROR] R 또는 Q 만 입력해주세요.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return commandInput;
    }
}
