package bridge.model.domain;

import java.util.List;

import static bridge.model.constnce.Text.SUCCESS;

public class BridgeResult {
    private String result;
    private int attempt;

    BridgeResult(String result, int attempt){
        this.result = "실패";
        this.attempt = 1;
    }

    private void addAttempt() {
        attempt += 1;
    }

    private void isAllRoundClear(){
        result = "성공";
    }

    private String getResult(){
        return result;
    }

    private int getAttempt(){
        return attempt;
    }
}
