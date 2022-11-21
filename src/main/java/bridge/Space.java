package bridge;

public class Space {
    private String up;
    private String down;

    public Space() {
    }

    public void expandBlock(String block) {
        if (block.equals("U")) {
            up += "O";
            down += "X";
        }
        up += "X";
        down += "O";
    }

    public String toString() {
        return up + "\n" + down;
    }
}
