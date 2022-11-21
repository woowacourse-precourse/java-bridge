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
        int size = readInteger();
        if(size >= 3 && size <= 20)
            return size;

        throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = readOneCharacter();
        if(moving.equals("U") || moving.equals("D"))
            return moving;

        throw new IllegalArgumentException("U 또는 D를 입력해야 합니다.");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String moving = readOneCharacter();
        if(moving.equals("R") || moving.equals("Q"))
            return moving;

        throw new IllegalArgumentException("R 또는 Q를 입력해야 합니다.");
    }

    private int readInteger() {
        try {
            int number = Integer.parseInt(Console.readLine());
            return number;
        } catch(Exception e) {
            throw new IllegalArgumentException("정수를 입력해야 합니다.");
        }
    }

    private String readOneCharacter() {
        String line;
        try {
            line = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("입력 과정에서 오류가 발생했습니다.");
        }
        if(line.length() != 0) {
            throw new IllegalArgumentException("알파벳 하나를 입력해야 합니다.");
        }
        return line;
    }
}
