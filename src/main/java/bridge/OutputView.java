package bridge;

import bridge.EnumClass.EnumCommand;
import bridge.EnumClass.EnumMassage;
import bridge.EnumClass.EnumStates;

import java.util.List;
import java.util.Objects;

public class OutputView {

    public static void printInitialize() {
        System.out.println(EnumMassage.Start.getMessage());
    }

    public static void printSelectMessage() {
        System.out.println(EnumMassage.Select_Moving.getMessage());
    }

    public static void printRetryMessage() {
        System.out.println(EnumMassage.Select_Retry.getMessage());
    }

    public static void printMap(List<String> bridge, EnumStates state) {
        int printingIndex = EnumStates.Index.getWorth();
        String upperString, lowerString;
        upperString = bridgeBuilder(bridge, printingIndex, EnumCommand.Up.getCommand());
        lowerString = bridgeBuilder(bridge, printingIndex, EnumCommand.Down.getCommand());
        if (state == EnumStates.Exit || state == EnumStates.Retry) {
            upperString = fixWrong(new StringBuilder(upperString)).toString();
            lowerString = fixWrong(new StringBuilder(lowerString)).toString();
        }
        System.out.println(upperString);
        System.out.println(lowerString + "\n");
    }

    private static String bridgeBuilder(List<String> bridge, int index, String floor) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = startOfLine(stringBuilder, Objects.equals(bridge.get(0), floor));
        for (int i = 1; i < index; i++) {
            stringBuilder = append(stringBuilder, Objects.equals(bridge.get(i), floor));
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    private static StringBuilder startOfLine(StringBuilder stringBuilder, boolean isCorrect) {
        if (isCorrect) {
            return stringBuilder.append("[ O");
        }
        return stringBuilder.append("[  ");
    }

    private static StringBuilder append(StringBuilder stringBuilder, boolean isCorrect) {
        if (isCorrect) {
            return stringBuilder.append(" | O");
        }
        return stringBuilder.append(" |  ");
    }

    private static StringBuilder fixWrong(StringBuilder stringBuilder) {
        if (stringBuilder.charAt(stringBuilder.length() - 3) == 'O') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 3);
            return stringBuilder.insert(stringBuilder.length() - 2, ' ');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 3);
        return stringBuilder.insert(stringBuilder.length() - 2, 'X');
    }

    public static void printResult(List<String> bridge, EnumStates gameState, int count) {
        System.out.println(EnumMassage.Finish.getMessage());
        printMap(bridge, gameState);

        System.out.printf(EnumMassage.Result.getMessage(), gameState.getState(), count);

    }
}
