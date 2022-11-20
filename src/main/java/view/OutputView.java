package view;

import constants.BridgeConstant;
import constants.ResultTable;
import constants.TableAccessor;
import controller.MapConverter;
import model.GameResult;

public class OutputView {
    public static void printRunGameText() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("");
    }

    public static void printGameResult(GameResult gameResult) {
        printExceededAttempt(gameResult.getResultNumber());
        printResultText();
        printMap(MapConverter.convertMap(gameResult.getUserMap()));
        printResult(gameResult.getResultNumber());
        printCountOfAttempt(gameResult.getCountOfAttempt());
    }

    private static void printExceededAttempt(int resultNumber) {
        if (resultNumber == ResultTable.END.getResultNumber()) {
            System.out.println("가능한 시도 횟수를 초과하여 게임을 종료합니다.");
        }
    }

    private static void printResultText() {
        System.out.println("최종 게임 결과");
    }

    public static void printMap(String[][] userMap) {
        for (int row = BridgeConstant.BRIDGE_WIDTH - 1; row >= 0; row--) {
            System.out.print("[ ");
            for (int column = 0; column < userMap[0].length - 1; column++) {
                System.out.print(String.format("%s | ", userMap[row][column]));
            }
            System.out.println(String.format("%s ]", userMap[row][userMap[0].length - 1]));
        }
        System.out.println("");
    }

    private static void printResult(int resultNumber) {
        String resultText = ResultTable.valueOf(TableAccessor.resultTableAccessor.get(resultNumber)).getResultText();
        System.out.println(String.format("게임 성공 여부: %s", resultText));
    }

    private static void printCountOfAttempt(int countOfAttempt) {
        System.out.print(String.format("총 시도한 횟수: %,d", countOfAttempt));
    }
}
