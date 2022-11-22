package bridge;

import bridge.Util.COMMAND_CONSTANTS;
import bridge.Util.GAME_STATE;

import java.util.List;
import java.util.Objects;

public class GameRunner {
    private List<String> bridge;
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public GameRunner() {
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        initializeBridge();
    }

    private void initializeBridge(){
        this.bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
    }

    public void run(){

    }

    private GAME_STATE inGame(){
        GAME_STATE state = GAME_STATE.IN_GAME;
        while(state == GAME_STATE.IN_GAME){
            state = bridgeGame.move(InputView.readMoving(), this.bridge);
        }
        return retry();
    }

    private GAME_STATE retry(){
        String stateCommand = InputView.readGameCommand();
        if(Objects.equals(stateCommand, GAME_STATE.RETRY.getState())){
            bridgeGame.retry();
            return GAME_STATE.RETRY;
        }
        return GAME_STATE.END;
    }
}
