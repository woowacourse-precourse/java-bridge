package bridge;

import bridge.constant.Constant;
import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private List<List<String>> bridgeMap = new ArrayList<>();

    public void initMap() {
        bridgeMap.clear();
        for (int i = 0; i < Constant.BRIDGE_WIDTH; i++) {
            bridgeMap.add(new ArrayList<>());
        }
    }

    public void move(String answer, String moving) {
        // TODO : 중복 제거해서 메서드 길이 줄일 것 / else 문 없애도록 노력할 것
        if (answer.equals(moving)) {
            if (moving.equals(Constant.UP)) {
                bridgeMap.get(0).add("O");
                bridgeMap.get(1).add(" ");
            } else {
                bridgeMap.get(0).add(" ");
                bridgeMap.get(1).add("O");
            }
        } else {
            if (moving.equals(Constant.UP)) {
                bridgeMap.get(0).add("X");
                bridgeMap.get(1).add(" ");
            } else {
                bridgeMap.get(0).add(" ");
                bridgeMap.get(1).add("X");
            }
        }
    }

    public void retry() {
    }
}
