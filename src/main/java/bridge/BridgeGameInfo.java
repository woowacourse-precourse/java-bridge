package bridge;

import java.util.List;

public class BridgeGameInfo {
    private List<String> bridge;
    private int position;
    private String player;
    private int trial;
    private int end;

    BridgeGameInfo(int size){
        this.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        this.position = -1;
        this.trial = 1;
        this.end = bridge.size()-1;
    }

    public String getBridgeAt(int i){
        return bridge.get(i);
    }
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setPositionNext(){
        this.position ++;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getTrial() {
        return trial;
    }

    public void addTrial(){
        this.trial++;
    }

    public int getEnd() {
        return end;
    }
}
