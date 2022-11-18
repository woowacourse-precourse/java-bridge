package bridge;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printStart() {
        System.out.print("다리 건너기 게임을 시작합니다.\n");
    }

    public void printInputBridgeLength() {
        System.out.print("다리의 길이를 입력해주세요.\n");
    }

    public void printMoveBridge() {
        System.out.print("이동할 칸을 선택해주세요. (위: U, 아래: D)\n");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(ArrayList<String> bridge, int nowOn, String lastInput) {
        StringBuilder upMap = new StringBuilder("[");
        StringBuilder downMap = new StringBuilder("[");
        makePreviousUpMap(bridge, nowOn, upMap);
        makePreviousDownMap(bridge, nowOn, downMap);
        if (nowOn != bridge.size()) {
            makeNowUpMap(bridge, lastInput, upMap);
            makeNowDownMap(bridge, lastInput, downMap);
        }
        System.out.print(upMap.append("]\n").toString());
        System.out.print(downMap.append("]\n").toString());
    }


    public void makeNowUpMap(ArrayList<String> bridge, String lastInput, StringBuilder upMap) {
        if (lastInput.equals("U") && bridge.get(bridge.size() - 1).equals("U")) {
            upMap.append(" O ");
            return;     //마지막 입력 윗다리 값 일치
        }
        if (lastInput.equals("U") && (!(bridge.get(bridge.size() - 1).equals("U")))) {
            upMap.append(" X ");
            return; //마지막 입력 윗다리 값 불일치
        }
        upMap.append("   ");
    }

    public void makeNowDownMap(ArrayList<String> bridge, String lastInput, StringBuilder downMap) {
        if (lastInput.equals("D") && bridge.get(bridge.size() - 1).equals("D")) {
            downMap.append(" O ");
            return;     //마지막 입력 윗다리 값 일치
        }
        if (lastInput.equals("D") && (!(bridge.get(bridge.size() - 1).equals("D")))) {
            downMap.append(" X ");
            return; //마지막 입력 윗다리 값 불일치
        }
        downMap.append("   ");
    }

    public void makePreviousUpMap(ArrayList<String> bridge, int nowOn, StringBuilder upMap) {
        for (int i = 0; i < nowOn; i++) {
            String block = " ";
            if (bridge.get(i).equals(BridgeJoyStick.U.toString()))
                block = "O";
            upMap.append(block);
            upMap.append("|");
        }
    }

    public void makePreviousDownMap(ArrayList<String> bridge, int nowOn, StringBuilder upMap) {
        for (int i = 0; i < nowOn; i++) {
            String block = " ";
            if (bridge.get(i).equals(BridgeJoyStick.D.toString()))
                block = "O";
            upMap.append(block);
            upMap.append("|");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int tryNumber,ArrayList<String> bridge,boolean win) {
        System.out.print("최종 게임 결과\n");
        printMap(bridge,bridge.size(),"");
        System.out.println("");
        String resultMessage = "게임 성공 여부: 실패";
        if(win)
            resultMessage = resultMessage.replace("실패","성공");
        System.out.print(resultMessage);
        System.out.print("총 시도한 횟수: "+tryNumber);
    }
}
