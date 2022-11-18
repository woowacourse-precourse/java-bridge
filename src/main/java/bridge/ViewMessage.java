package bridge;

public class ViewMessage {
    public static void printGameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public static void printBridgeSizeInputRequest() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void printMovingInputRequest() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
}
