package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> up_bridge, List<String> down_bridge) {
        printPresentBridge(up_bridge);
        printPresentBridge(down_bridge);
    }

    private void printPresentBridge(List<String> down_bridge) {
        System.out.print("[ ");
        for (int i = 0;i<BridgeMaker.bridge_index;i++){
            System.out.print(down_bridge.get(i));
            if (i!=BridgeMaker.bridge_index-1){
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> up_bridge, List<String> down_bridge, int result) {
        System.out.println("최종 게임 결과");
        printMap(up_bridge,down_bridge);
        if (result == 1){
            System.out.println("\n게임 성공 여부: 성공");
        }
        if (result == 0){
            System.out.println("\n게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + BridgeGame.try_count);
    }
}
