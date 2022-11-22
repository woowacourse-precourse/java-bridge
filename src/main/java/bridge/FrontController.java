package bridge;

// 공통 관리자
public class FrontController {

    public GameEntity gameRepository() {
        return new GameEntity();
    }

    public BridgeEntity bridgeRepository() {

        return new BridgeEntity();

    }

    public int readBridgeSize() {
        return new InputView().readBridgeSize();
    }

    public String readMoving() {
        return new InputView().readMoving();
    }

    public String readGameCommand() {
        return new InputView().readGameCommand();
    }


}
