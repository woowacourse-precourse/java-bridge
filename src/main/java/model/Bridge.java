package model;

import type.MovingType;

import java.util.List;

public class Bridge {
    private List<String> status;

    public Bridge(List<String> status) {
        this.status = status;
    }

    public String compareTo(int index, Moving input) {
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

    public void deleteBridge() {
        this.status.remove(this.status.size() - 1);
    }
}
