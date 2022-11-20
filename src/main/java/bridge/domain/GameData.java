package bridge.domain;

import bridge.service.PlayerCommend;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameData {
    private int tryCount;
    private int location;
    private List<List<String>> historyMap;

    public GameData() {
        this.tryCount = 0;
    }

    public void plusTryCount() {
        this.tryCount++;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void resetLocation() {
        this.location = 0;
    }

    public void moveLocation() {
        this.location++;
    }

    public int getLocation() {
        return location;
    }

    public void resetHistoryMap() {
        this.historyMap = new ArrayList<>();
        historyMap.add(new ArrayList<>());
        historyMap.add(new ArrayList<>());
    }

    public String getHistoryMap() {
        return this.historyMap.get(0).stream()
                .collect(Collectors.joining(" | ", "[ ", " ]")) + "\n" +
                this.historyMap.get(1)
                        .stream().collect(Collectors.joining(" | ", "[ ", " ]"));
    }

    public void addHistoryMap(String commend, boolean correct) {
        String result = CorrectResult.CORRECT.getResult(correct);
        if (commend.equals(PlayerCommend.MOVE_UPPER.getCommend())) {
            historyMap.get(0).add(result);
            historyMap.get(1).add(" ");
            return;
        }
        historyMap.get(1).add(result);
        historyMap.get(0).add(" ");
    }
}
