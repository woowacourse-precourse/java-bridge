package bridge.domain.converter;

public class ResultConverter {

    public String convertToMark(boolean isCrossable) {
        if (isCrossable) {
            return "O";
        }
        return "X";
    }

}
