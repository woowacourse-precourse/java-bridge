package bridge.ui;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String UP = "U";
    private static final String DOWN = "D";

    public void printBridgeGameStart(){
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, int position, boolean isPass) {
        List<String> upBridge = getBridgeListWithString(bridge, UP, position);
        List<String> downBridge = getBridgeListWithString(bridge, DOWN, position);

        if (isPass) {
            passCorrect(upBridge, downBridge, bridge.get(position));
        }
        if(!isPass){
            passUnCorrect(upBridge, downBridge, bridge.get(position));
        }
        System.out.println(upBridge);
        System.out.println(downBridge);
    }

    private void passCorrect(List<String> up, List<String> down, String s) {
        if (s.equals(UP)) {
            addLastCorrect(up, down);
            return;
        }
        if (s.equals(DOWN)) {
            addLastCorrect(down,up);
            return;
        }
    }
    private void passUnCorrect(List<String> up, List<String> down, String s) {
        if (s.equals(UP)) {
            addLastWrong(down, up);
            return;
        }
        if (s.equals(DOWN)) {
            addLastWrong(up,down);
            return;
        }
    }

    private void addLastCorrect(List<String> front, List<String> back) {
        front.add(" O ");
        back.add("   ");
        return;
    }

    private void addLastWrong(List<String> front, List<String> back) {
        front.add(" X ");
        back.add("   ");
        return;
    }

    private List<String> getBridgeListWithString(List<String> bridge, String s, int position) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < position; i++) {
            if (bridge.get(i).equals(s)) {
                list.add(" O ");
            }
            if (!bridge.get(i).equals(s)) {
                list.add("   ");
            }
        }

        return list;
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSuccess, int totalTry) {
        String success = getSuccessName(isSuccess);

        System.out.println("게임 성공 여부: " + success);
        System.out.println("총 시도한 횟수: " + totalTry);
    }

    private String getSuccessName(boolean isSuccess) {
        if(isSuccess)
            return "성공";
        return "실패";
    }
}
