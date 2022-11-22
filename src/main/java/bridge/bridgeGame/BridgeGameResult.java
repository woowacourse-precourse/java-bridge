package bridge.bridgeGame;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameResult {
    private final List<String> resultUp = new ArrayList<>();
    private final List<String> resultDown = new ArrayList<>();

    public List<String> getResultUp() {
        return resultUp;
    }

    public List<String> getResultDown() {
        return resultDown;
    }

    public void addResultUp(boolean move) {
        if (move) {
            resultUp.add("O");
            resultDown.add(" ");
        }

        if (!move) {
            resultUp.add("X");
            resultDown.add(" ");
        }
    }

    public void addResultDown(boolean move){
        if (move) {
            resultUp.add(" ");
            resultDown.add("O");
        }

        if (!move) {
            resultUp.add(" ");
            resultDown.add("X");
        }
    }

    public void retryResultUpDown(){
        resultUp.clear();
        resultDown.clear();
    }
}
