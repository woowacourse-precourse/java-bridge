package bridge;

import camp.nextstep.edu.missionutils.Console;

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
        if(!isValidSize(size)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return size;
    }

    static int readNum() throws IllegalArgumentException {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 입력되어야 합니다.");
        }
    }

    static boolean isValidSize(int size) {
        return size >= Utils.MIN_SIZE && size <= Utils.MAX_SIZE;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String dir = Console.readLine();
        if(!isValidDirection(dir)) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D여야 합니다.");
        }
        return dir;
    }

    static boolean isValidDirection(String dir) {
        return dir.equals(Utils.UP_STRING) || dir.equals(Utils.DOWN_STRING);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
