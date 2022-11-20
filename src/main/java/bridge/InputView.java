package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        System.out.println("다리의 길이를 입력해주세요.");
        String sizeInput = Console.readLine();
        numericValidate(sizeInput);
        Integer size = Integer.parseInt(sizeInput);
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void numericValidate(String str) throws IllegalArgumentException {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorEnum.PREFIX.getMessage() + ErrorEnum.NUMERIC.getMessage());
        }
    }
}
