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
        List<String> bridges = bridgeMaker.changeStrToBridge(currStr); // [ O | O |  ].. 같은 형태
        printBridge(bridges);
        boolean successOrFail = true;
        for (String bridge : bridges) {
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
    public void printResult(List<String> bridge, boolean successYn, int gameCnt) {       // 게임 시도 횟수 추가
        System.out.println("최종 게임 결과");
        printBridge(bridge);
        System.out.print("게임 성공 여부: ");
        if(successYn){
            System.out.println("성공\n총 시도한 횟수: " + gameCnt );
            return;
        }
        System.out.println("실패\n총 시도한 횟수: "  + gameCnt );
    }

    public static void printBridge(List<String> bridge){
        for (String b : bridge) {
            System.out.println(b);
        }
    }
}
