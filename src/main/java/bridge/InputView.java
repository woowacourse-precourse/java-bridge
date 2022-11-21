package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static int bridge_size;
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
        try {
            bridge_size = Integer.parseInt(Console.readLine());
            checkBridgeSizeException(bridge_size);
        } catch(NumberFormatException e) {
            changeExceptionType();
        }
        return bridge_size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = Console.readLine();
        checkMovingException(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String game_command = Console.readLine();
        if (!(game_command.equals("R")) && !(game_command.equals("Q"))){
            System.out.println("[ERROR] 재시작 여부는 R/Q 중 하나를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        return game_command;
    }

    private void checkBridgeSizeException(int bridge_size) {
        if (bridge_size < 3 || bridge_size > 20){
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void changeExceptionType() {
        System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        throw new IllegalArgumentException();
    }

    private void checkMovingException(String moving) {
        if (!(moving.equals("U")) && !(moving.equals("D"))){
            System.out.println("[ERROR] 이동할 칸은 U/D 중 하나를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
