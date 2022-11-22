package bridge.view;

import bridge.domain.*;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_WITH = "[ ";
    private static final String END_WITH = " ]";
    private static final String SEPARATOR = " | ";

    public static void printWelcome() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public static void printGame(GameResult gameResult) {
        GameProgress nowProgress = gameResult.getProgress();
        if (nowProgress == GameProgress.PLAYING) {
            printMap(nowProgress, gameResult.getBridge());
        }
        if (nowProgress == GameProgress.SUCCESS || nowProgress == GameProgress.FAILURE) {
            System.out.println("최종 게임 결과");
            printMap(nowProgress, gameResult.getBridge());
            printResult(nowProgress, gameResult.getNumberOfAttempts());
        }
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static String printMap(GameProgress progress, Bridge bridge) {
        List<String> rawBridge = bridge.getBridge();

        String firstRow = makeAndPrintRow(progress, rawBridge, Move.UP.getDirection());
        String secondRow = makeAndPrintRow(progress, rawBridge, Move.DOWN.getDirection());

        return firstRow + '\n' + secondRow;
    }

    private static String makeAndPrintRow(GameProgress progress, List<String> bridge, String direction) {
        String row = "";

        row = bridgeToRow(bridge, direction);  // 한줄씩 다리에 대한 String 제작
        if (progress == GameProgress.FAILURE) {  // 실패한 게임의 경우 마지막 글자를 X로 변경
            row = replaceFailedStep(row);
        }
        row = setMapFormat(row);  // 지정된 포맷으로 변환

        System.out.println(row);  // 정제된 결과를 출력
        return row;
    }

    private static String bridgeToRow(List<String> bridge, String direction) {
        String row = "";
        for (String upDown : bridge) {
            if (upDown.equals(direction)) {
                row += Block.GOOD.gerWord();
            }
            if (!upDown.equals(direction)) {
                row += Block.BLANK.gerWord();
            }
        }
        return row;
    }

    private static String replaceFailedStep(String row) {
        int rowLength = row.length();
        if (row.charAt(rowLength - 1) == Block.GOOD.gerWord().charAt(0)) {
            row = row.substring(0, rowLength - 1) + Block.BAD.gerWord();
        }
        return row;
    }

    private static String setMapFormat(String row) {
        return START_WITH + String.join(SEPARATOR, row.split("")) + END_WITH;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(GameProgress progress, int attempt) {
        System.out.println("게임 성공 여부: " + progress.getProgress());
        System.out.println("총 시도한 횟수: " + attempt);
    }

    public static void printErrorMessage(String e) {
        System.out.println("[ERROR]" + e);
    }
}
