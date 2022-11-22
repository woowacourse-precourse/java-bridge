package bridge.view;

public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String ASK_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String ASK_NEXT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String ASK_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private String map;

    public void printStart() {
        System.out.println(GAME_START_MESSAGE + System.lineSeparator());
    }

    public void AskBridgeLength() {
        System.out.println(ASK_BRIDGE_LENGTH_MESSAGE);
    }

    public void AskNextMove() {
        System.out.println(System.lineSeparator() + ASK_NEXT_MOVE_MESSAGE);
    }

    public void AskRetry() {
        System.out.println(System.lineSeparator() + ASK_RETRY_MESSAGE);
    }

    public void printMap(String map) {
        this.map = map;
        System.out.println(map);
    }

    public void printResult(boolean isWin, String tryCount) {
        System.out.println("최종 게임 결과");
        System.out.println(map + System.lineSeparator());
        printIsWin(isWin);
        System.out.println("총 시도한 횟수: " + tryCount);
    }

    public void printError() {
        System.out.println("[ERROR] 잘못된 위치에서 메소드가 호출 되었습니다.");
    }

    private void printIsWin(boolean isWin) {
        if (isWin) {
            System.out.println("게임 성공 여부: 성공");
        }
        if (!isWin) {
            System.out.println("게임 성공 여부: 실패");
        }
    }
}
