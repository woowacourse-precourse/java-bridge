package bridge.Instances;

    public enum EndType {
        SUCCESS(false, true), FAIL_RETRY(true, false), FAIL_QUIT(false, false);
        private final boolean retry;
        private final boolean success;

        EndType(boolean retry, boolean success) {
            this.retry = retry;
            this.success = success;
        }

        public boolean getRetry() {
            return this.retry;
        }

        public boolean getSuccess() {
            return this.success;
        }
    }

