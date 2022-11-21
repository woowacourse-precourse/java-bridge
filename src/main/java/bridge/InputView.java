package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        try {
            int bridgeSize = Integer.parseInt(Console.readLine());
            if (bridgeSize < 3 || bridgeSize > 20) throw new IllegalArgumentException();
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + "다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        try {
            String moving = Console.readLine();
            if (!moving.equals("U") && !moving.equals("D")) throw new IllegalArgumentException();
            return moving;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + "이동할 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자여야 합니다.");
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        try {
            String command = Console.readLine();
            if (!command.equals("R") && !command.equals("Q")) throw new IllegalArgumentException();
            return command;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + " R(재시작)과 Q(종료) 중 하나의 문자를 입력해야 합니다.");
            return readGameCommand();
        }
    }
}
