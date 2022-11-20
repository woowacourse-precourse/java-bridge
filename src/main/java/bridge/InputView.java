package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    static final int MIN_BRIDGE = 3;
    static final int MAX_BRIDGE = 20;
    static final String UP = "U";
    static final String DOWN = "D";
    static final String RETRY = "R";
    static final String QUIT = "Q";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        System.out.println("다리의 길이를 입력해주세요.");
        String sizeInput = Console.readLine();
        numericValidate(sizeInput);
        Integer size = Integer.parseInt(sizeInput);
        bridgeValueValidate(size);
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: " + UP + ", 아래: "+ DOWN + ")");
        String moveInput = Console.readLine();
        upDownValidate(moveInput);
        return moveInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + RETRY + ", 종료: "+ QUIT + ")");
        String retryInput = Console.readLine();
        retryValidate(retryInput);
        return retryInput;
    }

    private void numericValidate(String str) throws IllegalArgumentException {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorEnum.PREFIX.getMessage() + ErrorEnum.NUMERIC.getMessage());
        }
    }

    private void bridgeValueValidate(int num) throws IllegalArgumentException {
        if (num < MIN_BRIDGE || num > MAX_BRIDGE) {
            throw new IllegalArgumentException(ErrorEnum.PREFIX.getMessage() + ErrorEnum.BRIDGE_VALUE.getMessage());
        }
    }

    private void upDownValidate(String str) throws IllegalArgumentException {
        if (!str.equals(UP) && !str.equals(DOWN)) {
            throw new IllegalArgumentException(ErrorEnum.PREFIX.getMessage() + ErrorEnum.UP_DOWN.getMessage());
        }
    }

    private void retryValidate(String str) throws IllegalArgumentException {
        if (!str.equals(RETRY) && !str.equals(QUIT)) {
            throw new IllegalArgumentException(ErrorEnum.PREFIX.getMessage() + ErrorEnum.UP_DOWN.getMessage());
        }
    }
}
