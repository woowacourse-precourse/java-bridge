package model;

import java.util.List;

public class Bridge {
    private List<String> status;

    public Bridge(List<String> status) {
        this.status = status;
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
