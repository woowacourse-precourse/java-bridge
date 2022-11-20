package bridge;

import static message.PrintMessage.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */

// TODO BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.

public class BridgeGame {
    private final int BRIDGE_MIN = 3;
    private final int BRIDGE_MAX = 20;

    private String gameCommand;
    private String retryCommand;
    private int size;


    public BridgeGame(String gameCommand, String retryCommand) {
        this.gameCommand = gameCommand;
        this.retryCommand = retryCommand;
        move(gameCommand);
        retry(retryCommand);
    }


    public BridgeGame(int size) {
        this.size = size;
        checkBridgeSize(size);
    }


    public void move(String gameCommand) {
        if (!(gameCommand.equals(MOVE_U_COMMAND.getStatus()) || gameCommand.equals(MOVE_D_COMMAND.getStatus()))) {
            throw new IllegalArgumentException();
        }
    }


    public void retry(String retryCommand) {
        if (!(retryCommand.equals(RETRY_Q_COMMAND.getStatus()) || retryCommand.equals(RETRY_R_COMMAND.getStatus()))) {
            throw new IllegalArgumentException();
        }
    }


    public void checkBridgeSize(int size) {
        if (!(size >= BRIDGE_MIN && size <= BRIDGE_MAX)) throw new IllegalArgumentException();
    }


    public String getReadMoving() {
        return gameCommand;
    }


    public String getGameCommand() {
        return retryCommand;
    }


    public int getSize() {
        return size;
    }
}
