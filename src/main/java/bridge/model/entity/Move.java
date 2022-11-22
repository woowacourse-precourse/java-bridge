package bridge.model.entity;

import bridge.model.value.PlayerMessage;

import java.util.List;

import static bridge.model.value.PlayerMessage.DOWN;
import static bridge.model.value.PlayerMessage.UP;

public class Move {
    private String move;

    private Move(String move) {
        validate(move);
        this.move = move;
    }

    public String getMove(){
        return this.move;
    }
    private void validate(String move){
        if(UP.equals(move) || DOWN.equals(move)){
            return;
        }
        throw new IllegalArgumentException("[ERROR] 이동하기 위한 문자가 아닙니다. 다시 입력해주세요 :" + move);
    }

    public static Move of(String move){
        return new Move(move);
    }

}
