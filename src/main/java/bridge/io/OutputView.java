package bridge.io;

public class OutputView {

    public static StringBuilder UPPER_BRIDGE_RESULT;
    public static StringBuilder LOWER_BRIDGE_RESULT;
    public static String START_RESULT = "[ ";
    public static String END_RESULT = " ]";
    public static String DIVIDE_RESULT = " | ";

    public static void setupBridgeProgress() {
        UPPER_BRIDGE_RESULT = new StringBuilder();
        LOWER_BRIDGE_RESULT = new StringBuilder();
    }

    public static void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public static void printGetBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void printGetBridgeCourse() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void printMap() {
        final int length = UPPER_BRIDGE_RESULT.length();
        System.out.println(START_RESULT + UPPER_BRIDGE_RESULT.substring(0, length - 3) + END_RESULT);
        System.out.println(START_RESULT + LOWER_BRIDGE_RESULT.substring(0, length - 3) + END_RESULT);
    }

    public static void printMap(final String course, final boolean result) {
        final String OX = checkResult(result);
        addResult(course, OX);
        printMap();
    }

    private static String checkResult(final boolean result) {
        if (result) {
            return "O";
        }
        return "X";
    }

    private static void addResult(final String course, final String OX) {
        if (course.equals("U")) {
            UPPER_BRIDGE_RESULT.append(OX).append(DIVIDE_RESULT);
            LOWER_BRIDGE_RESULT.append(" ").append(DIVIDE_RESULT);
            return;
        }
        UPPER_BRIDGE_RESULT.append(" ").append(DIVIDE_RESULT);
        LOWER_BRIDGE_RESULT.append(OX).append(DIVIDE_RESULT);
    }

    public static void printGetRestartCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public static void printResult(final String isSucceed, final int tries) {
        System.out.println("\n최종 게임 결과");
        printMap();
        final String result = String.format("\n게임 성공 여부: %s\n총 시도한 횟수: %d", isSucceed, tries);
        System.out.println(result);
    }
}
