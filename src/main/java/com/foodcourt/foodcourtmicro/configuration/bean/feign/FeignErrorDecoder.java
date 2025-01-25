package com.foodcourt.foodcourtmicro.configuration.bean.feign;

import com.foodcourt.foodcourtmicro.domain.exception.BadRequestException;
import com.foodcourt.foodcourtmicro.domain.exception.ConflictException;
import com.foodcourt.foodcourtmicro.domain.exception.InternalServerErrorException;
import com.foodcourt.foodcourtmicro.domain.exception.ResourceNotFoundException;
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
                return new ConflictException("Hubo un conflicto");
            case BAD_REQUEST:
                return new BadRequestException("Bad request ocurred");
            case NOT_FOUND:
                return new ResourceNotFoundException("Not found ocurred");
            case INTERNAL_SERVER_ERROR:
                return new InternalServerErrorException("Internal server error ocurred");
        }
        return new Exception("Error");
    }
}
