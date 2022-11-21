package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void startGame(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(int idx, List<String> bridge, boolean isMoved) {
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
        if (isMoved) {
            if (bridge.get(idx).equals("U")) {
                firstBridge += " O ]";
                secondBridge += "   ]";
            }
            if (bridge.get(idx).equals("D")){
                secondBridge += " O ]";
                firstBridge += "   ]";
            }
        }
        if (!isMoved) {
            if (bridge.get(idx).equals("U")) {
                firstBridge += "   ]";
                secondBridge += " X ]";
            }
            if (bridge.get(idx).equals("D")) {
                secondBridge += "   ]";
                firstBridge += " X ]";
            }
        }
        System.out.println(firstBridge);
        System.out.println(secondBridge);
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
