package bridge.View;

import bridge.BridgeGame;
import java.util.List;

import static bridge.Constant.Message.*;


public class OutputView {


    public void printMap(List<List<String>> curBridge) {
        System.out.println(makeLine(curBridge.get(0)));
        System.out.println(makeLine(curBridge.get(1)));
    }

    private String makeLine(List<String> curLine){
        String line = "[ ";
        line += String.join(" | ",curLine);
        line += " ]";
        return line;
    }


    public void printResult(BridgeGame bridgeGame) {
        String status = bridgeGame.getStatus().getText();
        int stageNum = bridgeGame.getStageNum();

        printMap(bridgeGame.getCurBridge());
        System.out.println(MSG_END_SUCCESS+status);
        System.out.println(MSG_END_TRY+stageNum);
    }
}
