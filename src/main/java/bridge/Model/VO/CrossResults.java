package bridge.Model.VO;

import bridge.Enum.CrossResult;

import java.util.ArrayList;
import java.util.List;

public class CrossResults {
    List<CrossResult> crossResults;

    public CrossResults() {
        this.crossResults = new ArrayList<>();
    }

    public int position() {
        return crossResults.size();
    }

    public void appendResult(CrossResult crossResult) {
        crossResults.add(crossResult);
    }

    public boolean contain(CrossResult crossResult) {
        return crossResults.contains(crossResult);
    }

    public CrossResult get(int position) {
        return crossResults.get(position);
    }
}
