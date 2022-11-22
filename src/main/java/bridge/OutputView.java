package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, int stage, int status) {
        BridgeGame bridgeGame = new BridgeGame();
        int stageIndex = stage * 2;
        List<List<String>> bothBridges = bridgeGame.createBridges(bridge, stageIndex);
        if (status == 1) {
            bridgeGame.moveSuccess(bothBridges, stageIndex);
            printBridge(bothBridges, stageIndex);
        }
        if (status == 0) {
            printBridge(bothBridges, stageIndex);
        }
    }

    public void printBridge(List<List<String>> bothBridges, int stageIndex) {
        for (int i = 0; i <= stageIndex; i++) {
            System.out.print(bothBridges.get(0).get(i));
        }
        System.out.println();
        for (int i = 0; i <= stageIndex; i++) {
            System.out.print(bothBridges.get(1).get(i));
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println();
        System.out.println();
        System.out.println("최종 게임 결과");
    }


    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeSizeInput() {
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
    }
    public void printMovingInput() {
        System.out.println();
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    public void printGameOver() {
        System.out.println();
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
    public void printSuccess(int success) {
        if (success == 1){
            System.out.printf("%n%n");
            System.out.println("게임 성공 여부: 성공");
        }
    }
    public void printFailure(int success) {
        if (success == 0){
            System.out.printf("%n%n");
            System.out.println("게임 성공 여부: 실패");
        }
    }
    public void printTrialAmount(int trial) {
        System.out.println("총 시도한 횟수: " + trial);
    }


}
