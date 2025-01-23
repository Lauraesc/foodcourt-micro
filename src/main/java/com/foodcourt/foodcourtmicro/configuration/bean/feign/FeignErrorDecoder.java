package com.foodcourt.foodcourtmicro.configuration.bean.feign;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        HttpStatus status = HttpStatus.valueOf(response.status());
        switch (status) {
            case CONFLICT:
                return new IllegalArgumentException("Hubo un conflicto");
            case BAD_REQUEST:
                return new IllegalArgumentException("Bad request ocurred");
            case NOT_FOUND:
                return new IllegalArgumentException("Not found ocurred");
            case INTERNAL_SERVER_ERROR:
                return new IllegalArgumentException("Internal server error ocurred");
        }
        return new Exception("Error");
    }
}
