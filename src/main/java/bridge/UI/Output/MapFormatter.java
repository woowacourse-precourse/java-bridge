package bridge.UI.Output;

public class MapFormatter {
    public StringBuilder changeMapFormat(StringBuilder input) {
        StringBuilder formatChanged = new StringBuilder();
        formatChanged.append("[");
        for (char inputChar : input.toString().toCharArray()){
            formatChanged.append(inputChar).append(" |");
        }
        formatChanged.deleteCharAt(formatChanged.lastIndexOf(" |"));
        formatChanged.append("]");

        return formatChanged;
    }
}
