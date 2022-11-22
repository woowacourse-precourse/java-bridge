package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.PrintMessage.*;
import static bridge.constant.Moving.*;

public class BridgeGame {

    private final List<String> bridge;
    private List<String> player = new ArrayList<>();
    private List<String> upBridge = new ArrayList<>();
    private List<String> downBridge = new ArrayList<>();

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public void move(String moving) {
        player.add(moving);
        if (moving.equals(UP.getKey())) {
            upCase();
        }
        if (moving.equals(DOWN.getKey())) {
            downCase();
        }
    }

    public void upCase() {
        int nowIdx = player.size() - 1;
        downBridge.add(EMPTY);
        if (player.get(nowIdx).equals(bridge.get(nowIdx))) {
            upBridge.add(ALIVE);
            return;
        }
        upBridge.add(DIE);
    }

    public void downCase() {
        int nowIdx = player.size() - 1;
        upBridge.add(EMPTY);
        if (player.get(nowIdx).equals(bridge.get(nowIdx))) {
            downBridge.add(ALIVE);
            return;
        }
        downBridge.add(DIE);
    }

    public void retry() {
        player = new ArrayList<>();
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public List<String> getPlayer() {
        return this.player;
    }

    public List<String> getUpBridge() {
        return this.upBridge;
    }

    public List<String> getDownBridge() {
        return this.downBridge;
    }
}
