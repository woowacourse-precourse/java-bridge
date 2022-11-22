package bridge;

import java.util.NoSuchElementException;

public class BridgeSize {

    private final int size;
    private static final String WRONG_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public BridgeSize() {
        String size = InputView.readBridgeSize();
        this.size = validateBridgeSize(toInt(size));
    }

    public int get() {
        return this.size;
    }

    private int toInt(String size) {
        try {
            return Integer.parseInt(size);
        } catch (NumberFormatException e) {
            System.out.println(WRONG_SIZE);
            throw new NoSuchElementException();
        }
    }

    private int validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            System.out.println(WRONG_SIZE);
            throw new IllegalArgumentException();
        }
        return size;
    }
}
