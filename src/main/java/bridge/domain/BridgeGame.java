package bridge.domain;

import bridge.handler.InputRestartHandler;
import bridge.service.BridgeMoveStepService;
import bridge.view.PrintView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    public static int checkAnswerIndex = 0;
    public static int retryCount = 0;
    public List<String> upSide = new ArrayList<>();
    public List<String> downSide = new ArrayList<>();
    private String restart;
    PrintView printView = new PrintView();
    BridgeMoveStepService bridgeMoveStepService = new BridgeMoveStepService();
    InputRestartHandler inputRestartHandler = new InputRestartHandler(restart);

    public void move(String moveStep, String bridgeIndexData, int index) {

        if(moveStep.equals("U") && bridgeIndexData.equals("D")) { gameResult(printView.wrong(), printView.space(), index);}
        if(moveStep.equals("U") && bridgeIndexData.equals("U")) { gameResult(printView.correct(), printView.space(), index);}
        if(moveStep.equals("D") && bridgeIndexData.equals("D")) { gameResult(printView.space(), printView.correct(), index);}
        if(moveStep.equals("D") && bridgeIndexData.equals("U")) { gameResult(printView.space(), printView.wrong(), index);}
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
            bridgeMoveStepService.selectQuit(upSide, downSide);
        }

        if(checkRestart.equals("R")) {
            bridgeMoveStepService.selectRestart(upSide, downSide);
        }
    }

    public void printFailOrSuccessCase() {
        if(checkAnswerIndex == 1) {
            printView.lineSkip();
            System.out.println(printView.SUCCESS_OR_FAIL+" "+ printView.FAIL);
            System.out.println(printView.TOTAL_COUNT+" "+ retryCount);
        }
        if(checkAnswerIndex == 2) {
            printView.lineSkip();
            System.out.println(printView.SUCCESS_OR_FAIL+" "+ printView.SUCCESS);
            System.out.println(printView.TOTAL_COUNT+" "+ retryCount);
        }
    }

    private void remainResult(List<String> upSideList, List<String> downSideList) {
        bridgeMoveStepService.extractBracket(upSideList, downSideList);
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

    private boolean checkRemainResult(List<String> upSide, List<String> downSide) {

        for (String s : upSide) {
            if (s.contains("X")) return false;
        }
        for (String s : downSide) {
            if (s.contains("X")) return false;
        }

        return true;
    }

    private String retry() {
        return printView.continueOrExit();
    }
}