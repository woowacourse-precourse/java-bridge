package bridge.service;

import bridge.domain.InputValidator;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.GameMode;
import bridge.domain.generator.BridgeMaker;
import bridge.domain.generator.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameService {
    private BridgeMaker bridgeMaker;
    private InputView inputView;
    private OutputView outputView;
    private InputValidator validator;
    private BridgeGame game;

    public BridgeGameService() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        inputView = new InputView();
        validator = new InputValidator();
        outputView = new OutputView();
    }

    public void start(){
        int size = validator.returnNum(inputView.readBridgeSize());
        List<String> answerBridge = bridgeMaker.makeBridge(size);
        game = new BridgeGame(answerBridge);
        run();
    }

    public void run(){
        String map = "";
        while(game.getBridge().bridgeEnd()){
            map = game.move(inputView.readMoving());
            outputView.printMap(map);
            if (!game.isSuccess()){
                retry();
                break;
            }
        }
        outputView.printResult(map, game.isSuccess(), game.getTotalTrial());
    }

    public void retry(){
        String gameMode = inputView.readGameCommand();
        validator.checkRetry(gameMode);
        if (gameMode.equals(GameMode.RETRY.getKey())){
            game.retry();
            run();
        }
        if (gameMode.equals(GameMode.QUIT.getKey())){
            game.setSuccess(false);
        }
    }
}
