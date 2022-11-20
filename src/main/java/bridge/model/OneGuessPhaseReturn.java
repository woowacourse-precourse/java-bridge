package bridge.model;

import java.util.ArrayList;
import java.util.List;

import static bridge.view.OutputView.failMessage;

public class OneGuessPhaseReturn {

    private String gameResult;
    private List <String> totalMove;

    public OneGuessPhaseReturn(){
        this.gameResult = failMessage;
        this.totalMove = new ArrayList<>();
    }
    public String getGameResult() {
        return gameResult;
    }

    public List<String> getTotalMove(){
        return totalMove;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

}
