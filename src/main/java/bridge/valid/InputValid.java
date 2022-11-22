package bridge.valid;

public class InputValid {
    public boolean checkLengthValid(String test) {
        try {
            isNumber(test);
            isRange(test);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean checkChoice(String test) {
        try {
            isUpDown(test);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private void isNumber(String test) {
        if (test.matches("[+-]?\\d*(\\.\\d+)?") == false) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 하나의 숫자여야 합니다.\n");
        }
    }

    private void isRange(String test) {
        int check = Integer.parseInt(test);
        if (check < 3 || check > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.\n");
        }
    }

    private void isUpDown(String test) {
        if (!test.equals("U") && !test.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 (위: U, 아래: D) 여야 합니다.\n");
        }
    }
}
