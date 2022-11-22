package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/20
 */
public class MovedBridge {
    private static MovedBridge movedBridge;     // 싱글톤 패턴 적용
    private List<String> bridge;

    public static MovedBridge getInstance() {
        if(movedBridge == null) {
            synchronized(MovedBridge.class)
            {
                movedBridge = new MovedBridge();
            }
        }
        return movedBridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    private MovedBridge() {
        this.bridge = new ArrayList<>();
    }

    public void reset() {
        this.bridge = new ArrayList<>();
    }

    public int getSize() {
        return bridge.size();
    }

    public void addMoveBridgeBlock(String moveCommand) {
        bridge.add(moveCommand);
    }
}
