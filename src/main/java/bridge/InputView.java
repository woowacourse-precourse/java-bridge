package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public InputView() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        try {
            String bridgeSize = Console.readLine();
            return validatedBridgeSize(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        try {
            String move = Console.readLine();
            Exception.validateByNull(move);
            Exception.validateByNotUOrD(move);
            return move;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return "[ERROR]";
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        try {
            String endCommand = Console.readLine();
            return validatedCommand(endCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return "[ERROR]";
        }
    }

    private int validatedBridgeSize(String bridgeSize) {
        Exception.validateByNull(bridgeSize);
        Exception.validateByNotNumber(bridgeSize);
        int size = Integer.parseInt(bridgeSize);
        Exception.validateByOverRange(size);
        return size;
    }

    private String validatedCommand(String command) {
        Exception.validateByNull(command);
        Exception.validateByNotROrQ(command);
        return command;
    }
}
