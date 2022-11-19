package bridge;

import java.util.Objects;

public class Valification {

    public void verifyBridgeSize(int size){
        if(!(3<= size && size <=20)){
            throw new IllegalArgumentException();
        }
    }

    public void verifyUorD (String move){
        if(!(Objects.equals(move, "U") || Objects.equals(move, "D"))){
            throw new IllegalArgumentException();
        }
    }

    public void verifyQorR (String hi){
        if(!(Objects.equals(hi, "R") || Objects.equals(hi, "Q"))){
            throw new IllegalArgumentException();
        }
    }
}
