package bridge.Domain;

import bridge.Enum.BridgeGameInfo;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private List<String> bridge;
    private List<Boolean> matchResult = new ArrayList<>();
    private int gameCount = 0;

    public boolean move(InputView inputView, OutputView outputView, int i) {
        String input = inputView.readMoving();
        boolean match = bridge.get(i).equals(input);
        matchResult.add(match);
        setMatchResult(matchResult);
        outputView.printMap(matchResult, bridge);
        return match;
    }

    public boolean retry(InputView inputView) {
        if (inputView.readGameCommand().equals(BridgeGameInfo.RESTART.getWord())) {
            setMatchResult(new ArrayList<>());
            return true;
        }
        return false;
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public List<String> getBridge() { return bridge; }
    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }
    public List<Boolean> getMatchResult() {
        return matchResult;
    }
    public void setMatchResult(List<Boolean> matchResult) {
        this.matchResult = matchResult;
    }
    public int getGameCount() {
        return gameCount;
    }
    public void increaseGameCount() {
        this.gameCount++;
    }
    public boolean isSuccecss() { return matchResult.get(matchResult.size()-1); }

}

