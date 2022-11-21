package bridge;

import camp.nextstep.edu.missionutils.Console;
import jdk.jshell.execution.Util;

// 예외 체크 코드 ExceptionHandler로 이동할지 생각

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        System.out.println("다리의 길이를 입력해주세요.");
        int size = readNum();
        ExceptionHandler.handleSizeException(size);
        return size;
    }

    static int readNum() throws IllegalArgumentException {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 입력되어야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String dir = Console.readLine();
        ExceptionHandler.handleMovingException(dir);
        return dir;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = Console.readLine();
        ExceptionHandler.handleCommandException(command);
        return command;
    }
}
