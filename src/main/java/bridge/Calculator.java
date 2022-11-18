package bridge;

public class Calculator {
    public static Bridge moveCalculate(String current, String moving) {
        if (!current.equals(moving)) {
            if (current.equals("U"))
                return new Bridge(" ", "X");
            return new Bridge("X", " ");
        }
        if (current.equals("U"))
            return new Bridge("O", " ");
        return new Bridge(" ", "O");
    }
}
