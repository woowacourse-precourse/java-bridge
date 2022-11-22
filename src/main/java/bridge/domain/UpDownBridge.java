package bridge.domain;

import bridge.messages.Message;

import java.util.ArrayList;
import java.util.List;

public class UpDownBridge {
    private static final List<String> upBridge = new ArrayList<>();
    private static final List<String> downBridge = new ArrayList<>();

    public static void makeUpDownBridge(String inputDirection, String moveResult) {
        addUpBridge(inputDirection, moveResult);
        nullBridge();
        addDownBridge(inputDirection, moveResult);
    }

    public static void initBridge() {
        upBridge.clear();
        downBridge.clear();
    }

    public static List<String> getUpBridge() {
        return upBridge;
    }

    public static List<String> getDownBridge() {
        return downBridge;
    }

    private static void addUpBridge(String inputDirection, String moveResult) {
        if (inputDirection.equals(Message.UP.getMessage())) {
            upBridge.add(moveResult);
            downBridge.add(Message.BLANK.getMessage());
        }
    }

    private static void addDownBridge(String inputDirection, String moveResult) {
        if (inputDirection.equals(Message.Down.getMessage())) {
            upBridge.add(Message.BLANK.getMessage());
            downBridge.add(moveResult);
        }
    }

    private static void nullBridge() {
        if (upBridge.isEmpty()) {
            throw new IllegalStateException(" 값이 없습니다. ");
        }
    }
}
