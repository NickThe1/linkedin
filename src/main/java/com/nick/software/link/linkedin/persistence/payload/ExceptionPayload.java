package com.nick.software.link.linkedin.persistence.payload;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
public class ExceptionPayload {

    private final String meassage;

    private final HttpStatus httpStatus;

    private final ZonedDateTime zonedDateTime;
}
