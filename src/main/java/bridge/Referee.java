package bridge;

import static bridge.command.MoveCommand.DOWN;
import static bridge.command.MoveCommand.UP;

import bridge.command.MoveCommand;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Referee {
    private final Bridge bridge;
    private final List<String> current;

    Referee(Bridge bridge, List<String> current) {
        this.bridge = bridge;
        this.current = current;
    }

    public List<List<String>> analyze() {
        Map<MoveCommand, List<String>> result = new EnumMap<>(MoveCommand.class);
        for (int i = 0; i < current.size(); i++) {
            setLines(result, i);
        }
        return Arrays.asList(result.get(UP), result.get(DOWN));
    }

    private void setLines(Map<MoveCommand, List<String>> result, int index) {
        String symbol = setSymbol(index);
        String currentItem = current.get(index);
        for (MoveCommand moveCommand : Arrays.asList(UP, DOWN)) {
            List<String> item = result.getOrDefault(moveCommand, new ArrayList<>());
            item.add(setItem(moveCommand, symbol, currentItem));
            result.put(moveCommand, item);
        }
    }

    private String setSymbol(int index) {
        String symbol = "X";
        if (bridge.isStepSuccess(current.get(index), index)) {
            symbol = "O";
        }
        return symbol;
    }

    private String setItem(MoveCommand moveCommand, String symbol, String currentItem) {
        if (currentItem.equals(moveCommand.ofHotKey())) {
            return symbol;
        }
        return " ";
    }

}