package exception;



public class ExceptionHandler {
    private int size;

    public ExceptionHandler(int size) {
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
