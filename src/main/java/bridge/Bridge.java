package bridge;

import java.util.List;

public class Bridge {
    private int size;
    private List<String> bridges;

    public Bridge(int size, List<String> bridges) {
        this.size = size;
        this.bridges = bridges;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<String> getBridges() {
        return bridges;
    }

    public void setBridges(List<String> bridges) {
        this.bridges = bridges;
    }

    public boolean compare(int index, String direction) {
        String block = bridges.get(index);
        if (!block.equals(direction)) {
            return false;
        }
        return true;
    }
}
