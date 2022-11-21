package bridge.view;

import bridge.constant.Messages;

import java.util.List;

public class OutputView {
    private static final String MAP_OPEN_MARK = "[ ";
    private static final String MAP_CLOSE_MARK = " ]";
    private static final String MAP_DELIMITER = " | ";

    public static void printMap(List<List<String>> maps) {
        for (List<String> map : maps) {
            System.out.println(MAP_OPEN_MARK + String.join(MAP_DELIMITER, map) + MAP_CLOSE_MARK);
        }
        System.out.println();
    }

    public static void printResult(List<List<String>> maps, String isSuccess, int tryCount) {
        System.out.println(Messages.FINISH_RESULT_MESSAGE.getMessage());
        printMap(maps);
        System.out.println(String.format(Messages.SUCCESS_INFO_MESSAGE.getMessage(), isSuccess));
        System.out.println(String.format(Messages.TRY_COUNT_INFO_MESSAGE.getMessage(), tryCount));
    }
}
