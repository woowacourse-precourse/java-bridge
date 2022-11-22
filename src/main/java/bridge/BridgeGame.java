package bridge;

import java.util.List;

public class BridgeGame {
    private final TotalViewController totalViewController;
    private final List<String> bridge;
    private final BridgeDTO bridgeDTO;
    public BridgeGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        totalViewController = new TotalViewController();
        totalViewController.startMessage().bridgeSizeMessage();
        bridge = bridgeMaker.makeBridge(totalViewController.inputBridgeSize());
        bridgeDTO = new BridgeDTO(bridge);
    }
    public void play() {
        for (int i = 0; i < bridgeDTO.getBridge().size(); i++) {
            totalViewController.movingCommandMessage();
            if(!moveJudge(totalViewController.inputMovingCommand(), i)){
                askRestart(bridgeDTO);
                return ;
            }
            totalViewController.mapMessage(bridgeDTO);
            bridgeDTO.addLength(1);
        }
        totalViewController.gameSuccessMessage(bridgeDTO).gameTriedMessage(bridgeDTO.getCount());
    }
    public boolean moveJudge(String moveCommand, int currentPosition) {
        if(bridge.get(currentPosition).equals(moveCommand)){
            move(currentPosition);
            return true;
        }
        moveFailed(moveCommand, currentPosition);
        return false;
    }
    public void move(int currentPosition) {
        bridgeDTO.move(currentPosition);
    }
    public void moveFailed(String moveCommand, int currentPosition){
        bridgeDTO.moveFailed(moveCommand, currentPosition);
    }

    public void retry() {
        bridgeDTO.increaseCount();
        bridgeDTO.initBridge();
        play();
    }
    public void askRestart(BridgeDTO bridgeDTO) {
        totalViewController.mapMessage(bridgeDTO);
        totalViewController.gameRetriedMessage();
        if(InputCase.QUIT.getInput().equals(totalViewController.inputReadGameCommand())) {
            totalViewController.gameFailedMessage(bridgeDTO).gameTriedMessage(bridgeDTO.getCount());
            return ;
        }
        retry();
    }
}
