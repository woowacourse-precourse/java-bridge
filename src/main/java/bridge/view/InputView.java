package bridge.view;

import static bridge.util.ConsoleInput.readInt;
import static bridge.util.ConsoleInput.readLine;

import bridge.model.BridgeSize;
import bridge.model.Direction;
import bridge.model.GameCommand;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            printReadBridgeSizeMenu();
            return new BridgeSize(readInt()).intValue();
        } catch (IllegalArgumentException e) {
            print(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readDirection() {
        try {
            printReadMovingMenu();
            return Direction.from(readLine());
        } catch (IllegalArgumentException e) {
            print(e.getMessage());
            return readDirection();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        try {
            printReadGameCommand();
            return GameCommand.fromCommand(readLine());
        } catch (IllegalArgumentException e) {
            print(e.getMessage());
            return readGameCommand();
        }
    }

    private void printReadGameCommand() {
        print("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    private void printReadMovingMenu() {
        print("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    private void printReadBridgeSizeMenu() {
        print("다리 길이를 입력해 주세요.");
    }

    private void print(String message) {
        System.out.println(message);
    }
}
