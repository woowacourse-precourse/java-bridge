package bridge.view;

import bridge.model.BridgeSize;
import bridge.model.GameCommand;
import bridge.model.Moving;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView implements Input {

    /**
     * 다리의 길이를 입력받는다.
     */
    @Override
    public BridgeSize readBridgeSize() {
        while (true){
            try {
                System.out.println(Message.BRIDGE_SIZE_INPUT);
                return new BridgeSize(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    @Override
    public Moving readMoving() {
        while (true) {
            try {
                System.out.println(Message.MOVE_INPUT);
                String inputMoving = Console.readLine();
                return Moving.getMoving(inputMoving);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        while (true) {
            try {
                System.out.println(Message.GAME_COMMAND_INPUT);
                String inputGameCommand = Console.readLine();
                return GameCommand.getGameCommand(inputGameCommand);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
