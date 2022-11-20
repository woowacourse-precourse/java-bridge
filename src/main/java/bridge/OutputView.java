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
    public void printMap(List<String> bridge, int coordinate, boolean isDirectionanAndLocationSame) {
        printFirstLine(bridge, coordinate, isDirectionanAndLocationSame);
        printSecondLine(bridge, coordinate, isDirectionanAndLocationSame);
    }

    public void printFirstLine(List<String> bridge, int coordinate, boolean isDirectionAndLocationSame) {
        printStartPart();
        printMiddlePart(bridge, coordinate, "U");
        printEndPart(bridge, isDirectionAndLocationSame, coordinate, "U");
    }

    public void printSecondLine(List<String> bridge, int coordinate,boolean isDirectionAndLocationSame) {
        printStartPart();
        printMiddlePart(bridge, coordinate, "D");
        printEndPart(bridge, isDirectionAndLocationSame, coordinate, "D");
    }


    private void printStartPart() {
        System.out.print("[ ");
    }

    private void printMiddlePart(List<String> bridge, int coordinate, String direction) {
        for (int i = -1; i <= coordinate; i ++) {
            if (i == -1) continue;
            if (bridge.get(i).equals(direction)) {
                System.out.print("O | ");
            }
            if(!bridge.get(i).equals(direction)) {
                System.out.print("  | ");
            }
        }
    }

    private void printEndPart(List<String> bridge, boolean isDirectionAndLocationSame, int coordinate, String direction) {
        if (bridge.get(coordinate+1).equals(direction)) {
            if (isDirectionAndLocationSame == true) {
                System.out.println("O ]");
            }
            if (isDirectionAndLocationSame == false) {
                System.out.println("X ]");
            }
        }
        if (!bridge.get(coordinate+1).equals(direction)) {
            System.out.println("  ]");
        }
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int trialNumber, int coordinate, int bridgeSize, boolean doesPlayerRetry) {
        if (coordinate == bridgeSize) {
            System.out.println("게임 성공 여부: 성공");
            System.out.println(("총 시도한 횟수: " + trialNumber));
        }
        if (doesPlayerRetry == false) {
            System.out.println("게임 성공 여부: 실패");
            System.out.println("총 시도한 횟수: " + trialNumber);
        }
    }
}
