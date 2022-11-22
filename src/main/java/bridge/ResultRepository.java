package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultRepository {

    private OutputView outView = new OutputView();
    private List<String> aboveOfBridgeResult;
    private List<String> belowOfBridgeResult;

    private final int FRISTMOVING = 1;
    private final String BEGINNINGOFBRIDGE = "[ ";
    private final String ENDOFBRIDGE = " ]";
    private final String DIVISIONOFBRIDGE = " | ";

    public ResultRepository() {
        this.aboveOfBridgeResult = new ArrayList<>(List.of(BEGINNINGOFBRIDGE, ENDOFBRIDGE));
        this.belowOfBridgeResult = new ArrayList<>(List.of(BEGINNINGOFBRIDGE, ENDOFBRIDGE));
    }

    public void saveResult(Map<String, String> movingResult, int numberOfMoving) {
        if (numberOfMoving > FRISTMOVING) {
            aboveOfBridgeResult.add(aboveOfBridgeResult.size() - 1, DIVISIONOFBRIDGE);
            belowOfBridgeResult.add(belowOfBridgeResult.size() - 1, DIVISIONOFBRIDGE);
        }
        aboveOfBridgeResult.add(aboveOfBridgeResult.size() - 1, movingResult.get(BridgeDirection.UP.getDirection()));
        belowOfBridgeResult.add(belowOfBridgeResult.size() - 1, movingResult.get(BridgeDirection.DOWN.getDirection()));

        outView.printMap(aboveOfBridgeResult, belowOfBridgeResult);
    }
}
