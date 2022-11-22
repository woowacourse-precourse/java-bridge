package bridge.domain;

import bridge.views.InputView;

import java.util.List;

public class BridgeJudgment {

    public static List<String> RESULT_BRIDGE;
//    public String S = InputView.readMoving();

//    public String getS() {
//        return S;
//    }

    public static boolean judgmentMoving(List<String> resultBridge, int I) {
        String S = InputView.readMoving();

        if(resultBridge.get(I-1).equals(S)) {
            return true;
        } return false;
    }
}
