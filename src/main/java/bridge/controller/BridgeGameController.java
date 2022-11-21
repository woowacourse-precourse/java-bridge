package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.MoveResult;
import bridge.validator.BridgeSizeValidator;
import bridge.validator.MoveCommandValidator;
import bridge.view.InputView;

import java.util.List;

public class BridgeGameController {
    InputView inputView = new InputView();
    BridgeGame bridgeGame;

    public void runGame() {
        bridgeGame = new BridgeGame(createBridgeByUserInputSize());
        boolean playing = true;
        do{
            MoveResult moveResult = getMoveResultFromUserMoveCommand();
            if(moveResult.equals(MoveResult.FAIL)){
                //bridgeGame.retry();
            }
            if(bridgeGame.isClear(moveResult)){
                playing = false;
            }
        }while(playing);
    }

    public Bridge createBridgeByUserInputSize() {
        BridgeSizeValidator bridgeSizeValidator = new BridgeSizeValidator();
        int bridgeSize = bridgeSizeValidator.getValidBridgeSize(inputView.readBridgeSize());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public MoveResult getMoveResultFromUserMoveCommand(){
        MoveCommandValidator moveCommandValidator = new MoveCommandValidator();
        String userMove = moveCommandValidator.getValidCommand(inputView.readMoving());
        return bridgeGame.move(userMove);
    }


}
