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


    private boolean isPlayerRetrying(){
        outputController.printComment(Comment.INPUT_GAME_COMMEND);
        String retryInput = inputController.readGameCommand();
        return retryInput.equals("R");
    }
}
