package bridge.domain;

import bridge.controller.BridgeController;
import bridge.handler.InputRestartHandler;
import bridge.view.PrintView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    public static int checkAnswerIndex = 0;
    public static int retryCount = 0;
    public List<String> upSide = new ArrayList<>();
    public List<String> downSide = new ArrayList<>();
    private String restart;
    PrintView printView = new PrintView();
    InputRestartHandler inputRestartHandler = new InputRestartHandler(restart);

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
            firstResult(upSide, downSide);
        }
        if(index > 0){
            remainResult(upSide, downSide);
        }
    }

    public void firstResult(List<String> upSide, List<String> downSide) {
        printFirstStep();

        if (upSide.get(0).contains("X") || downSide.get(0).contains("X")) {
            checkAnswerIndex = 1;
            printView.lineSkip();
            System.out.println(printView.EXIT_OR_CONTINUE);
            checkRestartOrQuit(inputRestartHandler.checkValidator(printView.continueOrExit()));
        }
    }

    private void printFirstStep(){
        System.out.print(upSide.get(0));
        printView.lineSkip();
        System.out.print(downSide.get(0));
        printView.lineSkip();
    }

    private void checkRestartOrQuit(String checkRestart) {
        if(checkRestart.equals("Q")) {
            selectQuit();
        }

        if(checkRestart.equals("R")) {
            selectRestart();
        }
    }

    private void selectQuit() {
        System.out.println(printView.THE_GAME_RESULT);
        extractBracket(upSide,downSide);
        printView.lineSkip();
        printFailOrSuccessCase();
    }

    public void printFailOrSuccessCase() {
        if(checkAnswerIndex == 1) {
            System.out.println();
            System.out.println(printView.SUCCESS_OR_FAIL+" "+ printView.FAIL);
            System.out.println(printView.TOTAL_COUNT+" "+ retryCount);
        }

        if(checkAnswerIndex == 2) {
            System.out.println();
            System.out.println(printView.SUCCESS_OR_FAIL+" "+ printView.SUCCESS);
            System.out.println(printView.TOTAL_COUNT+" "+ retryCount);
        }
    }

    private void selectRestart() {
        OutputView outputView = new OutputView();

        checkAnswerIndex = 0;
        upSide.clear();
        downSide.clear();
        outputView.stepBridge(BridgeController.bridgeData);
    }

    private void remainResult(List<String> upSideList, List<String> downSideList) {
        extractBracket(upSideList, downSideList);
        printView.lineSkip();

        if(!checkRemainResult(upSide, downSide)){
            checkQuitOrContinue();
        }
    }

    private void checkQuitOrContinue() {
        checkAnswerIndex = 1;
        printView.lineSkip();
        System.out.println(printView.EXIT_OR_CONTINUE);
        String checkRestart = retry();
        checkRestartOrQuit(checkRestart);
        printView.lineSkip();
    }

    public void extractBracket(List<String> upSideList, List<String> downSideList) {
        System.out.print(changeToBracket(upSideList));
        printView.lineSkip();
        System.out.print(changeToBracket(downSideList));
    }

    private boolean checkRemainResult(List<String> upSide, List<String> downSide) {

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

    private String retry() {
        return printView.continueOrExit();
    }
}
