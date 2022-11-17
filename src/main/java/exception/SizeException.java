package exception;

public class SizeException {
    private int size;

    public SizeException(int size) {
        this.size = size;
        checkBridgeSize(size);
    }

    public void checkBridgeSize(int size) {
        if (!(size >= 3 && size <= 20)) throw new IllegalArgumentException();
    }

    public int getSize() {
        return size;
    }
}
