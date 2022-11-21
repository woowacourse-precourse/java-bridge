package bridge;

import java.util.List;

public class OutputView {

    public void printGameStartContext() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printInputBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
    }

    public void printInputMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printInputGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printMap(List<String> movingResult) {
        for (String result : movingResult) {
            System.out.println(result);
        }
    }

    public void printFinalMap(List<String> movingResult) {
        System.out.println("\n최종 게임 결과");
        for (String result : movingResult) {
            System.out.println(result);
        }
    }

    private void printSuccessStatus(boolean status) {
        if (status) {
            System.out.println("\n게임 성공 여부: 성공");
            return;
        }
        System.out.println("\n게임 성공 여부: 실패");
    }

    private void printTryCount(int gameProceedCount) {
        System.out.printf("총 시도한 횟수: %d\n", gameProceedCount);
    }

    public void printResult(boolean status, int gameProceedCount) {
        printSuccessStatus(status);
        printTryCount(gameProceedCount);
    }
}
