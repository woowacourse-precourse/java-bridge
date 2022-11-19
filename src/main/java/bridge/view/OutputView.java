package bridge.view;

import bridge.domain.Movement;
import bridge.constant.Messages;

public class OutputView {

    public static void printMap(String[] map) {
        for (String s : map) {
            System.out.println("[ "+s+" ]");
        }
    }
    public static void printResult(String[] map, Movement movement) {
        System.out.println(Messages.FINISH_RESULT_MESSAGE.getMessage());
        printMap(map);
        System.out.println(String.format(Messages.SUCCESS_INFO_MESSAGE.getMessage(), movement.isSuccess()));
        System.out.println(String.format(Messages.TRY_COUNT_INFO_MESSAGE.getMessage(), movement.getTryCount()));
    }
}
