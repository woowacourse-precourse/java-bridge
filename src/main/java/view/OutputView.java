package view;

import java.util.List;


public class OutputView {

    public void printStart() {
        System.out.println(Message.START_GAME.getMessage());
    }

    public void printInputBridgeSize() {
        System.out.println(Message.BRIDGE_SIZE.getMessage());
    }

    public void printSelectMove() {
        System.out.println(Message.SELECT_MOVING.getMessage());
    }
    public void printMap(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public void printResult(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public void printReStart() {
        System.out.println(Message.RE_START.getMessage());
    }

    public void printGameResult() {
        System.out.println(Message.GAME_RESULT.getMessage());
    }

}
