package bridge.util.validator;

public abstract class Validator {

    public boolean validate(final String input) {
        try {
            check(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public abstract void check(final String input);

    protected static boolean isNumeric(final String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    protected static boolean isAlpha(final String input) {
        char[] chars = input.toCharArray();

        for (char c : chars) {
            boolean isAlphabetic = Character.isAlphabetic(c);

            if (!isAlphabetic) {
                return false;
            }
        }

        return true;
    }
}
