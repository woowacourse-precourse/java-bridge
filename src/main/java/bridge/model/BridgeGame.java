package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int gameCnt = 1;
    private boolean gameSuccess = true;

    public List<String> getBridgeRoad() {
        return bridgeRoad;
    }

    private final List<String> bridgeRoad;
    private final List<String> upMove = new ArrayList<>();
    private final List<String> downMove = new ArrayList<>();

    public List<String> getUpMove() {
        return upMove;
    }

    public List<String> getDownMove() {
        return downMove;
    }

    public BridgeGame(List<String> bridgeRoad) {
        this.bridgeRoad = bridgeRoad;
    }

    public boolean move(String move) {
        boolean chk = true;

        if (move.equals("U"))
            chk = confirmUpMove();

        if (move.equals("D"))
            chk = confirmDownMove();

        return chk;
    }

    public boolean confirmUpMove() {
        int size = upMove.size();
        downMove.add("   ");

        if (bridgeRoad.get(size).equals("U")) {
            upMove.add(" O ");
            return true;
        }
        upMove.add(" X ");
        return false;
    }

    public boolean confirmDownMove() {
        int size = downMove.size();
        upMove.add("   ");

        if (bridgeRoad.get(size).equals("D")) {
            downMove.add(" O ");
            return true;
        }
        downMove.add(" X ");
        return false;
    }


    public boolean retry(String progress) {
        if (progress.equals("R")) {
            gameCnt++;
            upMove.clear();
            downMove.clear();
            return true;
        }
        gameSuccess = false;
        return false;
    }

    public boolean checkGameIsDone() {
        return upMove.size() == bridgeRoad.size();
    }

    public int getGameCnt() {
        return gameCnt;
    }

    public boolean isGameSuccess() {
        return gameSuccess;
    }

}
