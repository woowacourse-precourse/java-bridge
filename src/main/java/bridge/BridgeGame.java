package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    int stepNum = 0;
    int tryNum = 0;
    List<String> answer;
    List<String> playerMove;

    BridgeGame() {
        stepNum = 0;
        tryNum = 0;
        answer = null;
        playerMove = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String playerMoveInput) {
        setMoveValue(playerMoveInput);
        return checkSucces(playerMoveInput);
    }

    private boolean checkSucces(String playerMoveInput) {
        if (answer.get(stepNum - 1) == playerMoveInput)
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
        makeEmptySides(sides, 2);
        
        for (int playerfoot = 0; playerfoot < playerMove.size(); playerfoot++) {
            String currentMove = playerMove.get(playerfoot);
            putOOnSides(sides, playerfoot, currentMove);
        }
        
        putXOnSides(sides, stepNum, playerMove.get(stepNum));
        
        StringBuilder result = makeResultMap(sides, 2);

        return result.toString();
    }

    private StringBuilder makeResultMap(List<StringBuilder> sides, int size) {
        StringBuilder result = new StringBuilder();
        for(int index = 0; index < size -1 ;index++) {
            result.append(sides.get(index));
            result.append('\n');
        }
        result.append(sides.get(size-1));
        return result;
    }

    private void putOOnSides(List<StringBuilder> sides, int playerfoot, String currentMove) {
        if (currentMove == "U")
            putOXInSide(sides.get(0), playerfoot, 'O');
        if (currentMove == "D")
            putOXInSide(sides.get(1), playerfoot, 'O');
    }

    private void putXOnSides(List<StringBuilder> sides, int playerfoot, String currentMove) {
        if (!checkSucces(currentMove)) {
            if (currentMove == "U")
                putOXInSide(sides.get(0), playerfoot, 'X');
            if (currentMove == "D")
                putOXInSide(sides.get(1), playerfoot, 'X');
        }
    }

    private void makeEmptySides(List<StringBuilder> sides, int size) {
        StringBuilder emptySide = makeEmptyLine();
        for (int index = 0; index < size; index++) {
            sides.add(new StringBuilder(emptySide));
        }
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

}
