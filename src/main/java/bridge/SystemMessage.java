package bridge;

/**
 * 시스템 메시지를 출력하는 역할을 한다.
 */
public class SystemMessage {
    public void start() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    public void getBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void getMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void blankLine() {
        System.out.println();
    }

    public void error(String message) {
        System.out.println("[ERROR] " + message);
    }
}
