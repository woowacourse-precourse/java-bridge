package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public interface Terminal {
    class Out {
        public static void print(Message message) {
            System.out.print(message.text());
        }

        public static void printLine(Message message) {
            System.out.println(message.text());
        }

        public static void print(String text) {
            System.out.print(text);
        }

        public static void printLine(String text) {
            System.out.println(text);
        }

//        public static void printError(ErrorMessage errorMessage) {
//            System.out.println(errorMessage.text());
//        }
    }

    class In {
        public static int readNumber() {
            String value = Console.readLine();
//            validate(value);
            return Integer.parseInt(value);
        }

        public static String readMessage() {
            String value = Console.readLine();
//            validate(value);
            return value;
        }

//        private static void validate(String message) {
//            Validator.validateNotNull(message);
//            Validator.validateNotEmpty(message);
//        }
    }
}
