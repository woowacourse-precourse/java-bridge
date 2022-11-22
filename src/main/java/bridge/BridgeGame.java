package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static final String REPLAY_KEY = "R";
    public static final String UPPER_SELECT = "U";
    public static final String LOWER_SELECT = "D";

    private static final String THIRD_BLANK = "   ";
    private static final String POSSIBILITY = " O ";
    private static final String IMPOSSIBILITY = " X ";

    private int gameCount = 1;
    private boolean gameSuccess = true;


    private final List<String> bridgeRoad;
    private final List<String> upperMove = new ArrayList<>();
    private final List<String> lowerMove = new ArrayList<>();

    public BridgeGame(List<String> bridgeRoad) {
        this.bridgeRoad = bridgeRoad;
    }

    public boolean move(String move) {
        boolean isCheck = true;

        if (move.equals(UPPER_SELECT))
            isCheck = isCheckUpperMove();

        if (move.equals(LOWER_SELECT))
            isCheck = isCheckLowerMove();

        return isCheck;
    }

    public boolean isCheckUpperMove() {
        int size = upperMove.size();
        lowerMove.add(THIRD_BLANK);

        if (bridgeRoad.get(size).equals(UPPER_SELECT)) {
            upperMove.add(POSSIBILITY);
            return true;
        }
        upperMove.add(IMPOSSIBILITY);
        return false;
    }

    public boolean isCheckLowerMove() {
        int size = lowerMove.size();
        upperMove.add(THIRD_BLANK);

        if (bridgeRoad.get(size).equals(LOWER_SELECT)) {
            lowerMove.add(POSSIBILITY);
            return true;
        }
        lowerMove.add(IMPOSSIBILITY);
        return false;
    }

    public boolean retry(String progress) {
        if (progress.equals(REPLAY_KEY)) {
            gameCount++;
            upperMove.clear();
            lowerMove.clear();
            return true;
        }
        gameSuccess = false;
        return false;
    }

    public boolean isCheckGame() {
        return upperMove.size() == bridgeRoad.size();
    }

    public int getGameCount() {
        return gameCount;
    }

    public boolean isGameSuccess() {
        return gameSuccess;
    }

    public List<String> getUpperMove() {
        return upperMove;
    }

    public List<String> getLowerMove() {
        return lowerMove;
    }

    public List<String> getBridgeRoad() {
        return bridgeRoad;
    }

}
