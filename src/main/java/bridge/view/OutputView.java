package bridge.view;

public class OutputView {
    public void printStartBridgeGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeLengthQuestion() {
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요");
    }

    public void printMoveToWhereQuestion() {
        System.out.println();
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRestartOrDoneQuestion() {
        System.out.println();
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printMap(StringBuilder upBridge, StringBuilder downBridge) {
        System.out.println(upBridge);
        System.out.println(downBridge);
    }

    public void printResult(StringBuilder upBridge, StringBuilder downBridge) {
        System.out.println();
        System.out.println("최종 게임 결과");
        printMap(upBridge, downBridge);
    }

    public void printSuccessOrDefeat(boolean successOrDefeat) {
        System.out.println();
        if (successOrDefeat) {
            System.out.println("게임 성공 여부: " + "성공");
            return;
        }
        System.out.println("게임 성공 여부: " + "실패");
    }

    public void printPlayerTryCount(int count) {
        System.out.println("총 시도한 횟수: " + count);
    }
}
