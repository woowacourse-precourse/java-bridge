package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    Controller controller = new Controller();
    public int bridgeLength = 1;
    public int gameCount = 1;
    public List<String> bridge;
    public int [] upCase;
    public int [] downCase;
    public void play(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        controller.startMessage();
        controller.bridgeSizeMessage();
        bridge = bridgeMaker.makeBridge(controller.inputBridgeSize());
        System.out.println(bridge);
        initBridge();
        controller.gameSuccessMessage(upCase, downCase, gameCount);
    }
    public boolean move(String moveCommand, int i) {
        if(bridge.get(i).equals(moveCommand)){
            if(bridge.get(i).equals("U")) {
                upCase[i] += 1;
            }
            if(bridge.get(i).equals("D")) {
                downCase[i] += 1;
            }
            return true;
        }
        return false;
    }
    public void doNotMove(String moveCommand, int i){
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
    public void initBridge(){
        upCase = new int[bridge.size()];
        downCase = new int[bridge.size()];
        bridgeLength = 1;
        compareMoveAndBridge();
    }
    public void compareMoveAndBridge(){
        for (int i = 0; i < bridge.size(); i++) {
            controller.movingCommandMessage();
            String movingCommand = controller.inputMovingCommand();
            if(!move(movingCommand, i)){
                doNotMove(movingCommand, i);
                return;
            }
            controller.mapMessage(upCase, downCase, bridgeLength);
            bridgeLength += 1;
        }
    }
}
