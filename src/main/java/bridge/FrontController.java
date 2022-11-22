package bridge;

import java.util.List;

// 공통 관리자
public class FrontController {

    public GameEntity gameRepository() {
        return new GameEntity();
    }
    public BridgeEntity bridgeRepository()  {

        return new BridgeEntity();

    }

}
