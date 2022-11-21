package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BAGIC_ERROR_MESSAGE = "[ERROR]";

    public InputView() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();

    }

    public int readBridgeSize() {
        String Bridge_length = " ";
        System.out.println("다리의 길이를 입력해주세요.");
        Bridge_length = Console.readLine();
        while (readBridgeSize_ERROR(Bridge_length))
            Bridge_length = Console.readLine();
        int size = Integer.parseInt(Bridge_length);
        return size;
    }

    private boolean readBridgeSize_ERROR(String Bridge_length) {
        try {
            if (!(Bridge_length != null && Bridge_length.matches("^[0-9]*$")))
                throw new IllegalArgumentException(BAGIC_ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return true;
        }
        return false;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String Move_Enter = Console.readLine();
        return Move_Enter;

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String Enter = Console.readLine();
        return Enter;
    }
}
