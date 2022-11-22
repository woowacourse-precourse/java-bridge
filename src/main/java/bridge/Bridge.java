package bridge;

public enum Bridge {
    DOWN(0, "D"), UP(1, "U");

    private String str;
    private int num;

    Bridge(int num, String str) {
        this.str = str;
        this.num = num;
    }

    public String getStr() {
        return str;
    }

    public int getNum() {
        return num;
    }
}
