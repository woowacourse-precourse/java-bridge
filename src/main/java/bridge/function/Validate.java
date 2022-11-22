package bridge.function;

import static bridge.ui.ErrorMessage.*;

public class Validate {
    public void BridgeSizeValidate(int size) {
        if(size<3 || size>20) {
            throw new IllegalArgumentException(BridgeSizeERROR.getMessage());
        }
    }

    public void MoveValidate(String move) {
        if(!move.equals("U") && !move.equals("D"))
            throw new IllegalArgumentException(MoveFormERROR.getMessage());
    }

    public void RetryValidate(String retry) {
        if(!retry.equals("R") && !retry.equals("Q"))
            throw new IllegalArgumentException(RestartFormERROR.getMessage());
    }
}
