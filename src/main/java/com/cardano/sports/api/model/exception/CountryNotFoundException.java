package com.cardano.sports.api.model.exception;

import java.text.MessageFormat;

public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException(final Long id) {
        super(MessageFormat.format("Country not found for id {}", id));
    }

}
