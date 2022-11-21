package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Controller controller;
    private final List<String> bridge;
    private BridgeDTO bridgeDTO;
    public BridgeGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        controller = new Controller();
        controller.startMessage().bridgeSizeMessage();
        bridge = bridgeMaker.makeBridge(controller.inputBridgeSize());
        bridgeDTO = new BridgeDTO(bridge);
    }
    public void play() {
        System.out.println(bridge);
        compareMoveAndBridge();
        controller.gameSuccessMessage(bridgeDTO);
    }
    public void move(int i) {
        bridgeDTO.move(i);
    }
    public void retry() {
        bridgeDTO.increaseCount();
        bridgeDTO.initBridge();
        compareMoveAndBridge();
    }
    public void compareMoveAndBridge() {
        for (int i = 0; i < bridgeDTO.getBridge().size(); i++) {
            controller.movingCommandMessage();
            if(!moveJudge(controller.inputMovingCommand(), i)){
                controller.mapMessage(bridgeDTO);
                askRestart(bridgeDTO);
                return ;
            }
            controller.mapMessage(bridgeDTO);
            bridgeDTO.addLength(1);
        }
    }

    private void askRestart(BridgeDTO bridgeDTO)
    {
        controller.gameRetriedMessage();
        if(controller.inputReadGameCommand().equals("Q")) {
            controller.gameFailedMessage(bridgeDTO);
            controller.gameTriedMessage(bridgeDTO.getCount());
            return ;
        }
        retry();
    }
    public boolean moveJudge(String moveCommand, int i) {
        if(bridge.get(i).equals(moveCommand)){
            move(i);
            return true;
        }
        bridgeDTO.doNotMove(moveCommand, i);
        return false;
    }

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.play();
    }
}
