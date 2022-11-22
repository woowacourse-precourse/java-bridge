package bridge;

import java.util.List;
import java.util.Objects;

public class BridgeGame {
    public boolean isInProgress = true;
    public boolean inputResult = true;
    public String isCleared = "실패";
    private List<String> bridge;
    private int size;
    private int stage = 0;
    private int attempts = 1;


    public void start(int size) {
        if (size < 3 || size > 20) throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.size = size;
        this.bridge = bridgeMaker.makeBridge(this.size);
    }

    public void move(String input) {
        if (!Objects.equals(input, bridge.get(stage))) {
            inputResult = false;
        }
        if (size == stage) {
            isCleared = "성공";
            isInProgress = false;
        }
        stage++;
    }

    public void retry() {
        this.inputResult = true;
        this.stage = 0;
        this.attempts++;
    }

    public void result() {
        this.isInProgress = false;
        System.out.println("최종 게임 결과");
        System.out.println("게임 성공 여부: " + isCleared);
        System.out.println("총 시도한 횟수: " + attempts);
    }
}
