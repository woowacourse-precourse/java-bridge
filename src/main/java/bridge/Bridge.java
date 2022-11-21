package bridge;

import type.MovingType;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private List<String> status;

    public Bridge(List<String> status) {
        this.status = status;
    }

    public String compareTo(int index, String input) {
        if (status.get(index).equals(input)) {
            return MovingType.MOVE.getResult();
        }
        return MovingType.NOT_MOVE.getResult();
    }

    public void addBridge(String status) {
        this.status.add(status);
    }

    public String getBridge(int index) {
        return this.status.get(index);
    }

    public int getSize() {
        return this.status.size();
    }
}
