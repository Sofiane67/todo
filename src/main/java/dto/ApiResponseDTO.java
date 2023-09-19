package dto;

import org.springframework.http.HttpStatus;

public class ApiResponseDTO {
    private int status;
    private String message;

    public ApiResponseDTO(){}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
