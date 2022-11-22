package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BAGIC_ERROR_MESSAGE = "[ERROR]";
    public static final String Retry_Enter = "R";
    public static final String Ending_Enter = "Q";
    public static final String Up_Enter = "U";
    public static final String Down_Enter = "D";
    private static final String StartPrint = "다리 건너기 게임을 시작합니다.";
    private static final String readPrint = "다리의 길이를 입력해주세요.";
    private static final String readMovingPrint = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String readGameCommandPrint = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    public InputView() {
        System.out.println(StartPrint);
        System.out.println();

    }

    public int readBridgeSize() {
        String Bridge_length = " ";
        System.out.println(readPrint);
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
        System.out.println(readMovingPrint);
        String Move_Enter = Console.readLine();
        while (readMoving_ERROR(Move_Enter)) {
            Move_Enter = Console.readLine();
        }
        return Move_Enter;

    }

    private boolean readMoving_ERROR(String Bridge_length) {
        try {
            if (!(Bridge_length.equals(Up_Enter) || Bridge_length.equals(Down_Enter)))
                throw new IllegalArgumentException(BAGIC_ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(readGameCommandPrint);
        String Enter = Console.readLine();
        while (readGameCommand_ERROR(Enter)) {
            Enter = Console.readLine();
        }
        return Enter;
    }

    private boolean readGameCommand_ERROR(String Bridge_length) {
        try {
            if (!(Bridge_length.equals(Retry_Enter) || Bridge_length.equals(Ending_Enter)))
                throw new IllegalArgumentException(BAGIC_ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return true;
        }
        return false;
    }
}
