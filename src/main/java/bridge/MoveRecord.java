package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveRecord {

    private List<Move> records;

    public MoveRecord() {
        records = new ArrayList<>();
    }

    public void init() {
        records.clear();
    }

    public void add(String moving, boolean isMove) {
        this.records.add(new Move(isMove, moving));
    }

    public List<String> toResultString() {
        List<String> result = new ArrayList<>();
        Map<String, List<String>> upDown = new HashMap<>();
        upDown.put("U", new ArrayList<>());
        upDown.put("D", new ArrayList<>());
        makeResult(upDown);
        result.add("[ " + String.join(" | ", upDown.get("U")) + " ]");
        result.add("[ " + String.join(" | ", upDown.get("D")) + " ]");
        return result;
    }

    private void makeResult(Map<String, List<String>> upDown) {
        for (Move record : records) {
            upDown.get(record.getMoveChoice())
                    .add(record.isSuccess());
            if (record.getMoveChoice().equals("U")) {
                upDown.get("D").add(" ");
            }
            if (record.getMoveChoice().equals("D")) {
                upDown.get("U").add(" ");
            }
        }
    }
}
