package bridge.view;

import bridge.constant.Messages;
import bridge.domain.Movement;

public class OutputView {

    public static void printMap(Movement movement) {
        String[] map = movement.getMap();
        for (String s : map) {
            System.out.println("[ "+s+" ]");
        }
    }

    public static void printResult(Movement movement) {
        System.out.println(Messages.FINISH_RESULT_MESSAGE.getMessage());
        printMap(movement);
        System.out.println(String.format(Messages.SUCCESS_INFO_MESSAGE.getMessage(), movement.isSuccess()));
        System.out.println(String.format(Messages.TRY_COUNT_INFO_MESSAGE.getMessage(), movement.getTryCount()));
    }
}
