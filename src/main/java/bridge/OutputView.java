package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void startGame(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(int idx, List<String> bridge, boolean isMoved) {
        List<String> bridgeList = setBridge(idx, bridge);
        List<String> resultList = new ArrayList<>();

        if (isMoved == true) {
            resultList = getBridge(bridgeList,"O",bridge.get(idx));
        }
        if (isMoved == false) {
            resultList = getBridge(bridgeList,"X",bridge.get(idx));
        }
        System.out.println(resultList.get(0)+"\n"+resultList.get(1));
    }
    public List<String> getBridge(List<String>bridgeList, String isMoved, String lastString) {
        String firstBridge = bridgeList.get(0);
        String secondBridge = bridgeList.get(1);
        if ( (isMoved.equals("O") && lastString.equals("U")) || isMoved.equals("X") && lastString.equals("D") ) {
            firstBridge += " "+isMoved+" ]";
            secondBridge += "   ]";
        }
        if ( (isMoved.equals("O") && lastString.equals("D")) || isMoved.equals("X") && lastString.equals("U") ) {
            firstBridge += "   ]";
            secondBridge += " "+isMoved+" ]";
        }
        return new ArrayList<>(Arrays.asList(firstBridge,secondBridge));
    }

    public List<String> setBridge(int idx, List<String> bridge) {
        String firstBridge = "[";
        String secondBridge = "[";
        for (int i=0; i<idx; i++) {
            if (bridge.get(i).equals("U")) {
                firstBridge += " O |";
                secondBridge += "   |";
            }
            if (bridge.get(i).equals("D")) {
                firstBridge += "   |";
                secondBridge += " O |";
            }
        }
        return new ArrayList<>(Arrays.asList(firstBridge,secondBridge));
    }

    public void printResult(int count, int idx, List<String> bridge, boolean result) {
        System.out.println("최종 게임 결과");
        printMap(idx, bridge, result);
        String strResult = "실패";
        if (result) {
            strResult = "성공";
        }
        System.out.println("게임 성공 여부: "+strResult);
        System.out.println("총 시도한 횟수: "+count);
    }
}
