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

    public List<String> getUserRoute() {
        return this.userRoute;
    }

    /**
     * @param direction 이동 경로를 출력할 다리. U 또는 D의 값을 가진다.
     */
    // TODO: indent, 메서드 길이 개선 필요
    public List<String> getEachBridgeRouteInfo (String direction) {
        List<String> eachBridgeRouteInfo = new ArrayList<>();
        for (int round=0; round<userRoute.size(); round++) {
            if (direction.equals(userRoute.get(round)) == false) { // 해당 다리를 선택하지 않았으면
                eachBridgeRouteInfo.add(" ");
            } if (direction.equals(userRoute.get(round)) == true) { // 해당 다리를 선택했다면
                if (bridge.get(round).equals(userRoute.get(round)) == true) { // 해당 방향이 갈 수 있는 방향일 경우
                    eachBridgeRouteInfo.add("O");
                } if (bridge.get(round).equals(userRoute.get(round)) == false) { // 해당 방향으로 갈 수 없는 경우
                    eachBridgeRouteInfo.add("X");
                }
            }
        }
        return eachBridgeRouteInfo;
    }
}
