package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public interface Crossable {
    final List<String> bridge = new ArrayList<>();

    String get(int index);
}
