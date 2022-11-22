package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean printMap(String generatedBridgeStr, String currStr) {        // 현재 상황을 프린트한다.

        // 생성된 브릿지와 다르면 X를 넣고 재시작할 것인지 종료할 것인지 선택햐야한다.
        List<String> bridges = bridgeMaker.change(currStr); // [ O | O |  ].. 이런형태
        for (String bridge : bridges) {
            System.out.println(bridge);
        }

        boolean successOrFail = true;   // X가 있으면 실패니까 false 반환

        for (String bridge : bridges) {         // 한 개의 다리라도 X가 포함되어 있으면 실패 케이스
            if (bridge.contains("X")) {
                successOrFail = false;
                break;
            }
        }

        return successOrFail;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge) {
        System.out.println("최종 게임 결과");

        for (String b : bridge) {
            System.out.println(b);

        }
    }
}
