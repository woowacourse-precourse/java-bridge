package bridge.service;

import bridge.controller.BridgeController;
import bridge.domain.BridgeGame;
import bridge.view.OutputView;
import bridge.view.PrintView;

import java.util.List;

public class BridgeMoveStepService {

    public void pickRestart(List<String> upSide, List<String> downSide) {
        OutputView outputView = new OutputView();

        BridgeGame.checkResultFlag = 0;
        upSide.clear();
        downSide.clear();
        outputView.stepBridge(BridgeController.bridgeData);
    }

    public void pickExit(List<String> upSide, List<String> downSide) {
        PrintView printView = new PrintView();
        OutputView outputView = new OutputView();

        System.out.println(printView.THE_GAME_RESULT);
        extractBracket(upSide,downSide);
        printView.lineSkip();
        outputView.printSuccessOrFailCase();
    }

    public void extractBracket(List<String> upSideList, List<String> downSideList) {
        PrintView printView = new PrintView();

        System.out.print(changeToBracket(upSideList));
        printView.lineSkip();
        System.out.print(changeToBracket(downSideList));
    }

    private String changeToBracket(List<String> extractBracket) {
        StringBuilder bridgeData = new StringBuilder();

        for (String s : extractBracket) {
            bridgeData.append(s);
        }

        return bridgeData.toString().replaceAll("]\\[","|");
    }
}
