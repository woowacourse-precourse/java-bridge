package bridge.model;

import java.util.List;
import java.util.stream.IntStream;

public class SuccessRoutValidator {

    public static boolean isSuccess(List<String> bridges, List<String> directions) {
        return IntStream.range(0, directions.size())
                .allMatch(index -> directions.get(index).equals(bridges.get(index)));
    }
}
