package ucb.arqsoft.currency.dto;

public class ResponseDto<T> {
    private T data; 
    private boolean successful;
    private String message;

    public ResponseDto() {
    }

    public ResponseDto(T data, boolean succesful, String message) {
        this.data = data;
        this.successful = succesful;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean succesful) {
        this.successful = succesful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseDto [data=" + data + ", succesful=" + successful + ", message=" + message + "]";
    }
}
