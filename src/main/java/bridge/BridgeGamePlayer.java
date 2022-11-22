package bridge;

import static bridge.util.message.GameMessage.*;

import bridge.domain.BridgeBoard;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;


import javax.naming.ldap.StartTlsRequest;
import java.util.ArrayList;
import java.util.List;

public class BridgeGamePlayer {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void run(){
        outputView.showMessage(START_MESSAGE.getMessage());
        setting();
    }

    private void setting(){
        List<String> bridge = new ArrayList<>();
        bridge = getBridge();
        gameStart(bridge);
    }


    private static List<String> getBridge(){

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(getBridgeSize());
    }

    private static int getBridgeSize(){
        outputView.showMessage(INPUT_BRIDGE_LENGTH.getMessage());
        return inputView.readBridgeSize();
    }


    private static void gameStart(List<String> bridge){

        BridgeGame game = new BridgeGame();

        while(!game.gameFinish(bridge)){
            if(game.compare(bridge,getChoiceMove())){
                outputView.printMap(game.showCurrentBoard());
                continue;
            }
            outputView.showMessage(RETRY_OR_QUIT.getMessage());
            game.retry(bridge,inputView.readGameCommand());
        }
    }

    private void gameResult(){

    }



    private static String getChoiceMove(){
        outputView.showMessage(CHOICE_MOVE.getMessage());
        return inputView.readMoving();
    }

}
