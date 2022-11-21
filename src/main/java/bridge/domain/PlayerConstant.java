package bridge.domain;

public enum PlayerConstant {
    UP("U"),
    DOWN("D");

    String location;

    PlayerConstant(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
