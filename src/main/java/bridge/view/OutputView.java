package bridge.view;

public class OutputView {

    public static void askBridgeLength() {
        printGameStart();
        printMessage("다리의 길이를 입력해주세요.");
    }

    public static void askMovingCommand() {
        printMessage("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void askRestartCommand() {
        printMessage("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public static void printMap(String message) {
        printMessage(message);
    }

    public static void printResult(String path, int countOfAttempt, boolean isGameClear) {
        String result = "성공";
        if (!isGameClear)
            result = "실패";

        printMessage("최종 게임 결과");
        printMap(path);
        printMessage(String.format("게임 성공 여부: %s", result));
        printMessage(String.format("총 시도한 횟수: %d", countOfAttempt));
    }

    private static void printGameStart() {
        printMessage("다리 건너기 게임을 시작합니다.");
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
