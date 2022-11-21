package bridge;

import java.util.Arrays;
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
        // stage길이 만큼 bridge 출력 2개의 배열 생성
        BridgeGame bridgeGame = new BridgeGame();

        List<String> upperBridge = bridgeGame.createUpperBridge(bridge);
        List<String> bottomBridge = bridgeGame.createBottomBridge(bridge);
        int stageIndex = stage * 2;
        upperBridge.set(stageIndex, "]");
        bottomBridge.set(stageIndex, "]");

        if (status == 1) {
            if (upperBridge.get(stageIndex - 1).equals(" O ")) {
                upperBridge.set((stageIndex-1), "   ");
                bottomBridge.set((stageIndex-1), " X ");
            }
            if (bottomBridge.get(stageIndex - 1).equals(" O ")) {
                bottomBridge.set((stageIndex-1), "   ");
                upperBridge.set((stageIndex-1), " X ");
            }
            for (int i = 0; i <= stageIndex; i++) {
                System.out.print(upperBridge.get(i));
            }
            System.out.println();
            for (int i = 0; i <= stageIndex; i++) {
                System.out.print(bottomBridge.get(i));
            }
        }


        if (status == 0) {
            for (int i = 0; i <= stageIndex; i++) {
                System.out.print(upperBridge.get(i));
            }
            System.out.println();
            for (int i = 0; i <= stageIndex; i++) {
                System.out.print(bottomBridge.get(i));
            }
        }



    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println("최종 게임 결과");
    }


    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeSizeInput() {
        System.out.println("다리의 길이를 입력해주세요.");
    }
    public void printMovingInput() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    public void printGameOver() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
    public void printSuccess(int success) {
        String result = "";
        if (success == 1){
            System.out.println("게임 성공 여부: 성공");
        } else {
            System.out.println("게임 성공 여부: 실패");
        }
    }
    public void printTrialAmount(int trial) {
        System.out.println("총 시도한 횟수: " + trial);
    }

    public void printNotMovable() {

    }

    public void printMovable (){

    }


}
