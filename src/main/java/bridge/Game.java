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

    public void start(){
        this.makeBridgeGame();
        this.play();
        this.printGameResult();
    }

    private void makeBridgeGame(){
        outputController.printComment(Comment.START_GAME);
        outputController.printComment(Comment.INPUT_SIZE_OF_BRIDGE);
        int size = inputController.readBridgeSize();
        List<String> bridge = this.bridgeMaker.makeBridge(size);
        this.bridgeGame = new BridgeGame(bridge);
    }

    private void play() {
        while(!this.bridgeGame.isEndOfBridge() && this.isPlaying){
            String playerMovement = movePlayer();
            boolean isPlayerSafe = this.bridgeGame.checkBridgeAndPlayer();
            updateAndPrintMap(playerMovement, isPlayerSafe);

            this.checkGameState(isPlayerSafe);
        }
    }

    public void printGameResult(){
        outputController.printResult(this.map, this.bridgeGame.isEndOfBridge(), this.bridgeGame.getTotalAttempts());
    }

    private String movePlayer() {
        outputController.printComment(Comment.INPUT_MOVEMENT);
        String playerMovement = inputController.readMoving();
        this.bridgeGame.move(playerMovement);
        return playerMovement;
    }

    private void updateAndPrintMap(String playerMovement, boolean isPlayerSafe) {
        this.map.update(playerMovement, isPlayerSafe);
        outputController.printMap(this.map);
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
        this.bridgeGame.clearPlayerCurrentStep();
    }


    private boolean isPlayerRetrying(){
        outputController.printComment(Comment.INPUT_GAME_COMMEND);
        String retryInput = inputController.readGameCommand();
        return retryInput.equals("R");
    }
}
