package bridge.view;

import java.util.List;

public class OutputBuild {
    public static String buildMap(List<String> bridge, Integer index, String way, List<List<StringBuilder>> moveTable) {
        append(bridge.get(index).equals(way), way, moveTable);
        return format(moveTable);
    }

    public static String format(List<List<StringBuilder>> moveTable) {
        String upLine = "[" + String.join("|", moveTable.get(1)) + "]\n";
        String downLine = "[" + String.join("|", moveTable.get(0)) + "]";

        return upLine + downLine;
    }

    private static void append(boolean canGo, String way, List<List<StringBuilder>> moveTable) {
        if (canGo) {
            updateTable(way, moveTable, " O ");
            return;
        }
        updateTable(way, moveTable, " X ");
    }

    private static void updateTable(String way, List<List<StringBuilder>> moveTable, String correctness) {
        if (way.equals("U")) {
            moveTable.get(1).add(new StringBuilder(correctness));
            moveTable.get(0).add(new StringBuilder("   "));
            return;
        }
        moveTable.get(0).add(new StringBuilder(correctness));
        moveTable.get(1).add(new StringBuilder("   "));
    }

    public static String resolveClear(Boolean clear) {
        if(clear){
            return "성공";
        }
        return "실패";
    }
}
