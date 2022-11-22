package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 게임 시작 문구를 출력한다.
     */
    public void printStartTitle() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        printCells(bridgeGame.getUpCells());
        printCells(bridgeGame.getDownCells());
        System.out.println();
    }

    private void printCells(List<String> cells) {
        System.out.print("[");
        for (int i=0;i<cells.size();i++){
            System.out.print(" " + cells.get(i) + " ");
            if (i < cells.size()-1){
                System.out.print("|");
            }
        }
        System.out.println("]");
    }

    public static String valueOfStatus(boolean status) {
        if (status) {
            return "성공";
        }
        return "실패";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
        System.out.println("게임 성공 여부: " + valueOfStatus(bridgeGame.isMovingStatus()));
        System.out.println("총 시도한 횟수: " + bridgeGame.getCount());
    }
}
