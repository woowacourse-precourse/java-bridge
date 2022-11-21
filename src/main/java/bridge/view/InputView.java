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
                return getMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Moving getMoving() {
        System.out.println(Message.MOVE_INPUT);
        String inputMoving = Console.readLine();
        if (Moving.UP.getValue().equals(inputMoving)) return Moving.UP;
        if (Moving.DOWN.getValue().equals(inputMoving)) return Moving.DOWN;
        throw new IllegalArgumentException(Message.ERROR + Message.MOVE_ERROR);
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        while (true) {
            try {
                return getGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private GameCommand getGameCommand() {
        System.out.println(Message.GAME_COMMAND_INPUT);
        String inputMoving = Console.readLine();
        if (GameCommand.RE_GAME.getValue().equals(inputMoving)) return GameCommand.RE_GAME;
        if (GameCommand.QUIT.getValue().equals(inputMoving)) return GameCommand.QUIT;
        throw new IllegalArgumentException(Message.ERROR + Message.GAME_COMMAND_ERROR);
    }
}
