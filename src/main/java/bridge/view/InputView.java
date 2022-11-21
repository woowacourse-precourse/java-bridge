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
        System.out.println("다리의 길이를 입력해주세요.");
        String inputBridgeSize = Console.readLine();
        try {
            return bridgeSize(inputBridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    private int bridgeSize(String inputBridgeSize) {
        try {
            int bridgeSize = Integer.parseInt(inputBridgeSize);
            if (bridgeSize < 3 || bridgeSize > 20) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
            return bridgeSize;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String inputMoving = Console.readLine();
        try {
            return BridgeBlock.getBlockName(inputMoving);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String inputGameCommand = Console.readLine();
        try {
            return GameCommand.willRestart(inputGameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }
}
