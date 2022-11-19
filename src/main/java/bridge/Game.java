package bridge;


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

}
