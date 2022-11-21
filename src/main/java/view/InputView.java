package view;

import camp.nextstep.edu.missionutils.Console;
import model.BridgeSizeValidator;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String bridgeSize = Console.readLine();
            BridgeSizeValidator bridgeSizeValidator = new BridgeSizeValidator(bridgeSize);
            return bridgeSizeValidator.bridgeSize;
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while(true) {
            try {
                String move = Console.readLine();
                checkReadMoving(move);
                return move;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return readMoving();
            }
        }
    }

    public void checkReadMoving(String move) {
        if( !(move.equals("U") || move.equals("D")) ) {
            throw new IllegalArgumentException("[ERROR] 잘못된 움직임 입력입니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while(true) {
            try {
                String command = Console.readLine();
                checkReadCommand(command);
                return command;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return readGameCommand();
            }
        }
    }

    public void checkReadCommand(String command) {
        if( !(command.equals("R") || command.equals("Q")) ) {
            throw new IllegalArgumentException("[ERROR] 잘못된 커맨드 입력입니다.");
        }
    }
}
