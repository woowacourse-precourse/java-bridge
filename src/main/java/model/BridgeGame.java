package model;

import static bridge.enums.BridgeElement.BRIDGE_EMPTY_ELEMENT;
import static bridge.enums.BridgeElement.BRIDGE_PASSABLE_ELEMENT;
import static bridge.enums.BridgeElement.BRIDGE_IMPASSABLE_ELEMENT;
import static bridge.enums.Command.RESTART_COMMAND;
import static bridge.enums.Direction.UPWARD_DIRECTION;
import static bridge.enums.Direction.DOWNWARD_DIRECTION;
import static bridge.enums.GameResult.SUCCESS;
import static bridge.enums.GameResult.FAIL;

import bridge.enums.Direction;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge answerBridge;
    private final List<Bridge> outputBridge;
    private int tryCount;

    public BridgeGame(Bridge answerBridge) {
        this.answerBridge = answerBridge;
        outputBridge = new ArrayList<>();
        outputBridge.add(new Bridge(new ArrayList<>()));
        outputBridge.add(new Bridge(new ArrayList<>()));
        tryCount = 1;
    }

    public List<Bridge> getOutputBridge() {
        return outputBridge;
    }

    public Bridge getUpperBridge() {
        return outputBridge.get(UPWARD_DIRECTION.getValue());
    }

    public Bridge getLowerBridge() {
        return outputBridge.get(DOWNWARD_DIRECTION.getValue());
    }

    public int getTryCount() {
        return tryCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     * @param direction 이동 방향
     * @return 이동 결과. 이동 결과가 "O"이면 true, "X"이면 false 이다.
     */
    public boolean move(String direction) {
        int index = getUpperBridge().size();
        String answerDirection = answerBridge.get(index);
        boolean correct = answerDirection.equals(direction);
        Direction consistentEnum = Objects.requireNonNull(Direction.getEnum(direction));

        setUpperBridge(correct, consistentEnum);
        setLowerBridge(correct, consistentEnum);
        return correct;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     * @param command 사용자 커맨드 입력
     * @return retry 여부. 재시작일 경우 true, 종료일 경우 false 이다.
     */
    public boolean retry(String command) {
        String restartCommand = RESTART_COMMAND.toString();
        if (restartCommand.equals(command)) {
            clearOutputBridge();
            tryCount++;
            return true;
        }
        return false;
    }

    /**
     * 게임 결과를 판단할 때 사용하는 메서드
     *
     * @return 성공 여부. 게임이 성공이면 true, 실패면 false 이다.
     */
    public boolean gameWin() {
        final Bridge lowerBridge = getLowerBridge();
        final Bridge upperBridge = getUpperBridge();
        return (upperBridge.size() == answerBridge.size() &&
                upperBridge.notContains(BRIDGE_IMPASSABLE_ELEMENT.toString()) &&
                lowerBridge.notContains(BRIDGE_IMPASSABLE_ELEMENT.toString()));
    }

    /**
     * 판단이 끝난 게임 결과를 얻을 때 사용하는 메서드
     *
     * @return 성공 또는 실패.
     */
    public String getGameResult() {
        if (gameWin()) {
            return SUCCESS.toString();
        }
        return FAIL.toString();
    }

    private void setUpperBridge(boolean correct, Direction direction) {
        final Bridge upperBridge = getUpperBridge();
        if (direction.equals(DOWNWARD_DIRECTION)) {
            upperBridge.add(BRIDGE_EMPTY_ELEMENT);
        }
        if (direction.equals(UPWARD_DIRECTION) && correct) {
            upperBridge.add(BRIDGE_PASSABLE_ELEMENT);
        }
        if (direction.equals(UPWARD_DIRECTION) && !correct) {
            upperBridge.add(BRIDGE_IMPASSABLE_ELEMENT);
        }
    }

    private void setLowerBridge(boolean correct, Direction direction) {
        final Bridge lowerBridge = getLowerBridge();
        if (direction.equals(UPWARD_DIRECTION)) {
            lowerBridge.add(BRIDGE_EMPTY_ELEMENT);
        }
        if (direction.equals(DOWNWARD_DIRECTION) && correct) {
            lowerBridge.add(BRIDGE_PASSABLE_ELEMENT);
        }
        if (direction.equals(DOWNWARD_DIRECTION) && !correct) {
            lowerBridge.add(BRIDGE_IMPASSABLE_ELEMENT);
        }
    }

    private void clearOutputBridge() {
        getUpperBridge().clear();
        getLowerBridge().clear();
    }
}
