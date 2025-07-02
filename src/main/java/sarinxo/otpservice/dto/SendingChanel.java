package sarinxo.otpservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum SendingChanel {
    TELEGRAM,
    CONSOLE;

    @JsonCreator
    public static SendingChanel fromString(String value) {
        return Arrays.stream(values())
                .filter(e -> e.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }

}
