package bridge.view;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class OutputBuild {
    public static String buildMap(List<String> userPosition) {
        int size = userPosition.size();
        List<StringBuilder> up = new ArrayList<>();
        List<StringBuilder> down = new ArrayList<>();
        Deque<Integer> downIndex = new LinkedList<>();

        // U 인 부분
        String upLine = buildUpLine(userPosition, size, up, downIndex);

        // D 인 부분
        String downLine = buildDownLine(size, down, downIndex);

        String map = upLine + downLine;
        return map;
    }

    private static String buildDownLine(int size, List<StringBuilder> down, Deque<Integer> downIndex) {
        return buildLine(i -> addDown(down, downIndex, i), size, down, downIndex);
    }

    private static void addDown(List<StringBuilder> down, Deque<Integer> downIndex, Integer i) {
        if (!downIndex.isEmpty() && i == downIndex.getFirst()) {
            down.add(new StringBuilder(" O "));
            downIndex.removeFirst();
            return;
        }
        down.add(new StringBuilder("   "));
    }

    private static String buildUpLine(List<String> userPosition, int size, List<StringBuilder> up, Deque<Integer> downIndex) {
        return buildLine(i -> addUp(userPosition, up, downIndex, i), size, up, downIndex);
    }

    private static void addUp(List<String> userPosition, List<StringBuilder> up, Deque<Integer> downIndex, Integer i) {
        if (userPosition.get(i).equals("U")) {
            up.add(new StringBuilder(" O "));
            return;
        }
        up.add(new StringBuilder("   "));
        downIndex.add(i);
    }

    private static String buildLine(Consumer<Integer> callback, int size, List<StringBuilder> upDown, Deque<Integer> downIndex) {
        for (int i = 0; i < size; i++) {
            callback.accept(i);
        }
        String status = "[" + String.join("|", upDown) + "]\n";
        return status;
    }

    public static String resolveClear(Boolean clear) {
        if(clear) return "성공";
        return "실패";
    }
}
