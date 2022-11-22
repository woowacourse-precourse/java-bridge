package bridge.extensible;

import java.util.List;

public interface OutputView {

    void printMap(List<List<String>> map);

    void printResult(List<List<String>> map, String result, Integer retryCount);
}
