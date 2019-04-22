package exception;

/**
 * Created by sloanzhang on 2019/4/18.
 */
public class TaskException extends Exception {
    private int code;

    public TaskException(int reason) {

        this.code=code;
    }

    public int getCode() {
        return code;
    }
}
