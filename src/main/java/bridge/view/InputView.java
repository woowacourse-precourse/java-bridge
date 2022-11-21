package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        printGameStartMessage();
        printReadBridgeSizeMessage();
        try {
            int bridgeSize = Integer.parseInt(Console.readLine());
            if(bridgeSize < 3 || bridgeSize > 20)
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return bridgeSize;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다.");
        }
    }

    private static void printGameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    private static void printReadBridgeSizeMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        printReadMovingMessage();
        String input = Console.readLine();
        if(input.equals("U") || input.equals("D"))
            return input;
        throw new IllegalArgumentException("[ERROR] 위 칸(U) 또는 아래 칸(D)으로만 이동 가능합니다.");
    }

    private static void printReadMovingMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        printGameCommandMessage();
        String input = Console.readLine();
        if(input.equals("R") || input.equals("Q"))
            return input;
        throw new IllegalArgumentException("[ERROR] 재시도(R) 또는 종료(Q)만 입력 선택 가능합니다.");
    }

    private static void printGameCommandMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
