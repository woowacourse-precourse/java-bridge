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
        initializeUserRoute();
    }

    public GameStatus updateUserRoute(String direction) {
        userRoute.add(direction); // 유저가 입력한 방향을 유저 이동 경로에 추가
        int currentRound = userRoute.size() - 1;

        String currentUserPosition = userRoute.get(currentRound);
        String availableBridge = bridge.get(currentRound);

        GameStatus currentGameStatus = getCurrentGameStatus(currentUserPosition, availableBridge);
        return currentGameStatus;
    }

    public GameStatus getCurrentGameStatus(String userPosition, String availableBridge) {
        if (userPosition.equals(availableBridge) == false) { // 현재 건널 수 없는 칸에 위치한 경우 실패
            return GameStatus.FAIL;
        } if (userPosition.equals(availableBridge) == true) { // 현재 건널 수 있는 칸에 위치한 경우
            if ((userRoute.size() == bridge.size())) {
                return GameStatus.SUCCESS; // 마지막 칸까지 다리를 모두 건넌 경우 성공
            }
        }
        return GameStatus.CONTINUE; // 아직 실패나 성공을 하지 않았고, 다리를 아직 다 건너지 않았을 경우 게임 계속 진행
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

    public void initializeUserRoute() {
        this.userRoute = new ArrayList<>();
    }
}
