package bridge.view;

import bridge.message.Message;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> upRecord, List<String> downRecord) {
        printUpBridge(upRecord);
        printDownBridge(downRecord);
    }

    private static void printUpBridge(List<String> upRecord) {
        System.out.print(Message.START_MAP.getMessage());
        printBridge(upRecord);
        System.out.println(Message.END_MAP.getMessage());
    }

    private static void printDownBridge(List<String> downRecord) {
        System.out.print(Message.START_MAP.getMessage());
        printBridge(downRecord);
        System.out.println(Message.END_MAP.getMessage());
    }

    private static void printBridge(List<String> record) {
        for (int position = 0; position < record.size(); position++) {
            splitBridge(position);
            System.out.print(record.get(position));
        }
    }

    private static void splitBridge(int position) {
        if (position != 0) {
            System.out.print(Message.SPLIT_MAP.getMessage());
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(int tryNumber, boolean gameSuccessOrFail) {
        if (gameSuccessOrFail) {
            System.out.println(Message.GAME_SUCCESS.getMessage());
        }
        if (!gameSuccessOrFail) {
            System.out.println(Message.GAME_FAIL.getMessage());
        }
        System.out.println(Message.TRY_NUMBER.getMessage() + tryNumber);

    }
}