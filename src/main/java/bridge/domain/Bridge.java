package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    int size;
    List<String> bridge;
    List<String> userRoute;

    public Bridge(int size) {
        BridgeNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);
        this.size = size;
        this.bridge = bridgeMaker.makeBridge(this.size);
        this.userRoute = new ArrayList<>();
    }

    public gameStatus updateUserRoute(String direction) {
        userRoute.add(direction);
        int currentRound = userRoute.size() - 1;

        if (userRoute.get(currentRound) != bridge.get(currentRound)) { // 갈 수 없는 칸으로 이동한 경우
            return gameStatus.FAIL;

        } if (userRoute.size() == bridge.size()) { // 도착한 경우
            return gameStatus.SUCCESS;

        } if (userRoute.size() < bridge.size()) { // 게임을 계속 진행하는 경우
            return gameStatus.CONTINUE;
        }
        return null;
    }
}
