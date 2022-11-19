package bridge;


import java.util.List;

public class Game {
    private BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;
    private static final InputView inputController = new InputView();
    private static final OutputView outputController = new OutputView();
    private final Map map;
    private boolean isPlaying;

    Game(){
        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(numberGenerator);
        this.map = new Map();
        this.isPlaying = true;
    }

    public void makeBridgeGame(){
        outputController.printComment(Comment.START_GAME);
        outputController.printComment(Comment.INPUT_SIZE_OF_BRIDGE);
        int size = inputController.readBridgeSize();
        List<String> bridge = this.bridgeMaker.makeBridge(size);
        this.bridgeGame = new BridgeGame(bridge);
    }

    public void play(){
        while(!this.bridgeGame.isEndOfBridge() && this.isPlaying){
            outputController.printComment(Comment.INPUT_MOVEMENT);
            String playerMovement = inputController.readMoving();
            this.bridgeGame.move(playerMovement);
            boolean isPlayerSafe = this.bridgeGame.checkBridgeAndPlayer();
            this.map.update(playerMovement, isPlayerSafe);
            outputController.printMap(this.map);

            this.checkGameState(isPlayerSafe);
        }
    }

    public void checkGameState(boolean isPlayerSafe) { // 플레이어가 죽었는지 확인
        if (!isPlayerSafe){
            resetOrQuitGame();
        }
    }

    private void resetOrQuitGame() {
        if (this.isPlayerRetrying()){
            this.bridgeGame.retry();
            this.map.clear();
            return;
        }
        this.isPlaying = false;
    }


    private boolean isPlayerRetrying(){
        outputController.printComment(Comment.INPUT_GAME_COMMEND);
        String retryInput = inputController.readGameCommand();
        return retryInput.equals("R");
    }
}
