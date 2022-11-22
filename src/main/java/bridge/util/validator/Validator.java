package bridge.util.validator;

public abstract class Validator {

    /**
     * 유효성 검증 로직의 템플릿 메서드
     * @param input 사용자의 입력값
     * */
    public boolean validate(final String input) {
        try {
            check(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    /**
     * 실제 유효성 검증 로직을 처리하는 추상 메서드
     * @param input 사용자의 입력값
     * */
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
