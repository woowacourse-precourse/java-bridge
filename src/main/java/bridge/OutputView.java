package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private String mapTop = "";
    private String mapBelow = "";
    private String result ="";

    private static final int INITIAL_INDEX = 0;

    private enum Map {
        BOARD("[ %s ]%n[ %s ]"),
        STEADY("O"),
        BROKEN("X"),
        SEPARATOR(" | "),
        BLANK(" "),
        BOARD_ONE("[ "),
        BOARD_TWO(" ]%n[ "),
        BOARD_THREE(" ]");

        private String piece;

        Map(String piece) {
            this.piece = piece;
        }

        public String getPiece() {
            return piece;
        }
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        this.result = Map.BOARD_ONE.getPiece() +
                mapTop +
                Map.BOARD_TWO.getPiece() +
                mapBelow +
                Map.BOARD_THREE.getPiece();

        System.out.printf(Map.BOARD.getPiece(), mapTop, mapBelow);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.printf(this.result);
    }

    public String getResult() {
        return this.result;
    }

    public void mapBuilder(boolean move, int index, List<String> bridge) {
        firstCorrect(move, index, bridge);
        firstWrong(move, index, bridge);
        latterCorrect(move, index, bridge);
        latterWrong(move, index, bridge);
    }

    private void firstCorrect(boolean goodMove, int index, List<String> bridge) {
        if (goodMove && index==INITIAL_INDEX) {
            if (bridge.get(index).equals(Constants.BridgeStatus.UPPER.getPos())) {
                firstCorrectUpper();
            }

            if (bridge.get(index).equals(Constants.BridgeStatus.DOWN.getPos())) {
                firstCorrectDown();
            }
        }
    }

    private void firstWrong(boolean goodMove, int index, List<String> bridge) {
        if (!goodMove && index==INITIAL_INDEX) {
            if (bridge.get(index).equals(Constants.BridgeStatus.UPPER.getPos())) {
                firstWrongUpper();
            }

            if (bridge.get(index).equals(Constants.BridgeStatus.DOWN.getPos())) {
                firstWrongDown();
            }
        }
    }

    private void latterCorrect(boolean goodMove, int index, List<String> bridge) {
        if (goodMove && index!=INITIAL_INDEX) {
            if (bridge.get(index).equals(Constants.BridgeStatus.UPPER.getPos())) {
                latterCorrectUpper();
            }

            if (bridge.get(index).equals(Constants.BridgeStatus.DOWN.getPos())) {
                latterCorrectDown();
            }
        }
    }

    private void latterWrong(boolean goodMove, int index, List<String> bridge) {
        if (!goodMove && index!=INITIAL_INDEX) {
            if (bridge.get(index).equals(Constants.BridgeStatus.UPPER.getPos())) {
                latterWrongUpper();
            }

            if (bridge.get(index).equals(Constants.BridgeStatus.DOWN.getPos())) {
                latterWrongDown();
            }
        }
    }

    private void firstCorrectUpper() {
        mapTop = mapTop + Map.STEADY.getPiece();
        mapBelow = mapBelow + Map.BLANK.getPiece();
    }

    private void firstCorrectDown() {
        mapTop = mapTop + Map.BLANK.getPiece();
        mapBelow = mapBelow + Map.STEADY.getPiece();
    }

    private void latterCorrectUpper() {
        mapTop = mapTop + Map.SEPARATOR.getPiece() + Map.STEADY.getPiece();
        mapBelow = mapBelow + Map.SEPARATOR.getPiece() + Map.BLANK.getPiece();
    }

    private void latterCorrectDown() {
        mapTop = mapTop + Map.SEPARATOR.getPiece() + Map.BLANK.getPiece();
        mapBelow = mapBelow + Map.SEPARATOR.getPiece() + Map.STEADY.getPiece();
    }

    private void firstWrongUpper() {
        mapTop = mapTop + Map.BLANK.getPiece();
        mapBelow = mapBelow + Map.BROKEN.getPiece();
    }

    private void firstWrongDown() {
        mapTop = mapTop + Map.BROKEN.getPiece();
        mapBelow = mapBelow + Map.BLANK.getPiece();
    }

    private void latterWrongUpper() {
        mapTop = mapTop + Map.SEPARATOR.getPiece() + Map.BLANK.getPiece();
        mapBelow = mapBelow + Map.SEPARATOR.getPiece() + Map.BROKEN.getPiece();
    }

    private void latterWrongDown() {
        mapTop = mapTop + Map.SEPARATOR.getPiece() + Map.BROKEN.getPiece();
        mapBelow = mapBelow + Map.SEPARATOR.getPiece() + Map.BLANK.getPiece();
    }
}
