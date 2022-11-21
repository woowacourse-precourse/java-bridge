package bridge;

import java.util.List;

public class BridgeDTO {
    private int length;
    private int count;
    private final List<String> bridge;
    private final BridgeCase [] upCase;
    private final BridgeCase [] downCase;

    public BridgeDTO(List<String> bridge) {
        int size = bridge.size();
        this.count = 1;
        this.bridge = bridge;
        upCase = new BridgeCase[size];
        downCase = new BridgeCase[size];
        initBridge();
    }
    public void initBridge() {
        for(int i = 0; i < bridge.size(); i++){
            upCase[i] = BridgeCase.NOTHING;
            downCase[i] = BridgeCase.NOTHING;
        }
        this.length = 1;
    }
    public void move(int i) {
        if("U".equals(this.bridge.get(i))) {
            upCase[i] = BridgeCase.ANSWER;
        }
        if("D".equals(this.bridge.get(i))) {
            downCase[i] = BridgeCase.ANSWER;
        }
    }

    public void doNotMove(String movingCommand, int i) {
        if(movingCommand.equals("U")) {
            upCase[i] = BridgeCase.WRONG;
        }
        if(movingCommand.equals("D")) {
            downCase[i] = BridgeCase.WRONG;
        }
    }
    public void addLength(int num) {
        if(this.length + num < bridge.size() + 1) {
            this.length += num;
        }
    }
    public void increaseCount(){
        this.count += 1;
    }
    public int getLength() {
        return length;
    }

    public int getCount() {
        return count;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public BridgeCase [] getUpCase() {
        return upCase;
    }

    public BridgeCase [] getDownCase() {
        return downCase;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
