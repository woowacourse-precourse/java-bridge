package bridge.domain;

import java.util.List;
import java.util.stream.Stream;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getSize() {
        return bridge.size();
    }

    public String[] makeRow(List<String> userMoving, String type) {
        String[] row = initializeArray(userMoving.size());
        for (int index = 0; index < userMoving.size(); index++) {
            row[index] = compareValue(bridge.get(index), userMoving.get(index), type);
            if (row[index].equals("X")) {
                break;
            }
        }
        return row;
    }

    private static String[] initializeArray(int size) {
        return Stream.iterate(0, index -> index < size, index -> index + 1)
                .map(string -> " ")
                .toArray(String[]::new);
    }

    private String compareValue(String bridgeValue, String userValue, String type) {
        if (bridgeValue.equals(type) && bridgeValue.equals(userValue)) {
            return "O";
        }
        if (userValue.equals(type)) {
            return "X";
        }
        return " ";
    }

    public boolean isSuccess(List<String> userMoving) {
        for (int index = 0; index < userMoving.size(); index++) {
            String bridgeValue = bridge.get(index);
            String userValue = userMoving.get(index);

            if (!bridgeValue.equals(userValue)) {
                return false;
            }
        }
        return true;
    }
}
