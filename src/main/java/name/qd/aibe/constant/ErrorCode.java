package name.qd.aibe.constant;

public enum ErrorCode {
    LLM_CONNECT_ISSUE("0001", "not able to connect to the host: %s"),
    ;

    final String code;
    final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
