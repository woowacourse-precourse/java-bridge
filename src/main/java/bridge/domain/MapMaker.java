package bridge.domain;

import bridge.Constants;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapMaker {
    private static final String CHANGE_LINE = "\n";

    public String makeMap(List<String> moves, boolean isFail) {
        List<String> upperMap = partialMap(moves, isFail, Constants.CODE_UP);
        List<String> lowerMap = partialMap(moves, isFail, Constants.CODE_DOWN);

        return MapFlag.START.code() + String.join(MapFlag.JOIN.code(), upperMap) + MapFlag.END.code() + CHANGE_LINE +
                MapFlag.START.code() + String.join(MapFlag.JOIN.code(), lowerMap) + MapFlag.END.code() + CHANGE_LINE;
    }

    private List<String> partialMap(List<String> moves, boolean isFail, String code) {
        return IntStream.range(0, moves.size()).mapToObj(index -> {
            if (isFail && index == moves.size() - 1 && moves.get(index).equals(code)) {
                return MapFlag.MOVE_FAIL.code();
            }
            if (moves.get(index).equals(code)) {
                return MapFlag.MOVE_SUCCESS.code();
            }
            return MapFlag.MOVE_EMPTY.code();
        }).collect(Collectors.toList());
    }
}
