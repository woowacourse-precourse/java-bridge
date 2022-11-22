package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    final static int MAX_BRIDGE_SIZE = 20;
    private int count = 0;

    private String bridge = "";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printMap(List<String> yesOrNo, List<String> upAndDown, int size) {
        StringBuilder upBridge = new StringBuilder();
        StringBuilder downBridge = new StringBuilder();


        if(yesOrNo.get(0).equals("O") && upAndDown.get(0).equals("U")) {
            upBridge.append("[ O ]");
            downBridge.append("[   ]");
        }
        if(yesOrNo.get(0).equals("O") && upAndDown.get(0).equals("D")) {
            upBridge.append("[   ]");
            downBridge.append("[ O ]" );
        }
        for(int i = 1; i < yesOrNo.size(); i++) {
            if(yesOrNo.get(i).equals("O") && upAndDown.get(i).equals("U")) {
                upBridge.setCharAt(3, '|');
                upBridge.insert(4, " O ]");
                downBridge.setCharAt(3, '|');
                downBridge.insert(4, "  ]");
            }
            if(yesOrNo.get(i).equals("O") && upAndDown.get(i).equals("D")) {
                upBridge.setCharAt(3, '|');
                upBridge.insert(4, "  ]");
                downBridge.setCharAt(3, '|');
                downBridge.insert(4, " O ]");
            }
        }

        upBridge.append(System.lineSeparator());
        upBridge.append(downBridge);
        this.bridge = upBridge.toString();
        return this.bridge;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> yesOrNo, String bridge) {
        System.out.println("최종 게임 결과");
        System.out.println(this.bridge);

        if(yesOrNo.contains("X")) {
            System.out.println("게임 성공 여부 : 실패");
        }
        if(!yesOrNo.contains("X")) {
            System.out.println("게임 성공 여부 : 성공");
        }
        System.out.printf("총 시도한 횟수: %d", this.count);
    }
}
