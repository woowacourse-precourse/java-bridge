package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<String> up;
    private List<String> down;
    private int attempts;

    public GameResult() {
        this.attempts = 1;
        this.up=new ArrayList<>();
        this.down=new ArrayList<>();
    }



    public int updateResultMap(String input, String result) {
        if(input.equals("U")){
            up.add(result);
            down.add(" ");
            return 0;
        }
        down.add(result);
        up.add(" ");
        return 0;
    }

    public void resetGameResult() {
        this.up=new ArrayList<>();
        this.down=new ArrayList<>();
    }

    public int updateGameResult() {
        resetGameResult();
        return ++this.attempts;
    }

    public int getAttempts() {
        return attempts;
    }

    public String upBridgeToString() {
        return "[ " + String.join(" | ", up + " ]");
    }

    public String downBridgeToString() {
        return "[ " + String.join(" | ",down + " ]");
    }

}
