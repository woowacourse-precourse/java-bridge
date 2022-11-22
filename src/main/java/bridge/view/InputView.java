package bridge.view;


import bridge.message.ErrorMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    /**
     * 사용자로부터 입력을 받는 역할을 한다.
     */
    public static int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");

        int input = Integer.valueOf(readLine());
        if (!(3 <= input && input <= 20)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_NOT_IN_RANGE.getMessage());
        }
        return input;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = readLine();
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(ErrorMessage.DIRECTION_NOT_U_D.getMessage());
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = readLine();
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(ErrorMessage.RETRY_NOT_U_D.getMessage());
        }
        return input;
    }
}