package bridge;

import java.util.List;

public class Validator {

    public void checkSize(String sizeName) {
        try {
            int size = Integer.parseInt(sizeName);

            if (20 < size || size < 3) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ExceptionMessage.incorrectSize.getMessage());
        }
    }

    public void checkBridgeSize(int size, List<String> bridge) {
        if(size != bridge.size()) {
            throw new IllegalArgumentException(
                    ExceptionMessage.bridgeNotEqualsSize.getMessage());
        }
    }

    public void checkBridgeWord(int size, List<String> bridge) {
        long count = bridge.stream()
                .filter(s -> s.equals("U")||s.equals("D")).count();

        if(count != size) {
            throw new IllegalArgumentException(
                    ExceptionMessage.bridgeNotUorD.getMessage());
        }
    }


}
