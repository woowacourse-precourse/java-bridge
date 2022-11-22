package bridge.view;

import bridge.model.GameResult;
import bridge.model.Judge;

public interface Output {
    void printMap(Judge judge);

    void printResult(Judge judge, GameResult gameResult, int gameCount);
}
