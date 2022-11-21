package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeSelection {
    private int size;
    private List<List<String>> selections;

    public BridgeSelection(int size) {
        this.size = size;
        selections = new ArrayList<>();
        ArrayList<String> upSelection = new ArrayList<>();
        ArrayList<String> downSelection = new ArrayList<>();
        selections.add(upSelection);
        selections.add(downSelection);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<String>> getSelections() {
        return selections;
    }

    public void setSelections(List<List<String>> selections) {
        this.selections = selections;
    }

    public List<List<String>> insertBridgeSelection(String result, String selection) {
        if (selection.equals("U")) {
            selections.get(1).add(result);
            selections.get(0).add(" ");
        }
        if (selection.equals("D")) {
            selections.get(1).add(" ");
            selections.get(0).add(result);
        }
        return selections;
    }
}
