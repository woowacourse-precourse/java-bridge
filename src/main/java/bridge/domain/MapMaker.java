package bridge.domain;

import bridge.Constants;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapMaker {
    private static final String LINE_CHANGE = "\n";

    public String makeMap(List<String> moves, boolean isFail) {
        List<String> upperMap = partialMap(moves, isFail, Constants.CODE_UP);
        List<String> lowerMap = partialMap(moves, isFail, Constants.CODE_DOWN);

        return MapFlag.START.flag() + String.join(MapFlag.JOIN.flag(), upperMap) + MapFlag.END.flag() + LINE_CHANGE +
                MapFlag.START.flag() + String.join(MapFlag.JOIN.flag(), lowerMap) + MapFlag.END.flag() + LINE_CHANGE;
    }

    private List<String> partialMap(List<String> moves, boolean isFail, String code) {
        return IntStream.range(0, moves.size()).mapToObj(index -> {
            if (isFail && index == moves.size() - 1 && moves.get(index).equals(code)) {
                return MapFlag.MOVE_FAIL.flag();
            }
            if (moves.get(index).equals(code)) {
                return MapFlag.MOVE_SUCCESS.flag();
            }
            return MapFlag.MOVE_EMPTY.flag();
        }).collect(Collectors.toList());
    }
}
