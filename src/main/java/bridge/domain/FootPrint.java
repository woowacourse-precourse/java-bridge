package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class FootPrint {
    private List<FootrestLocation> footPrint;

    public FootPrint() {
        footPrint = new ArrayList<>();
    }

    public Integer getOrder() {
        return footPrint.size();
    }

    public void record(FootrestLocation footrestLocation) {
        footPrint.add(footrestLocation);
    }
}
