package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer round = 0;

    //테이블 생성
    private List<List<StringBuilder>> moveTable = new ArrayList<>();

    {
        moveTable.add(new ArrayList<>());
        moveTable.add(new ArrayList<>());
    }

    private Boolean gameCleared = false;

    public Integer getRound() {
        return round;
    }

    public void startRound() {
        moveTable.get(0).clear();
        moveTable.get(1).clear();
        round++;
    }

    public Boolean getGameCleared() {
        return gameCleared;
    }

    public void setGameCleared(Boolean gameCleared) {
        this.gameCleared = gameCleared;
    }

    public String clear() {
        if (gameCleared) {
            return "성공";
        }
        return "실패";
    }

    public String move(List<String> bridge, Integer index, String way) {
        append(bridge.get(index).equals(way), way);
        return footPrints();
    }

    public String footPrints() {
        String upLine = "[" + String.join("|", moveTable.get(1)) + "]\n";
        String downLine = "[" + String.join("|", moveTable.get(0)) + "]";

        return upLine + downLine;
    }

    private void append(boolean canGo, String way) {
        if (canGo) {
            updateTable(way, " O ");
            return;
        }
        updateTable(way, " X ");
    }

    private void updateTable(String way, String correctness) {
        if (way.equals("U")) {
            goUp(new StringBuilder(correctness));
            return;
        }
        goDown(new StringBuilder(correctness));
    }

    private void goUp(StringBuilder canGo) {
        moveTable.get(1).add(canGo);
        moveTable.get(0).add(new StringBuilder("   "));
    }

    private void goDown(StringBuilder canGo) {
        moveTable.get(0).add(canGo);
        moveTable.get(1).add(new StringBuilder("   "));
    }

    public boolean canGoAllBridges() {
        return !moveTable.get(0).contains(" X ") && !moveTable.get(1).contains(" X ");
    }
}
