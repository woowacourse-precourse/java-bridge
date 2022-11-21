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

        // TODO: 테스트용 출력문 제거
        System.out.println("bridge in this round : "+bridge.get(currentRound));
        System.out.println("userRoute in this round : "+userRoute.get(currentRound));

        if (userRoute.get(currentRound).equals(bridge.get(currentRound)) == false) {
            return gameStatus.FAIL;

        } if (userRoute.get(currentRound).equals(bridge.get(currentRound)) == true) {
            if ((userRoute.size() == bridge.size())) {
                return gameStatus.SUCCESS;
            }
            return gameStatus.CONTINUE;
        }
        return gameStatus.CONTINUE;
    }
}
