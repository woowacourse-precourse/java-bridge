package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int stepNum;
    private int tryNum;
    private List<String> answer;
    private List<String> playerMove;
    private boolean currentState;

    BridgeGame() {
        stepNum = 0;
        tryNum = 1;
        answer = null;
        playerMove = new ArrayList<>();
        currentState = false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String playerMoveInput) {
        setMoveValue(playerMoveInput);
        this.currentState = checkSucces(playerMoveInput);
        return this.currentState;
    }

    private boolean checkSucces(String playerMoveInput) {
        if (answer.get(stepNum - 1).equals(playerMoveInput))
            return true;
        return false;
    }

    private void setMoveValue(String playerMoveInput) {
        stepNum++;
        playerMove.add(playerMoveInput);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        stepNum = 0;
        tryNum++;
        playerMove = null;
        playerMove = new ArrayList<>();
    }

    public void setBridge(List<String> bridge) {
        this.answer = bridge;
    }

    public String createResultMap() {
        List<StringBuilder> sides = new ArrayList<>();
        makeEmptyMap(sides, 2);

        drawOOnMap(sides);

        drawXOnLastStepIfFail(sides, stepNum - 1, playerMove.get(stepNum - 1));
        StringBuilder result = makeResultMap(sides, 2);
        return result.toString();
    }

    private void drawOOnMap(List<StringBuilder> sides) {
        for (int playerfoot = 0; playerfoot < playerMove.size(); playerfoot++) {
            String currentMove = playerMove.get(playerfoot);
            putOOnSides(sides, playerfoot, currentMove);
        }
    }

    private StringBuilder makeResultMap(List<StringBuilder> sides, int size) {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < size - 1; index++) {
            result.append(sides.get(index));
            result.append('\n');
        }
        result.append(sides.get(size - 1));
        return result;
    }

    private void putOOnSides(List<StringBuilder> sides, int playerfoot, String currentMove) {
        if (currentMove.equals("U"))
            putOXInSide(sides.get(0), playerfoot, 'O');
        if (currentMove.equals("D"))
            putOXInSide(sides.get(1), playerfoot, 'O');
    }

    private void drawXOnLastStepIfFail(List<StringBuilder> sides, int playerfoot, String currentMove) {
        if (!checkSucces(currentMove)) {
            if (currentMove.equals("U"))
                putOXInSide(sides.get(0), playerfoot, 'X');
            if (currentMove.equals("D"))
                putOXInSide(sides.get(1), playerfoot, 'X');
        }
    }

    private void makeEmptyMap(List<StringBuilder> sides, int size) {
        StringBuilder emptySide = makeEmptyLine();
        for (int index = 0; index < size; index++) {
            sides.add(new StringBuilder(emptySide));
        }
        emptySide = null;
    }

    private void putOXInSide(StringBuilder side, int index, char put) {
        side.setCharAt(2 + index * 4, put);
    }

    private StringBuilder makeEmptyLine() {
        StringBuilder tempBuilder = new StringBuilder();
        tempBuilder.append("[");
        for (int index = 0; index < playerMove.size(); index++) {
            tempBuilder.append("   ");
            if (index + 1 < playerMove.size())
                tempBuilder.append("|");
        }
        tempBuilder.append("]");
        return tempBuilder;
    }

    public boolean gameSucces() {
        if (this.answer.size() == stepNum && answer.get(stepNum - 1).equals(playerMove.get(stepNum - 1)))
            return true;
        return false;
    }

    public boolean getCurrentState() {
        return this.currentState;
    }

    public int getTryNum() {
        return this.tryNum;
    }

}
