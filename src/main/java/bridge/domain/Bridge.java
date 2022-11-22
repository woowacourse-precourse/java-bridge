package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private int size;
    private List<String> bridge;
    private List<String> userRoute;

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
        if (userPosition.equals(availableBridge) == false) {
            return GameStatus.FAIL;// 현재 건널 수 없는 칸에 위치한 경우 실패
        } if ( userPosition.equals(availableBridge) == true && userRoute.size() == bridge.size() ) {
                return GameStatus.SUCCESS; // 현재 건널 수 있는 칸에 있으면서, 마지막 칸까지 다리를 모두 건넜을 경우 성공
        }
        return GameStatus.CONTINUE; // 아직 실패나 성공을 하지 않았고, 다리를 아직 다 건너지 않았을 경우 게임 계속 진행
    }

    /**
     * @param targetBridge 이동 경로를 얻고자 하는 다리. (U or D의 값을 가짐)
     *
     * @return userRouteInBridge 해당 다리 내 유저의 이동 결과 (O, X, 공백으로 구성된 문자열 리스트)
     */
    public List<String> getUserRouteInTargetBridge (String targetBridge) {
        List<String> userRouteInBridge = new ArrayList<>();
        for (int round=0; round<userRoute.size(); round++) {
            String currentUserPosition = userRoute.get(round);
            String availableDirection = bridge.get(round);
            String currentMovingResult = getMovingResultInTargetBridge(currentUserPosition, availableDirection, targetBridge);
            userRouteInBridge.add(currentMovingResult);
        }
        return userRouteInBridge;
    }

    /**
     * @param currentUserPosition 현재 라운드에서 유저의 위치 (U or D)
     * @param availableDirection 현재 라운드에서 이용 가능한 다리의 종류 (U or D)
     * @param targetBridge 이동 결과를 얻고자 하는 다리
     *
     * @return 각 다리에 해당하는 유저의 이동 결과를 'O', 'X', ' '로 구분하여 반환합니다.
     */
    public String getMovingResultInTargetBridge (String currentUserPosition, String availableDirection, String targetBridge) {
        if (currentUserPosition.equals(targetBridge) == true) { // 이동 결과를 얻고자 하는 다리에 있는 경우
            if (availableDirection.equals(currentUserPosition) == true) {
                return "O"; // 이동한 다리가 이용 가능한 다리였을 경우 'O' 반환
            } if (availableDirection.equals(currentUserPosition) == false) {
                return "X"; // 이동한 다리가 이용 가능한 다리가 아니었을 경우 'X' 반환
            }
        }
        return " ";  // 이동 결과를 얻고자 하는 다리에 있지 않은 경우 공백 반환
    }

    public void initializeUserRoute() {
        this.userRoute = new ArrayList<>();
    }
}
