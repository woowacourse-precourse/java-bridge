package bridge.domain;

import bridge.view.OrderView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    OrderView orderView = new OrderView();
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
            orderView.checkAnswerIndex = 1;
            System.out.println();
            System.out.println(orderView.EXIT_OR_CONTINUE);
            checkRestart = orderView.continueOrExit();
        }
        checkRestartOrQuit(checkRestart);
    }

    private void checkRestartOrQuit(String checkRestart) {
        if(checkRestart.equals("Q")){
            System.out.println(orderView.THE_GAME_RESULT);
            finalGameResult();
        }
        if(checkRestart.equals("R")){
            orderView.checkAnswerIndex = 0;
            upSide.clear();
            downSide.clear();
        }
    }

    public void finalGameResult() {
        for(int i = 0; i < upSide.size(); i++){
            System.out.println(upSide.get(i));
        }
        for(int i = 0; i < downSide.size(); i++){
            System.out.print(downSide.get(i));
        }
        System.out.println();
        printFailOrSuccessCase();
    }

    private void printFailOrSuccessCase() {
        if(orderView.checkAnswerIndex == 1){
            System.out.println();
            System.out.println(orderView.SUCCESS_OR_FAIL+" "+orderView.FAIL);
            System.out.println(orderView.TOTAL_COUNT+" "+orderView.retryCount);
        }
        if(orderView.checkAnswerIndex == 2){
            System.out.println();
            System.out.println(orderView.SUCCESS_OR_FAIL+": "+orderView.SUCCESS);
            System.out.println(orderView.TOTAL_COUNT+": "+orderView.retryCount);
        }
    }

    private void restResult(List<String> upSide, List<String> downSide) {
        System.out.print(changeToBracket(upSide));
        orderView.lineSkip();
        System.out.print(changeToBracket(downSide));
        orderView.lineSkip();
    }

    private String changeToBracket(List<String> extractBracket){
        String bridgeData = "";
        for(int i = 0; i < extractBracket.size() ; i++){
            bridgeData += extractBracket.get(i);
        }
        if(bridgeData.contains("X") && retry().equals("X")){
            orderView.continueOrExit();
            orderView.checkAnswerIndex = 1;
            System.out.println(orderView.THE_GAME_RESULT);
        }
        return bridgeData.replaceAll("]\\[","|");
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private String retry() {
        String pickRestart = orderView.continueOrExit();
        return  pickRestart;
    }
}
