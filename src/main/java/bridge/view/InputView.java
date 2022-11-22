package bridge.view;

import bridge.model.BridgeGame;
import camp.nextstep.edu.missionutils.Console;

import static bridge.model.Error.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    BridgeGame bridgeGame;

    public InputView(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public static int getValidBridgeSize() {
        int bridgeSize = 0;
        while (bridgeSize == 0) {
            try {
                bridgeSize = readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return bridgeSize;
    }

    public void getValidMoving() {
        String input = "";
        while (input.length() == 0) {
            try {
                input = readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        bridgeGame.move(input);
    }

    public String getValidGameCommand() {
        String input = "";
        while (input.length() == 0) {
            try {
                input = readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return input;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    private static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        System.out.println();

        isNumber(input);
        isStartZero(input);
        int size = Integer.parseInt(input);

        isValidNumber(size);
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    private String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        isValidFootHold(input);

        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    private String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();

        isValidCommand(input);

        return input;
    }
}
