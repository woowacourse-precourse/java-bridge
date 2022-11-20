package bridge;

import static bridge.data.GameMark.BLANK;

public class PlayerMap {
    private final int bridgeVerticalSize = 2;
    private final String[][] playerMap;

    public void initPlayerMap(int bridgeSize) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < bridgeSize; j++) {
                playerMap[i][j] = BLANK.getMark();
            }
        }
    }
}
