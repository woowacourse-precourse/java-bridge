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
        int size= 0;
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            size = Integer.parseInt(Console.readLine());
            BridgeException(size);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력하세요.");
            readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 범위입니다.");
            readBridgeSize();
        }
        return size;
    }
    void BridgeException(int size) {
        if(size<3||20<size) {
            throw new IllegalArgumentException();
        }
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = "";
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            move = Console.readLine();
            MovingException(move);
        }
        catch (IllegalArgumentException m) {
            System.out.println("[ERROR] U/D 중 하나를 입력해주세요.");
            readMoving();
        }
        return move;
    }
    void MovingException(String move) {
        if (!move.equals("U") && !move.equals("D")) {
            throw new IllegalArgumentException();
        }
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = "";
        try {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            command = Console.readLine();
            CommandExcption(command);
        }
        catch (IllegalArgumentException c) {
            System.out.println("[ERROR] R/Q 중 하나를 입력해주세요.");
            readGameCommand();
        }
        return command;
    }
    void CommandExcption(String command) {
        if (!command.equals("R") && !command.equals("Q")) {
            throw new IllegalArgumentException();
        }
    }
}
