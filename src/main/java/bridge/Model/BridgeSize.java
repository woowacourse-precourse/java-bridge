package bridge.Model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class BridgeSize {
    private final static int MIN_SIZE = 3;
    private final static int MAX_SIZE = 20;

    private int size;

    public BridgeSize(int size){
        validData(size);
        this.size = size;
    }

    private void validData(int data) throws IllegalArgumentException{
        if(data >= MIN_SIZE && data <= MAX_SIZE){
            return;
        }
        throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    public List<String> makeBridge(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(size);
    }
}
