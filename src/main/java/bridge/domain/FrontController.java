package bridge.domain;


import bridge.persistence.BridgeRepositoryImpl;
import bridge.persistence.GameRepositoryImpl;
import bridge.ui.InputView;
import java.util.List;

public class FrontController {

    private FrontController frontController;
    private InputView inputView;


    public GameRepository gameRepository() {    return new GameRepositoryImpl();    }

    public BridgeRepository bridgeRepository() {
        return new BridgeRepositoryImpl();
    }

    public BridgeGame bridgeGame() {    return new BridgeGame();    }



    // 게임 동작 관리
    public void controlGame() {

        frontController.bridgeGame();
        reUseBridge();

    }

    private List<String> reUseBridge() {
        BridgeRepository bridgeRepository = new BridgeRepositoryImpl();

        return bridgeRepository.manageBridgeStatus();
    }

}
