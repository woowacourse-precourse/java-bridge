package bridge;

import java.util.List;

// 공통 관리자
public class FrontController {

    private InputView inputView;
    private FrontController frontController;
    private BridgeMaker bridgeMaker;

    public int gameRepository() {
        return new GameRepositoryImpl().manageRetryStatus(inputView.readGameCommand());
    }
    public List<String> bridgeRepository()  {

        return new BridgeRepositoryImpl()
                .manageStatus(inputView.readBridgeSize());

    }

    public void controller() {

    }

}
