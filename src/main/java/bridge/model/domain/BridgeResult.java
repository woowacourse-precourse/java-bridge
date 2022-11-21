package bridge.model.domain;

import java.util.List;

import static bridge.model.constnce.Text.SUCCESS;

public class BridgeResult {
    private String result;
    private int attempt;

    public BridgeResult(){
        this.result = "실패";
        this.attempt = 1;
    }

    public void addAttempt() {
        attempt += 1;
    }

    public void isAllRoundClear(){
        result = "성공";
    }

    public String getResult(){
        return result;
    }

    public int getAttempt(){
        return attempt;
    }
}
