package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String line;
        int size;

        try {
            line = Console.readLine();
            size = Integer.parseInt(line);
        } catch(Exception e) {
            throw new IllegalArgumentException("정수를 입력해야 합니다.");
        }

        if(size < 3 || size > 20) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String line = "";

        try {
            line = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("입력 과정에서 오류가 발생했습니다.");
        }

        if(line.length() != 1) {
            throw new IllegalArgumentException("한 글자만 입력해야 합니다.");
        }

        if(line.equals("U") || line.equals("D")) {
            return line;
        }

        throw new IllegalArgumentException("U나 D를 입력해야 합니다.");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String line;

        try {
            line = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("입력 과정에서 오류가 발생했습니다.");
        }

        if(line.length() != 1) {
            throw new IllegalArgumentException("한 글자만 입력해야 합니다.");
        }

        if(line.equals("Q") || line.equals("R")) {
            return line;
        }

        throw new IllegalArgumentException("Q나 R을 입력해야 합니다.");
    }
}
