package bridge.domain;

import bridge.type.DrawType;

import java.util.ArrayList;
import java.util.List;

public class Draw {

    private List<String> upBridges = new ArrayList<>(); // 위칸 다리 영역
    private List<String> downBridges = new ArrayList<>(); // 아래칸 다리 영역

    // 위칸을 선택 시 표시 기능
    public void drawUpBridges(String symbol) {
        this.upBridges.add(symbol);
        this.downBridges.add(" ");
    }

    // 아래칸을 선택 시 표시 기능
    public void drawDownBridges(String symbol) {
        this.upBridges.add(" ");
        this.downBridges.add(symbol);
    }

    public List<String> getUpBridges() {
        return upBridges;
    }

    public List<String> getDownBridges() {
        return downBridges;
    }

    // 초기화
    public void removeAll() {
        this.upBridges.clear();
        this.downBridges.clear();
    }

    // "O" Pass 인 부분을 카운트
    public int countPassSymbol() {
        int upPassCount = (int) this.upBridges.stream()
                .filter(symbol -> symbol.equals(DrawType.PASS.getSymbol()))
                .count();

        int downPassCount = (int) this.downBridges.stream()
                .filter(symbol -> symbol.equals(DrawType.PASS.getSymbol()))
                .count();

        return upPassCount + downPassCount;
    }
}
