package bridge;

public class RandomNumberHandlerImpl implements RandomNumberHandler {

    @Override
    public String convertRandomNumber(int randomNumber) {
        if (randomNumber == 0) {
            return "D";
        }
        return "U";
    }
}
