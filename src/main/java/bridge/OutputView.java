package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Code.PrintCode.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartMessage(){
        System.out.println(GAME_START.getMessage());
    }
    public void printGetBridgeLength(){
        System.out.println();
        System.out.println(GET_BRIDGE_LENGTH.getMessage());
    }
    public void printGetSpaceToMove(){
        System.out.println();
        System.out.println(GET_SPACE_TO_MOVE.getMessage());
    }
    public void printGetTryAgain(){
        System.out.println();
        System.out.println(GET_TRY_AGAIN.getMessage());
    }
    public void printFinalResult(){
        System.out.println();
        System.out.println(RETURN_FINAL_RESULT.getMessage());
    }
    public void printIsSuccessful(String result){
        System.out.println();
        System.out.println(RETURN_IS_SUCCESSFUL.getMessage() + result);
    }
    public void printTryCount(int count){
        System.out.println(RETURN_TRY_COUNT.getMessage() + String.valueOf(count));
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> tmpBridge, String nowMoving) {
        System.out.println("[" + setFillUpMap(tmpBridge, nowMoving) + "]");
        System.out.println("[" + setFillDownMap(tmpBridge, nowMoving) + "]");
    }
    public String setFillUpMap(List<String> tmpBridge, String nowMoving){
        String upMap = " ";
        for (int index=0; index<tmpBridge.size(); index++) {
            if (tmpBridge.get(index).equals("U")) upMap += "O ";
            if (tmpBridge.get(index).equals("D")) upMap += "  ";
            if (tmpBridge.get(index).equals("F") && nowMoving.equals("U")) upMap += "X ";
            if (tmpBridge.get(index).equals("F") && !nowMoving.equals("U")) upMap += "  ";
            if (index + 1 < tmpBridge.size()) upMap += "| ";
        }
        return upMap;
    }
    public String setFillDownMap(List<String> tmpBridge, String nowMoving){
        String downMap = " ";
        for (int index=0; index<tmpBridge.size(); index++) {
            if (tmpBridge.get(index).equals("U")) downMap += "  ";
            if (tmpBridge.get(index).equals("D")) downMap += "O ";
            if (tmpBridge.get(index).equals("F") && nowMoving.equals("D")) downMap += "X ";
            if (tmpBridge.get(index).equals("F") && !nowMoving.equals("D")) downMap += "  ";
            if (index + 1 < tmpBridge.size()) downMap += "| ";
        }
        return downMap;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
