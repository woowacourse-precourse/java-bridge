package bridge.Domain;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class TryCount {
    private static Map<Integer, TryCount> totalcount = new HashMap<>();
    private Integer count;

    static {
        for (int i = 1; i <= 20; i++) {
            totalcount.put(i, new TryCount(i));
        }
    }

    private TryCount(Integer count) {
        this.count = count;
    }

    public static TryCount valueOf(Integer count) {
        return totalcount.get(count);
    }

    public static List<TryCount> getTryCount() {
        return IntStream.rangeClosed(1, 20)
                .mapToObj(TryCount::valueOf)
                .collect(toList());
    }

    public static TryCount firstTry() {
        return totalcount.get(1);
    }

    public static List<TryCount> countWithBridgeSize(int size) {
        return IntStream.rangeClosed(1, size)
                .mapToObj(TryCount::valueOf)
                .collect(toList());
    }

    public TryCount passNextCount() {
        return totalcount.getOrDefault(this.count + 1, this);
    }

}
