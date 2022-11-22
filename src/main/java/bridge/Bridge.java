package bridge;

public class Bridge {
    private final String up;
    private final String down;

    public Bridge(String up, String down) {
        invalid(up);
        invalid(down);
        this.up = up;
        this.down = down;
    }

    private void invalid(String s) {
        if (!s.equals("O") && !s.equals("X") && !s.equals(" ")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 값입니다.");
        }
    }

    public String getUp() {
        return up;
    }

    public String getDown() {
        return down;
    }
}
