package bridge.domain;

import bridge.controller.BridgeController;
import bridge.handler.InputRestartHandler;
import bridge.view.PrintView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    PrintView printView = new PrintView();
    InputRestartHandler inputRestartHandler = new InputRestartHandler();
    public List<String> upSide = new ArrayList<>();
    public List<String> downSide = new ArrayList<>();
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveStep, String bridgeIndexData, int index) {
        if(moveStep.equals("U") && bridgeIndexData.equals("0")) { gameResult(printView.wrong(), printView.space(), index);}
        if(moveStep.equals("U") && bridgeIndexData.equals("1")) { gameResult(printView.correct(), printView.space(), index);}
        if(moveStep.equals("D") && bridgeIndexData.equals("0")) { gameResult(printView.space(), printView.correct(), index);}
        if(moveStep.equals("D") && bridgeIndexData.equals("1")) { gameResult(printView.space(), printView.wrong(), index);}
    }

    private void gameResult(String up, String down, int index) {
        upSide.add(up);
        downSide.add(down);

        if(index == 0) {
            firstResult(upSide.get(index), downSide.get(index));
        }
        if(index > 0){
            restResult(upSide, downSide);
        }
    }

    public void firstResult(String upSide, String downSide) {
        System.out.print(upSide);
        printView.lineSkip();
        System.out.print(downSide);
        printView.lineSkip();
        if (upSide.contains("X") || downSide.contains("X")) {
            PrintView.checkAnswerIndex = 1;
            System.out.println();
            System.out.println(printView.EXIT_OR_CONTINUE);
            checkRestartOrQuit(inputRestartHandler.checkValidator(printView.continueOrExit()));
        }
    }

    private void checkRestartOrQuit(String checkRestart) {
        OutputView outputView =new OutputView();

        if(checkRestart.equals("Q")){
            System.out.println(printView.THE_GAME_RESULT);
            extractBracket(upSide,downSide);
            printView.lineSkip();
            printFailOrSuccessCase();
        }
        if(checkRestart.equals("R")){
            PrintView.checkAnswerIndex = 0;
            upSide.clear();
            downSide.clear();
            outputView.stepBridge(BridgeController.bridgeData);
        }
    }

    public void printFailOrSuccessCase() {
        if(PrintView.checkAnswerIndex == 1){
            System.out.println();
            System.out.println(printView.SUCCESS_OR_FAIL+" "+ printView.FAIL);
            System.out.println(printView.TOTAL_COUNT+" "+ printView.retryCount);
        }
        if(PrintView.checkAnswerIndex == 2){
            System.out.println();
            System.out.println(printView.SUCCESS_OR_FAIL+" "+ printView.SUCCESS);
            System.out.println(printView.TOTAL_COUNT+" "+ printView.retryCount);
        }
    }

    private void restResult(List<String> upSideList, List<String> downSideList) {
        String checkRestart = "";
        extractBracket(upSideList, downSideList);
        if(PrintView.checkAnswerIndex == 1) restContainsX();
        printView.lineSkip();
        if(!checkRestResult(upSide, downSide)){
            PrintView.checkAnswerIndex = 1;
            System.out.println();
            System.out.println(printView.EXIT_OR_CONTINUE);
            checkRestart = printView.continueOrExit();
            checkRestartOrQuit(checkRestart);
            printView.lineSkip();
        }
    }

    public void extractBracket(List<String> upSideList, List<String> downSideList) {
        System.out.print(changeToBracket(upSideList));
        printView.lineSkip();
        System.out.print(changeToBracket(downSideList));
    }

    private boolean checkRestResult(List<String> upSide, List<String> downSide) {
        for (String s : upSide) {
            if (s.contains("X")) return false;
        }
        for (String s : downSide) {
            if (s.contains("X")) return false;
        }
        return true;
    }

    private String changeToBracket(List<String> extractBracket){
        StringBuilder bridgeData = new StringBuilder();
        for (String s : extractBracket) {
            bridgeData.append(s);
        }
        return bridgeData.toString().replaceAll("]\\[","|");
    }

    private void restContainsX(){
        // 빼야함
        PrintView.checkAnswerIndex = 1;
        BridgeController bridgeController = new BridgeController();
        OutputView outputView =new OutputView();
        String pickrestart = "";
        System.out.println(printView.EXIT_OR_CONTINUE);
        pickrestart = retry();
        if(pickrestart.equals("Q")){
            PrintView.checkAnswerIndex = 1;
            System.out.println(printView.THE_GAME_RESULT);
            extractBracket(upSide,downSide);
            printView.lineSkip();
            printFailOrSuccessCase();
        }
        if(pickrestart.equals("R")){
            PrintView.checkAnswerIndex = 0;
            upSide.clear();
            downSide.clear();
            outputView.stepBridge(BridgeController.bridgeData);
        }
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private String retry() {
        return printView.continueOrExit();
    }
}
