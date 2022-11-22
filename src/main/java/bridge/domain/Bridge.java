package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bridge {
    private static final List<Command> bridge = new ArrayList<>();

    public static void setBridge(List<String> bridge) {
        for (String command : bridge) {
            if (command.equals(Command.UP.getString())) {
                Bridge.bridge.add(Command.UP);
            } else if (command.equals(Command.DOWN.getString())) {
                Bridge.bridge.add(Command.DOWN);
            }
        }
    }

    public static List<Command> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

}
