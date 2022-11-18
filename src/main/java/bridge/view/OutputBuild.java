package bridge.view;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class OutputBuild {
    public static String buildMap(List<String> userPosition) {
        int size = userPosition.size();
        List<String> up = new ArrayList<>();
        List<String> down = new ArrayList<>();
        Deque<Integer> downIndex = new LinkedList<>();

        // U 인 부분
        String upLine = buildUpLine(userPosition, size, up, downIndex);

        // D 인 부분
        String downLine = buildDownLine(size, down, downIndex);

        String map = upLine + downLine;
        return map;
    }

    private static String buildDownLine(int size, List<String> down, Deque<Integer> downIndex) {
        return buildLine(i -> addDown(down, downIndex, i), size, down, downIndex);
    }

    private static void addDown(List<String> down, Deque<Integer> downIndex, Integer i) {
        if (!downIndex.isEmpty() && i == downIndex.getFirst()) {
            down.add(" O ");
            downIndex.removeFirst();
            return;
        }
        down.add("   ");
    }

    private static String buildUpLine(List<String> userPosition, int size, List<String> up, Deque<Integer> downIndex) {
        return buildLine(i -> addUp(userPosition, up, downIndex, i), size, up, downIndex);
    }

    private static void addUp(List<String> userPosition, List<String> up, Deque<Integer> downIndex, Integer i) {
        if (userPosition.get(i).equals("U")) {
            up.add(" O ");
            return;
        }
        up.add("   ");
        downIndex.add(i);
    }

    private static String buildLine(Consumer<Integer> callback, int size, List<String> upDown, Deque<Integer> downIndex) {
        for (int i = 0; i < size; i++) {
            callback.accept(i);
        }
        String status = "[" + String.join("|", upDown) + "]\n";
        return status;
    }
}
