package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeSelection {
    private int size;
    private List<List<String>> selections;

    public BridgeSelection() {
        selections = new ArrayList<>();
        ArrayList<String> upSelection = new ArrayList<>();
        ArrayList<String> downSelection = new ArrayList<>();
        selections.add(upSelection);
        selections.add(downSelection);
    }

    public int getSize() {
        size = selections.get(0).size();
        return size;
    }

    public List<List<String>> getSelections() {
        return selections;
    }

    public void setSelections(List<List<String>> selections) {
        this.selections = selections;
    }

    public List<List<String>> insertBridgeSelection(String result, String selection) {
        if (selection.equals("U")) {
            selections.get(1).add(" ");
            selections.get(0).add(result);
        }
        if (selection.equals("D")) {
            selections.get(1).add(result);
            selections.get(0).add(" ");
        }
        return selections;
    }
}
