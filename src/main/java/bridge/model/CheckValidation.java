package bridge.model;

public class CheckValidation {

    public void checklenght(String inputData) {
        int lenght = checkNum(inputData);
        checkLength(lenght);
    }
    private int checkNum(String inputData) {
        int lenght;
        try {
            lenght = Integer.parseInt(inputData);
        } catch(Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력 하였습니다.");
        }
        return lenght;
    }
    private void checkLength(int lenght) {
        if (lenght < 3 || lenght > 20) {
            throw new IllegalArgumentException("[ERROR] 3이상 20이하인 값을 입력 해야 합니다.");
        }
    }
}
