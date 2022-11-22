package bridge;

public class Message {
    public static void start() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public static void choiceMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void gameResult() {
        System.out.println("최종 게임 결과");
    }

    public static void blank() {
        System.out.println();
    }

    public static void gameFail() {
        System.out.println("게임 성공 여부: 실패");
    }

    public static void gameSuccess() {
        System.out.println("게임 성공 여부: 성공");
    }

    public static void tryCount(int gameCnt) {
        System.out.println("총 시도한 횟수: " + gameCnt);
    }

    public static void inputBridgeLength() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void inputTryOrQuit() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
