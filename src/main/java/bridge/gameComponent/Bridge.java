package bridge.gameComponent;

import java.util.List;

public interface Bridge {
    List<String> getBridge();

    boolean isPossibleMove(int index, String upDown);
}
