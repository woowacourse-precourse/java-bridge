package bridge.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bridge {
    List<String> path;

    public Bridge(
            List<String> path
    ) {
        this.path = path;
    }

    public List<Integer> getAccessibleIndexes(String direction) {
        return IntStream.range(0, path.size())
                .filter(i -> path.get(i).equals(direction))
                .boxed().collect(Collectors.toList());
    }

    public int getDestinationIndex() {
        return path.size() - 1;
    }
}
