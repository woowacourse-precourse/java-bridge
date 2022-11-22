package view;

// 여기에서만 readLine()을 사용할 것.

import camp.nextstep.edu.missionutils.Console;
import data.PrintGuide;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() throws IllegalArgumentException {
        try {
            PrintGuide.SIZE.printGuideWithLine();
            return readLine();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                PrintGuide.MOVE.printGuideWithLine();
                return readLine();
            } catch (IllegalArgumentException e) {
                System.out.println("U or D");
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        while (true) {
            try {
                PrintGuide.RESTART.printGuideWithLine();
                return readLine();
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private String readLine() {
        String liner = Console.readLine();
        return liner;
    }
}
