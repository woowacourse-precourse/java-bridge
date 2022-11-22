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
        String size_input = Console.readLine();
        int size =Integer.MAX_VALUE;
        size = Integer.parseInt(size_input);


        if(size < 3 || size > 20) {
            System.out.println("[ERROR]다리 길이는 3부터 20사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();
        if(!moving.equals("U") && !moving.equals("D")) {
            System.out.println("[ERROR]U 또는 D를 입력하세요.");
            throw new IllegalArgumentException();
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();
        if (!command.equals("R") && !command.equals("Q")) {
            System.out.println("[ERROR]R 또는 Q를 입력하세요.");
            throw new IllegalArgumentException();
        }
        return command;
    }
}
