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
        for (int i = 0; i < bridgeDTO.getBridge().size(); i++) {
            controller.movingCommandMessage();
            if(!moveJudge(controller.inputMovingCommand(), i)){
                askRestart(bridgeDTO);
                return ;
            }
            controller.mapMessage(bridgeDTO);
            bridgeDTO.addLength(1);
        }
        controller.gameSuccessMessage(bridgeDTO);
    }
    public boolean moveJudge(String moveCommand, int i) {
        if(bridge.get(i).equals(moveCommand)){
            move(i);
            return true;
        }
        bridgeDTO.doNotMove(moveCommand, i);
        return false;
    }
    public void move(int i) {
        bridgeDTO.move(i);
    }

    private void askRestart(BridgeDTO bridgeDTO)
    {
        controller.mapMessage(bridgeDTO);
        controller.gameRetriedMessage();
        if(InputCase.QUIT.getInput().equals(controller.inputReadGameCommand())) {
            controller.gameFailedMessage(bridgeDTO);
            controller.gameTriedMessage(bridgeDTO.getCount());
            return ;
        }
        retry();
    }
    public void retry() {
        bridgeDTO.increaseCount();
        bridgeDTO.initBridge();
        play();
    }
}
