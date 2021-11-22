package com.cardano.sports.api.model.exception;

import java.text.MessageFormat;

public class TimezoneNotFoundException extends RuntimeException {

    public TimezoneNotFoundException(final Long id) {
        super(MessageFormat.format("Timezone not found for id {}", id));
    }

}
