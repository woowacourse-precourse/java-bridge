package bridge;

import java.util.ArrayDeque;
import java.util.List;

public class BridgeStatusMaker {

    // 출력용 다리 상태 메시지 생성 : 사용자 입력이 정답 시 O를, 정답 실패 시 X를 메시지 마지막 부분에 삽입
    ArrayDeque<String> makeBridgeForPrint(List<String> bridge, String moving, int currentPosition) {
        ArrayDeque<String> bridgeStatus = new ArrayDeque<>(bridge.subList(0, currentPosition - 1));
        if (moving.equals(bridge.get(currentPosition))) {
            bridgeStatus.add(moving + "O");
            return bridgeStatus;
        }
        bridgeStatus.add(moving + "X");
        return bridgeStatus;
    }
}
