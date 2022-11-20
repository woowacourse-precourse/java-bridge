package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeRecord {
    private static List<String> record = new ArrayList<>();

    public static void addUserInput(String userInput) {
        record.add(userInput);
    }

    public static void resetRecord() {
        record.clear();
    }

    public static List<String> getRecord() {
        return record;
    }
}
