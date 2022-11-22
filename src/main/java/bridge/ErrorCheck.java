package bridge;

public class ErrorCheck {
    public boolean errorCheckReadBridgeSize(String userInput) {
        try {
            if (!(checkIsNumber(userInput) && checkNumberIsInBoundary(userInput))) {
                throw new IllegalArgumentException("[ERROR]");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean checkNumberIsInBoundary(String userInput) {
        boolean possible = true;
        int tmp = Integer.parseInt(userInput);
        if (tmp < 3 || tmp > 20) {
            possible = false;
        }
        return possible;
    }

    private boolean checkIsNumber(String userInput) {
        boolean possible = true;
        for (int i = 0; i < userInput.length(); i++) {
            int tmp = userInput.charAt(i) - '0';
            if (tmp < 0 || tmp >= 10) {
                possible = false;
            }
        }
        return possible;
    }


    public boolean errorCheckReadMovig(String userInput) {
        try {
            if (!(userInput.equals("U") || userInput.equals("D"))) {
                throw new IllegalArgumentException("[ERROR]");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


    public boolean errorCheckReadGameCommand(String userInput) {
        try {
            if (!(userInput.equals("R") || userInput.equals("Q"))) {
                throw new IllegalArgumentException("[ERROR]");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
