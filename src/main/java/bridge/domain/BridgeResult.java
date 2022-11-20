package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.join;

public class BridgeResult {

    private static final String BLANK = " ";
    private static final String PARTITION = " | ";

    private final List<String> upperLine = new ArrayList<>();
    private final List<String> lowerLine = new ArrayList<>();

    public void addResult(MovingResult movingResult) {
        if(movingResult.getBridgeBlock().equals(BridgeBlock.U)) {
            upperLine.add(movingResult.getState());
            lowerLine.add(BLANK);
        }
        if(movingResult.getBridgeBlock().equals(BridgeBlock.D)) {
            upperLine.add(BLANK);
            lowerLine.add(movingResult.getState());
        }
    }

    public String upperMapToString() {
        return getJoin(upperLine);
    }

    public String lowerMapToString() {
        return getJoin(lowerLine);
    }

    public void clearMap(){
        upperLine.clear();
        lowerLine.clear();
    }

    private String getJoin(List<String> shapeMap) {
        return join(PARTITION, shapeMap);
    }

}
