package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<String> upsideBridge = new ArrayList<>();

    private final List<String> downsideBridge = new ArrayList<>();

    public void retry() {
        initProgress();
    }

    public void correctUpsideBridge(int location) {
        upsideBridge.add(location, "O");
        downsideBridge.add(location, " ");
    }

    public void correctDownsideBridge(int location) {
        upsideBridge.add(location, " ");
        downsideBridge.add(location, "O");
    }

    public void wrongUpsideBridge(int location) {
        upsideBridge.add(location, "X");
        downsideBridge.add(location, " ");
    }

    public void wrongDownsideBridge(int location) {
        upsideBridge.add(location, " ");
        downsideBridge.add(location, "X");
    }

    public boolean isFailToAnswer() { // retry 위한 조건
        return upsideBridge.contains("X") || downsideBridge.contains("X");
    }

    public boolean isAllAnswer(int size) {
        int count = 0;
        for(String upside : upsideBridge){
            if(upside.equals("O")){
                count++;
            }
        }

        for(String downside : downsideBridge){
            if(downside.equals("O")){
                count++;
            }
        }
        return count == size;
    }

    public List<String> showUpsideBridgeToString() {
        return this.upsideBridge;
    }

    public List<String> showDownsideBridge() {
        return this.downsideBridge;
    }

    private void initProgress() { // 재시도를 할 시, 현재 위치, 윗 다리 현재 진행도, 아랫다리 현재 진행도를 모두 초기화해준다.
        this.upsideBridge.clear();
        this.downsideBridge.clear();
    }
}
