package com.cardano.sports.api.model.exception;

import java.text.MessageFormat;

public class LanguageNotFoundException extends RuntimeException {

    public LanguageNotFoundException(final Long id) {
        super(MessageFormat.format("Language not found for id {}", id));
    }

}
