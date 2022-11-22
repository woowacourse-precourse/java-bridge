package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final String CORRECT = "O";
    private static final String WRONG = "X";
    private static final String SPACE = " ";

    private final List<String> upsideBridge = new ArrayList<>();

    private final List<String> downsideBridge = new ArrayList<>();

    public void retry() {
        initProgress();
    }

    public void correctUpsideBridge(int location) {
        upsideBridge.add(location, CORRECT);
        downsideBridge.add(location, SPACE);
    }

    public void correctDownsideBridge(int location) {
        upsideBridge.add(location, SPACE);
        downsideBridge.add(location, CORRECT);
    }

    public void wrongUpsideBridge(int location) {
        upsideBridge.add(location, WRONG);
        downsideBridge.add(location, SPACE);
    }

    public void wrongDownsideBridge(int location) {
        upsideBridge.add(location, SPACE);
        downsideBridge.add(location, WRONG);
    }

    public boolean isFailToAnswer() {
        return upsideBridge.contains(WRONG) || downsideBridge.contains(WRONG);
    }

    public boolean isAllAnswer(int size) {
        int count = 0;

        count = countUpsideCorrect(count) + countDownsideCorrect(count);

        return count == size;
    }

    public List<String> showUpsideBridgeToString() {
        return this.upsideBridge;
    }

    public List<String> showDownsideBridge() {
        return this.downsideBridge;
    }

    private void initProgress() {
        this.upsideBridge.clear();
        this.downsideBridge.clear();
    }

    private int countUpsideCorrect(int count) {
        for (String upside : upsideBridge) {
            if (upside.equals(CORRECT)) {
                count++;
            }
        }
        return count;
    }

    private int countDownsideCorrect(int count) {
        for (String downside : downsideBridge) {
            if (downside.equals(CORRECT)) {
                count++;
            }
        }
        return count;
    }
}
