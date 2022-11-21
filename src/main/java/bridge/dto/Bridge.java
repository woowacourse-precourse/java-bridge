package bridge.dto;

import java.util.List;

public class Bridge {
    private List<String> positions;

    public Bridge(List<String> positions) {
        this.positions = positions;
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    public String getPosition(int currentPosition) {
        return positions.get(currentPosition);
    }

    public int getSize() {
        return positions.size();
    }

}