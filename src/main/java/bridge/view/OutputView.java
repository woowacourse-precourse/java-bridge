package bridge.view;

public class OutputView {
    public void printStartBridgeGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeLengthQuestion() {
        System.out.println("\n다리의 길이를 입력해주세요");
    }

    public void printMoveUpOrDown() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRestartOrQuit() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printMap(StringBuilder upBuilder, StringBuilder downBuilder) {
        System.out.println(upBuilder);
        System.out.println(downBuilder);
    }
}