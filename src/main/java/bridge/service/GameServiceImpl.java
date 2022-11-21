package bridge.service;

import bridge.service.impl.CheckService;
import bridge.service.impl.GameService;
import bridge.type.GameOptionType;
import bridge.type.ResultType;
import bridge.view.InputView;

import java.util.List;


public class GameServiceImpl implements GameService {
    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();
    ResultType endType;

    @Override
    public boolean passThisRound(List<String> bridgeInfo) {
        if (!bridgeGame.move(bridgeInfo, inputView.readMoving())) {
            return askOption();
        }
        if (checkIsGameFinished(bridgeInfo, bridgeGame.getUserDirection())) {
            endType = ResultType.SUCCESS;
            return false;
        }
        return true;
    }

    @Override
    public boolean askOption() {
        if (inputView.readGameCommand().equals(GameOptionType.QUIT)) {
            endType = ResultType.FAIL;
            return false;
        }
        return bridgeGame.retry();
    }

    @Override
    public boolean checkIsGameFinished(List<String> bridgeInfo, List<String> userDirection) {
        CheckService checkService = new CheckServiceImpl();
        if (checkService.isSucceed(bridgeInfo)) {
            return true;
        }
        return false;
    }

    @Override
    public ResultType getEndType() {
        return endType;
    }
}
