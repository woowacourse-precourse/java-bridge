package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    BridgePlayerCheck bridgePlayerCheck;

    public OutputView() {
        bridgePlayerCheck = new BridgePlayerCheck();
    }

    /**
     * 게임 시작 메세지를 출력한다.
     */
    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(List<String> bridge, List<String> player) {
        //상단 다리 출력
        printSingleMap(bridge, player, "U");
        //하단 다리 출력
        printSingleMap(bridge, player, "D");
    }

    /**
     * 현재까지 이동한 다리 하나의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printSingleMap(List<String> bridge, List<String> player, String upDown) {
        System.out.print("[ ");
        for (int s = 0; s < player.size(); s++) {
            boolean isO = bridgePlayerCheck.isO(bridge.get(s), player.get(s), upDown);
            boolean isX = bridgePlayerCheck.isX(bridge.get(s), player.get(s), upDown);

            if (isO) System.out.print("O ");
            if (isX) System.out.print("X ");
            if (!isO && !isX) System.out.print("  ");
            if (s != player.size() -1) System.out.print("| ");
        }
        System.out.println("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult() {
        System.out.println("최종 게임 결과");
    }

    public void printSuccessOrFail(boolean isSuccess) {
        if (isSuccess) {
            System.out.println("게임 성공 여부: 성공");
            return;
        }
        System.out.println("게임 성공 여부: 실패");
    }

    public void printTryCount(int tryCount) {
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}
