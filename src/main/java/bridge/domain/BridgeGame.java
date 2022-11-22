package bridge.domain;

import bridge.util.ReStartValidator;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final int START = 0;

    public static final String LEFT_WALL = "[ ";
    public static final String PARTITION = " | ";
    public static final String RIGHT_WALL = " ]";
    public static final String SUCCESS = "O";
    public static final String FAIL = "X";
    public static final String BLANK = " ";

    private final BridgeMaker bridgeMaker;
    private Bridge bridge;
    private Status status;

    public BridgeGame() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void init(int size) {
        this.bridge = new Bridge(bridgeMaker.makeBridge(size));
        this.status = new Status();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String command) {
        status.enterCommand(command);
        status.setSuccess(bridge.canCrossBridge(status.getCurrentPhase() - 1, command));
        return status.isSuccess();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if (command.equals(Character.toString(ReStartValidator.RESTART))) {
            status.increaseTryNumber();
            status.removeCommand();
            return true;
        }
        return false;
    }

    public boolean isEnd() {
        return status.isSuccess() && status.getCurrentPhase() == bridge.length();
    }

    public boolean getSuccess() {
        return status.isSuccess();
    }

    public int getTotalTryNumber() {
        return status.getTotalTryNumber();
    }

    public String convertBridge() {
        return convertStair(Command.UP) + "\n" + convertStair(Command.DOWN);
    }

    private String convertStair(Command command) {
        StringBuilder sb = new StringBuilder();
        for (int currentPhase = 0; currentPhase < status.getCurrentPhase(); currentPhase++) {
            if (currentPhase == START) {
                sb.append(LEFT_WALL);
            }
            sb.append(getSuccessOrFail(currentPhase, command));
            if(currentPhase == status.getCurrentPhase() - 1) {
                sb.append(RIGHT_WALL);
                continue;
            }
            sb.append(PARTITION);
        }
        return sb.toString();
    }

    private String getSuccessOrFail(int phase, Command command) {
        String bridgeCommand = bridge.getBridgePhase(phase);
        String currentCommand = status.getCurrentCommand(phase);
        if (bridgeCommand.equals(currentCommand) && bridgeCommand.equals(command.getStatusString())) {
            return SUCCESS;
        }
        if (!bridgeCommand.equals(currentCommand) && currentCommand.equals(command.getStatusString())) {
            return FAIL;
        }
        return BLANK;
    }
}
