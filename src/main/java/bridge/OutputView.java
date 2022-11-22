package bridge;

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

    public void printRestartMessage() {
        System.out.print("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printMap(ArrayList<String> bridge, int nowOn, String lastInput) {
        StringBuilder upMap = new StringBuilder("[");
        StringBuilder downMap = new StringBuilder("[");
        makePreviousUpMap(bridge, nowOn, upMap);
        makePreviousDownMap(bridge, nowOn, downMap);
        upMap.append(makeNowMap(bridge.get(nowOn), lastInput, BridgeJoyStick.U));
        downMap.append(makeNowMap(bridge.get(nowOn), lastInput, BridgeJoyStick.D));
        String lastText = upMap.append("]\n").toString() + downMap.append("]\n").toString();
        System.out.print(lastText);
        return lastText;
    }


    public String makeNowMap(String nowBridgeValue, String lastInput, BridgeJoyStick bridgeJoyStick) {
        String key = bridgeJoyStick.toString();
        if (lastInput.equals(key) && nowBridgeValue.equals(key)) {
            return " O ";
        }
        if (lastInput.equals(key) && (!(nowBridgeValue.equals(key)))) {
            return " X ";
        }
        return "   ";
    }

    public void makePreviousUpMap(ArrayList<String> bridge, int nowOn, StringBuilder upMap) {
        for (int i = 0; i < nowOn; i++) {
            String block = " ";
            if (bridge.get(i).equals(BridgeJoyStick.U.toString()))
                block = "O";
            upMap.append(" " + block + " ");
            if (i <= nowOn - 1)
                upMap.append("|");
        }
    }

    public void makePreviousDownMap(ArrayList<String> bridge, int nowOn, StringBuilder downMap) {
        for (int i = 0; i < nowOn; i++) {
            String block = " ";
            if (bridge.get(i).equals(BridgeJoyStick.D.toString()))
                block = "O";
            downMap.append(" " + block + " ");
            if (i <= nowOn - 1)
                downMap.append("|");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int tryNumber, String lastText, boolean win) {
        System.out.print("최종 게임 결과\n");
        System.out.print(lastText);
        String resultMessage = "게임 성공 여부: 실패";
        if (win)
            resultMessage = resultMessage.replace("실패", "성공");
        System.out.println(resultMessage);
        System.out.print("총 시도한 횟수: " + tryNumber);
    }
}
