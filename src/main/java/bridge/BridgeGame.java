package bridge;

import java.util.List;
import java.util.Objects;

public class BridgeGame {
    public boolean isInProgress;
    public boolean inputResult;
    public String isCleared;
    private List<String> bridge;
    private int size;
    public int stage;
    private int attempts;


    public void start(String stringSize) {
        try {
            int size = Integer.parseInt(stringSize);
            if (size < 3 || size > 20)
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            this.isInProgress = true;
            this.size = size;
            this.stage = 1;
            this.attempts = 1;
            this.bridge = bridgeMaker.makeBridge(size);
            this.isCleared = "실패";
            this.inputResult = true;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public void move(String input) {
        if (!Objects.equals(input, "U") && !Objects.equals(input, "D"))
            throw new IllegalArgumentException("[ERROR] 잘못된 값입니다.");
        if (size == stage) {
            this.isCleared = "성공";
            this.isInProgress = false;
            this.inputResult = false;
            return;
        }
        if (!Objects.equals(input, bridge.get(stage))) {
            inputResult = false;
        }
        stage++;
    }

    public void retry(String input) {
        if (!Objects.equals(input, "R") && !Objects.equals(input, "Q"))
            throw new IllegalArgumentException("[ERROR] 잘못된 값입니다.");
        if (Objects.equals(input, "R")) {
            this.inputResult = true;
            this.stage = 1;
            this.attempts++;
        }
        if (Objects.equals(input, "Q")) {
            this.result();
        }
    }

    public void result() {
        this.isInProgress = false;
        System.out.println("최종 게임 결과");
        System.out.println("게임 성공 여부: " + isCleared);
        System.out.println("총 시도한 횟수: " + attempts);
    }
}
