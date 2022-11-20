package bridge;

import java.util.List;

public class Bridge {

    List<String> availableSpace;

    public Bridge(List<String> movableSpace){
        validate(movableSpace);
        this.availableSpace = movableSpace;
    }

    public void validate(List<String> movableSpace) {
        if (movableSpace.size() < 3 || movableSpace.size() > 20) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
