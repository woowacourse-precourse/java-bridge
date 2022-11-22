package bridge.view;

import bridge.MapMaker;

import static bridge.view.MapView.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    static Message message;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(MapMaker mapMaker) {
        for (String map : mapMaker.printMap())
            System.out.println(map);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(MapMaker mapMaker, boolean result, int count) {
        System.out.println(message.GAME_RESULT);
        printMap(mapMaker);
        String output = String.valueOf(message.OUTPUT_SUCCESS);
        if (result) {
            output = String.valueOf(message.OUTPUT_NOT);
        }
        System.out.println(message.OUTPUT_SUCCESS_OR_NOT + output);
        System.out.print(message.OUTPUT_NUMBER_OF_ATTEMPTS);
        System.out.println(count);
    }


    public static void showStartMessage() {
        System.out.println(Message.GAME_START);
    }

    public static void showInputBridgeLength() {
        System.out.println(Message.INPUT_BRIDGE_LENGTH);
    }

    public static void showInputMove() {
        System.out.println(Message.INPUT_MOVE);
    }

    public static void showGameStatus() {
        System.out.println(Message.GAME_STATUS);
    }

}
