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
        int size = Integer.parseInt(Console.readLine());

        if(!(3 <= size && size <= 20)) {
            throw new IllegalArgumentException("[Error] 3 부터 20 사이의 수를 입력하세요");
        }

        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moveData = Console.readLine();

        if(!moveData.equals("U") && !moveData.equals("D")) {
            throw new IllegalArgumentException("[Error] D 또는 R을 눌러주세요");
        }

        return moveData;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();

        if(!gameCommand.equals("R") && !gameCommand.equals("Q")) {
            throw new IllegalArgumentException("[Error] R 또는 Q를 눌러주세요");
        }

        return gameCommand;
    }
}
