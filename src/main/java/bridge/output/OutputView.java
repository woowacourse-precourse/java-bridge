package bridge.output;

import static bridge.output.OutputString.*;

public class OutputView {
    public static void printStartGame() {
        System.out.println(START_GAME_MESSAGE);
        System.out.println();
    }

    public static void printMap(StringBuilder upperRoad, StringBuilder lowerRoad) {
        StringBuilder upperRoadFormat = new StringBuilder();
        StringBuilder lowerRoadFormat = new StringBuilder();

        appendSeparator(upperRoad, lowerRoad, upperRoadFormat, lowerRoadFormat);
        addStartEndSign(upperRoadFormat, lowerRoadFormat);

        System.out.println(upperRoadFormat);
        System.out.println(lowerRoadFormat);
        System.out.println();
    }

    private static void addStartEndSign(StringBuilder upperRoadFormat, StringBuilder lowerRoadFormat) {
        upperRoadFormat.insert(0, START_SIGN);
        lowerRoadFormat.insert(0, START_SIGN);
        upperRoadFormat.append(END_SIGN);
        lowerRoadFormat.append(END_SIGN);
    }

    private static void appendSeparator(StringBuilder upperRoad, StringBuilder lowerRoad, StringBuilder upperRoadFormat, StringBuilder lowerRoadFormat) {
        for (int i = 0; i < upperRoad.length(); i++) {
            upperRoadFormat.append(upperRoad.charAt(i));
            if (i != upperRoad.length() - 1) {
                upperRoadFormat.append(SEPARATOR);
            }
        }
        for (int i = 0; i < lowerRoad.length(); i++) {
            lowerRoadFormat.append(lowerRoad.charAt(i));
            if (i != lowerRoad.length() - 1) {
                lowerRoadFormat.append(SEPARATOR);
            }
        }
    }

}
