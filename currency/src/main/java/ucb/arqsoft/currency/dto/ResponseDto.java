package ucb.arqsoft.currency.dto;

public class ResponseDto<T> {
    private T data; 
    private boolean succesful;
    private String message;

    public ResponseDto() {
    }

    public ResponseDto(T data, boolean succesful, String message) {
        this.data = data;
        this.succesful = succesful;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccesful() {
        return succesful;
    }

    public void setSuccesful(boolean succesful) {
        this.succesful = succesful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseDto [data=" + data + ", succesful=" + succesful + ", message=" + message + "]";
    }
}
