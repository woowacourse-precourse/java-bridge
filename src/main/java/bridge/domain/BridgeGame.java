package bridge.domain;

import bridge.controller.BridgeController;
import bridge.handler.InputRestartHandler;
import bridge.view.OrderView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    OrderView orderView = new OrderView();
    InputRestartHandler inputRestartHandler = new InputRestartHandler();
    public List<String> upSide = new ArrayList<>();
    public List<String> downSide = new ArrayList<>();
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveStep, String bridgeIndexData, int index) {
        if(moveStep.equals("U") && bridgeIndexData.equals("0")) { gameResult(orderView.wrong(),orderView.space(), index);}
        if(moveStep.equals("U") && bridgeIndexData.equals("1")) { gameResult(orderView.correct(),orderView.space(), index);}
        if(moveStep.equals("D") && bridgeIndexData.equals("0")) { gameResult(orderView.space(),orderView.correct(), index);}
        if(moveStep.equals("D") && bridgeIndexData.equals("1")) { gameResult(orderView.space(),orderView.wrong(), index);}
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
        String checkRestart = "";
        System.out.print(upSide);
        orderView.lineSkip();
        System.out.print(downSide);
        orderView.lineSkip();
        if (upSide.contains("X") || downSide.contains("X")) {
            OrderView.checkAnswerIndex = 1;
            System.out.println();
            System.out.println(orderView.EXIT_OR_CONTINUE);
            checkRestartOrQuit(inputRestartHandler.checkValidator(orderView.continueOrExit()));
        }
    }

    private void checkRestartOrQuit(String checkRestart) {
        BridgeController bridgeController = new BridgeController();
        OutputView outputView =new OutputView();

        if(checkRestart.equals("Q")){
            System.out.println(orderView.THE_GAME_RESULT);
            extractBracket(upSide,downSide);
            orderView.lineSkip();
            printFailOrSuccessCase();
        }
        if(checkRestart.equals("R")){
            OrderView.checkAnswerIndex = 0;
            upSide.clear();
            downSide.clear();
            outputView.stepBridge(BridgeController.bridgeData);
        }
    }

    public void printFailOrSuccessCase() {
        if(OrderView.checkAnswerIndex == 1){
            System.out.println();
            System.out.println(orderView.SUCCESS_OR_FAIL+" "+orderView.FAIL);
            System.out.println(orderView.TOTAL_COUNT+" "+orderView.retryCount);
        }
        if(OrderView.checkAnswerIndex == 2){
            System.out.println();
            System.out.println(orderView.SUCCESS_OR_FAIL+" "+orderView.SUCCESS);
            System.out.println(orderView.TOTAL_COUNT+" "+orderView.retryCount);
        }
    }

    private void restResult(List<String> upSideList, List<String> downSideList) {
        String checkRestart = "";
        extractBracket(upSideList, downSideList);
        if(OrderView.checkAnswerIndex == 1) restContainsX();
        orderView.lineSkip();
        if(!checkRestResult(upSide, downSide)){
            OrderView.checkAnswerIndex = 1;
            System.out.println();
            System.out.println(orderView.EXIT_OR_CONTINUE);
            checkRestart = orderView.continueOrExit();
            checkRestartOrQuit(checkRestart);
            orderView.lineSkip();
        }
    }

    public void extractBracket(List<String> upSideList, List<String> downSideList) {
        System.out.print(changeToBracket(upSideList));
        orderView.lineSkip();
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
        OrderView.checkAnswerIndex = 1;
        BridgeController bridgeController = new BridgeController();
        OutputView outputView =new OutputView();
        String pickrestart = "";
        System.out.println(orderView.EXIT_OR_CONTINUE);
        pickrestart = retry();
        if(pickrestart.equals("Q")){
            OrderView.checkAnswerIndex = 1;
            System.out.println(orderView.THE_GAME_RESULT);
            extractBracket(upSide,downSide);
            orderView.lineSkip();
            printFailOrSuccessCase();
        }
        if(pickrestart.equals("R")){
            OrderView.checkAnswerIndex = 0;
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
        return orderView.continueOrExit();
    }
}
