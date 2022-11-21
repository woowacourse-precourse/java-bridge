package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Controller controller;
    private int bridgeLength = 1;
    private int gameCount = 1;
    private final List<String> bridge;
    private int [] upCase;
    private int [] downCase;
    public BridgeGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        controller = new Controller();
        controller.startMessage().bridgeSizeMessage();
        bridge = bridgeMaker.makeBridge(controller.inputBridgeSize());
    }
    public void play() {
        System.out.println(bridge);
        while(true) {
            initBridge();
            compareMoveAndBridge();
            if(!retry()){
                break;
            }
        }
        controller.gameSuccessMessage(upCase, downCase, gameCount);
    }
    public void move(int i) {
            if("U".equals(bridge.get(i))) {
                upCase[i] += 1;
            }
            if("D".equals(bridge.get(i))) {
                downCase[i] += 1;
            }
    }
    public void doNotMove(String moveCommand, int i) {
        if(moveCommand.equals("U")) {
            upCase[i] += 2;
        }
        if(moveCommand.equals("D")) {
            downCase[i] += 2;
        }
        controller.mapMessage(upCase, downCase, bridgeLength);
        retry();
    }
    public void retry() {
        controller.gameRetriedMessage();
        if(controller.inputReadGameCommand().equals("Q")) {
            controller.gameFailedMessage(upCase, downCase, bridgeLength);
            controller.gameTriedMessage(gameCount);
        }
        gameCount += 1;
        initBridge();
    }
    public void initBridge() {
        upCase = new int[bridge.size()];
        downCase = new int[bridge.size()];
        bridgeLength = 1;
        compareMoveAndBridge();
    }
    public void compareMoveAndBridge() {
        for (int i = 0; i < bridge.size(); i++) {
            controller.movingCommandMessage();
            String movingCommand = controller.inputMovingCommand();
            if(!moveJudge(movingCommand, i)){
                doNotMove(movingCommand, i);
                return ;
            }
            controller.mapMessage(upCase, downCase, bridgeLength);
            bridgeLength += 1;
        }
    }
    public boolean moveJudge(String moveCommand, int i) {
        if(bridge.get(i).equals(moveCommand)){
            move(i);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.play();
    }
}
