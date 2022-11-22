package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void startMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Map> mapResult) {
        printUpper(mapResult);
        printDown(mapResult);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<Map> mapResult) {
        System.out.println("최종 게임 결과");
        printMap(mapResult);

        System.out.println("게임 성공 여부: " );
        System.out.println("총 시도한 횟수: " );
    }

    private void printUpper(List<Map> mapResult) {
        System.out.print("[ ");
        for (int i = 0; i < mapResult.size(); i++) {
            if (i == mapResult.size()-1) {
                System.out.print(mapResult.get(i).getUpper() + " ]");
                return;
            }
            System.out.print(mapResult.get(i).getUpper() + " | ");
        }
    }

    private void printDown(List<Map> mapResult) {
        System.out.print("[ ");
        for (int i = 0; i < mapResult.size(); i++) {
            if (i == mapResult.size()-1) {
                System.out.print(mapResult.get(i).getDown() + " ]");
                return;
            }
            System.out.print(mapResult.get(i).getDown() + " | ");
        }
    }
}
