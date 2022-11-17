package bridge.view;

import bridge.Bridge;

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
    public void printMap(Bridge bridge, int ongoing) {
        for (int i = 0; i< ongoing; i++) {
            printUpper(bridge, i);
        }
        System.out.println(" ]");
        for (int i = 0; i< ongoing; i++) {
            printLower(bridge, i);
        }
        System.out.println(" ]");
    }

    public void printUpper(Bridge bridge, int index) {
        if (index == 0) {
            System.out.print("[ ");
        }

        String upOrDown = bridge.returnCertainIndexUpOrDown(index);
        int bridgeLength = bridge.returnBridgeLength();

        if (upOrDown == "U" ) {
            if (index == bridgeLength-1) {
                System.out.print("O ");
                return;
            }
            System.out.print("O | ");
        } else {
            if (index == bridgeLength-1 ) {
                System.out.print("  ");
            } else {
                System.out.print("  | ");
            }
        }
//        if (index == bridgeLength-1) {
//            System.out.println("]");
//        }
    }

    public void printLower(Bridge bridge, int index) {
        if (index == 0) {
            System.out.print("[ ");
        }

        String upOrDown = bridge.returnCertainIndexUpOrDown(index);
        int bridgeLength = bridge.returnBridgeLength();

        if (upOrDown == "D" ) {
            if (index == bridgeLength-1) {
                System.out.print("O ");
                return;
            }
            System.out.print("O | ");
        } else {
            if (index == bridgeLength-1 ) {
                System.out.print("  ");
            } else {
                System.out.print("  | ");
            }
        }
//        if (index == bridgeLength-1) {
//            System.out.println("]");
//        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResultMap(Bridge bridge, int bridgeSize) {
        System.out.println("최종 게임 결과");
        for (int i = 0; i< bridgeSize; i++) {
            printUpper(bridge, i);
        }
        System.out.println("]");
        for (int i = 0; i< bridgeSize; i++) {
            printLower(bridge, i);
        }
        System.out.println("]");
    }

    public void printWinorLose(boolean pass) {
        String result = "";
        if (pass) {
            result = "성공" ;
        } else {
            result = "실패";
        };
        System.out.printf("게임 성공 여부: %s\n", result);
    }

    public void printTryNumbers(int tryNumber) {
        System.out.printf("총 시도한 횟수: %s", tryNumber);
    }
}
