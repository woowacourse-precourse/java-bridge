package bridge.domain;

import java.util.List;

public class Status {

    private final List<String> bridgeStatus;

    public Status(List<String> bridgeStatus) {
        this.bridgeStatus = bridgeStatus;
    }

    // 유저의 입력과 만들어진 다리의 인덱스가 같다면 걸을 수 있는 다리인 상태
    public boolean isMove(List<String> playerMoving, int index) {
        return bridgeStatus.get(index).equals(playerMoving.get(index));
    }

    public int getstatusSize() {
        return bridgeStatus.size();
    }
}
