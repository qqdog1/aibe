package name.qd.aibe.config;

import com.fasterxml.jackson.databind.node.ObjectNode;
import name.qd.aibe.constant.ErrorCode;
import name.qd.aibe.utils.JsonUtils;

public class AIBEException extends Exception {
    private final ErrorCode errorCode;
    private String[] values;

    public AIBEException(ErrorCode errorCode, String ... values) {
        this.errorCode = errorCode;
        this.values = values;
    }

    public String getMessage() {
        ObjectNode node = JsonUtils.getObjectNode();
        node.put("code", errorCode.getCode());
        String message;
        if (values != null) {
            message = String.format(errorCode.getMessage(), values);
        } else {
            message = errorCode.getMessage();
        }
        node.put("message", message);
        return node.toString();
    }
}
