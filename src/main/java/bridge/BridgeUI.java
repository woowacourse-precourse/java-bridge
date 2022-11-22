package bridge;

public class BridgeUI {
    public void start() {
        System.out.print("[");
    }

    public void end() {
        System.out.print("]");
    }

    public void success() {
        System.out.print("O");
    }

    public void fail() {
        System.out.print("X");
    }

    public void empty() {
        System.out.print(" ");
    }

    public void divideLine() {
        System.out.print(" | ");
    }
}
