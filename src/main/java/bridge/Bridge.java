package bridge;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public PassFail compare(String input, int index) {
        if (bridge.get(index).equals(input)) {
            return PassFail.PASS;
        }
        return PassFail.FAIL;
    }
}
//        if (bridge.get(i).equals(input) && i == bridge.size() - 1) { //마지막 칸을 어떻게 표현하지??이게 최선인가..?
//게임종료[성공]
//            }