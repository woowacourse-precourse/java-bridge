package bridge;

import bridge.valid.ValidateBridgeSize;
import bridge.valid.ValidateGameCommand;
import bridge.valid.ValidateMove;
import camp.nextstep.edu.missionutils.Console;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        int size;
        try {
            String inputSize = Console.readLine();
            size = new ValidateBridgeSize().validateBridgeSize(inputSize);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String move;
        try {
            String inputMove=Console.readLine();
            move = new ValidateMove().validateMove(inputMove);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readMoving();
        }
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command;
        try {
            String inputCommand = Console.readLine();
            command = new ValidateGameCommand().validateGameCommand(inputCommand);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return command;
    }
}
