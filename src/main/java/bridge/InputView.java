package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    /**
     * readBridgeSize에 다시 길이 값 입력, 입력 값 예외처리
     * 
     * @return
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다." + "\n");
        System.out.println("다리의 길이를 입력해 주세요.");
        int readBridgeSize = 0;
        try {
            readBridgeSize = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 건너기 게임 숫자 입력타입 오류.");
        }
        readBridgeSizeException(readBridgeSize);
        return readBridgeSize;
    }

    /**
     * 다리의 길이는 3 ~ 20 사이의 숫자가 아니면 오류.
     * 
     * @param readBridgeSize
     */
    public void readBridgeSizeException(int readBridgeSize) {
        if (readBridgeSize < 3 || 20 < readBridgeSize) {
            throw new IllegalArgumentException("[ERROR] 다리 건너기 게임 숫자 입력 오류.");
        }
    }

    /**
     * readMoving에 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("\n" + "이동할 칸을 선택해주세요. (위: U, 아래: D)");

        String readMoving = Console.readLine();
        readMovingException(readMoving);
        return readMoving;
    }

    /**
     * 입력 값이 (위: U, 아래: D)가 아니면 오류.
     * 
     * @param readMoving
     */
    public void readMovingException(String readMoving) {
        if (!readMoving.equals("U") && !readMoving.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동 위/아래 입력 오류.");
        }
    }

    /**
     * readGameCommand에 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("\n" + "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        String readGameCommand = Console.readLine();
        readGameCommandException(readGameCommand);
        return readGameCommand;
    }

    /**
     * 입력 값이 (재시도: R, 종료: Q)가 아니면 오류.
     * 
     * @param readGameCommand
     */
    public void readGameCommandException(String readGameCommand) {
        if (!readGameCommand.equals("R") && !readGameCommand.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 게임 재시작/종료 입력 오류.");
        }
    }
}
