package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.InputValidator;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.GameMode;
import bridge.domain.generator.BridgeMaker;
import bridge.domain.generator.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import javax.xml.validation.Validator;
import java.util.List;

public class BridgeGameService {
    private BridgeMaker bridgeMaker;
    private InputView inputView;
    private InputValidator validator;
    private BridgeGame game;

    public BridgeGameService() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        inputView = new InputView();
        validator = new InputValidator();
    }

    public void run(){
        int size = validator.returnNum(inputView.readBridgeSize());
        List<String> answerBridge = bridgeMaker.makeBridge(size);
        game = new BridgeGame(answerBridge);
        while(game.getBridge().bridgeEnd()){
            game.move(inputView.readMoving());
        }

    }

    public void retry(){
        String gameMode = inputView.readGameCommand();
        validator.checkRetry(gameMode);
        if (gameMode.equals(GameMode.RETRY.getKey())){
            game.retry();
            run();
        }
    }
}
