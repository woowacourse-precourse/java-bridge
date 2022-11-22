package bridge;



public class RandomNumber {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    public int randomNumber(int size) {
        int number = bridgeNumberGenerator.generate();

        for (int i = 0; i < size; i++) {
            number = bridgeNumberGenerator.generate();
        }
        return number;
    }


}
