package bridge.domain;

import bridge.utils.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EachSideResult {
    private final List<String> sideResults;

    public EachSideResult() {
        this.sideResults = new ArrayList<>();
    }

    public void append(String sideResult) {
        this.sideResults.add(sideResult);
    }

    @Override
    public String toString() {
        return sideResults.stream()
                .collect(Collectors
                        .joining(Constants.MAP_DELIMITER, Constants.MAP_PREFIX, Constants.MAP_SUFFIX));
    }
}
