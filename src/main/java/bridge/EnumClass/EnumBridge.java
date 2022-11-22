package bridge.EnumClass;

public enum EnumBridge {
    Max_cnt(20),
    Min_cnt(3);
    private int cnt;

    EnumBridge(int cnt) {
        this.cnt = cnt;
    }

    public int getCnt() {
        return cnt;
    }
}
