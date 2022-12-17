package me.daniel.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "flat not found")
public class FlatNotFoundException extends RuntimeException {
}
