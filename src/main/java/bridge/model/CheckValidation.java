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

    public void checkMove(String inputData) {
        if (!(inputData.equals("U") || inputData.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] U 또는 D값만 사용 할 수 있습니다.");
        }
    }

    public void checkRetry(String inputData) {
        if (!(inputData.equals("R") || inputData.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q값만 사용 할 수 있습니다.");
        }
    }
}
