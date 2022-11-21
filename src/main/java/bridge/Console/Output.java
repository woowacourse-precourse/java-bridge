package bridge.Console;

import java.util.List;
import java.util.Map;

public interface Output {
    public void printMap(Map<String, List<String>> result);
    public void printResult(boolean isSuccess, Integer count);

}
