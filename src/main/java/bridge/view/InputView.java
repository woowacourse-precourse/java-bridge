package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String readSize = Console.readLine();

        while (!validForSize(readSize)) {
            readSize = Console.readLine();
        }
        return Integer.parseInt(readSize);
    }

    private boolean validForSize(String readSize) {
        try {
            checkErrorInSize(readSize);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return false;
        }
    }

    private void checkErrorInSize(String readSize) {
        if (!Pattern.matches(Regex.RANGE.getPattern(), readSize)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Move readMoving() {
        String move = Console.readLine();

        while (!validForMove(move)) {
            move = Console.readLine();
        }
        return Move.valueOf(move);
    }

    private boolean validForMove(String move) {
        try {
            checkErrorInMove(move);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 이동 명령은 U 혹은 D 중 하나를 입력해야만 합니다.");
            return false;
        }
    }
    private void checkErrorInMove(String move) {
        if (!Pattern.matches(Regex.MOVE.getPattern(), move)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Continue readGameCommand() {
        String command = Console.readLine();

        while (!validForGameCommand(command)) {
            command = Console.readLine();
        }
        return Continue.getEnum(command);
    }

    private boolean validForGameCommand(String command) {
        try {
            checkErrorInCommand(command);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 게임 재시작/종료 명령은 R 혹은 Q중 하나를 입력해야만 합니다.");
            return false;
        }
    }

    private void checkErrorInCommand(String command) {
        if (!Pattern.matches(Regex.CONTINUE.getPattern(), command)) {
            throw new IllegalArgumentException();
        }
    }
}
