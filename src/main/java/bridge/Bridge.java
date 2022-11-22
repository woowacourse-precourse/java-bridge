package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private boolean correct;
    private Player player;

    private enum lineFlag {
        FIRST, SECOND;
    }

    public Bridge(List<String> bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
    }

    public boolean getCorrect() {
        return this.correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean possibleMove(String moving) {
        return getAnswer(player.getLocation()).equals(moving);
    }

    private String getAnswer(int current) {
        return this.bridge.get(current);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int length = player.getLocation();
        if (!correct) {
            length++;
        }
        buildLine(sb, length, lineFlag.FIRST);
        buildLine(sb, length, lineFlag.SECOND);
        return sb.toString();
    }

    private void buildLine(StringBuilder sb, int length, lineFlag flag) {
        sb.append("[ ");
        for (int i = 0; i < length; i++) {
            appendCorrect(sb, i, flag);
            if (i < length - 1) {
                sb.append(" | ");
            }
        }
        sb.append(" ]\n");
    }

    private void appendCorrect(StringBuilder sb, int i, lineFlag flag) {
        if (i < player.getLocation() && flagCompare(flag, bridge.get(i))) {
            sb.append("O");
            return;
        }
        if (i == player.getLocation() && flagCompare(flag, player.getLastMoving())) {
            sb.append("X");
            return ;
        }
        sb.append(" ");
    }

    private boolean flagCompare(lineFlag flag, String str) {
        if (flag == lineFlag.FIRST)
            return str.equals("U");
        return str.equals("D");
    }

    public boolean getGameResult() {
        return player.getLocation() == bridge.size();
    }
    public String getGameResultString() {
        if (getGameResult())
            return "성공";
        return "실패";
    }
}
