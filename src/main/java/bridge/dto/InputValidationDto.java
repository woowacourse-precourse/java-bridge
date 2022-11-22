package bridge.dto;

import bridge.type.InputType;

public class InputValidationDto {

    public static class Request {

        private final InputType type;
        private final String target;

        public Request(InputType type, String target) {
            this.type = type;
            this.target = target;
        }

        public InputType getType() {
            return type;
        }

        public String getTarget() {
            return target;
        }
    }

    public static class Response {

        private final boolean isValid;
        private String errorMessage;

        public Response(boolean isValid) {
            this.isValid = isValid;
        }

        public Response(boolean isValid, String errorMessage) {
            this.isValid = isValid;
            this.errorMessage = errorMessage;
        }

        public boolean isValid() {
            return isValid;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
