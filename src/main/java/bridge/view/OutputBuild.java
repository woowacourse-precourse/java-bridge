package bridge.view;

import java.util.List;

public class OutputBuild {
    public static String buildMap(List<String> bridge, Integer index, String way, List<List<StringBuilder>> moveTable) {
        append(bridge.get(index).equals(way), way, moveTable);
        return format(moveTable);
    }

    private static String format(List<List<StringBuilder>> moveTable) {
        String upLine = "[" + String.join("|", moveTable.get(1)) + "]\n";
        String downLine = "[" + String.join("|", moveTable.get(0)) + "]";

        return upLine + downLine;
    }

    private static void append(boolean canGo, String way, List<List<StringBuilder>> moveTable) {
        if (canGo) {
            // moveTable[0] 이 Down, moveTable[1] 이 Up
            if (way.equals("U")) {
                moveTable.get(1).add(new StringBuilder(" O "));
                moveTable.get(0).add(new StringBuilder("   "));
            } else {
                moveTable.get(0).add(new StringBuilder(" O "));
                moveTable.get(1).add(new StringBuilder("   "));
            }
        }
        else{
            if (way.equals("U")) {
                moveTable.get(1).add(new StringBuilder(" X "));
                moveTable.get(0).add(new StringBuilder("   "));
            } else {
                moveTable.get(0).add(new StringBuilder(" X "));
                moveTable.get(1).add(new StringBuilder("   "));
            }
        }
    }
}
