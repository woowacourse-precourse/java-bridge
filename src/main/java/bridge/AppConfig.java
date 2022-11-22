package bridge;

public class AppConfig {

    public BridgeMaker bridgeMaker(){
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }
}
