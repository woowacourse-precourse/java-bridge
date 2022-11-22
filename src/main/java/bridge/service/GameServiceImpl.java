package bridge.service;

import bridge.service.itf.CheckService;
import bridge.service.itf.GameService;
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
        if (checkIsGameFinished(bridgeInfo, BridgeGame.getUserDirection())) {
            return false;
        }
        if (!bridgeGame.move(bridgeInfo, inputView.readMoving())) {
            return askOption();
        }
        return true;
    }

    @Override
    public boolean askOption() {
        if (inputView.readGameCommand().equals( GameOptionType.QUIT )) {
            endType = ResultType.FAIL;
            return false;
        }
        return bridgeGame.retry();
    }

    @Override
    public boolean checkIsGameFinished(List<String> bridgeInfo, List<String> userDirection) {
        CheckService checkService = new CheckServiceImpl();
        if (checkService.isSucceed(bridgeInfo)) {
            endType = ResultType.SUCCESS;
            return true;
        }
        return false;
    }

    @Override
    public ResultType getEndType() {
        return endType;
    }
}
