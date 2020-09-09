package com.alessio.baseproject.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;
import java.time.format.DateTimeParseException;

public class DateTimeJsonDeserializer extends JsonDeserializer<DateTime> {
    private static final String TIMESTAMP_PATTERN_WITH_MILLISECONDS = "yyyy-MM-dd HH:mm:ss.SSSZZ";
    private static final String TIMESTAMP_PATTERN_WITHOUT_MILLISECONDS = "yyyy-MM-dd HH:mm:ssZZ";
    private static final DateTimeFormatter FORMATTER_WITH_MILLISECONDS = DateTimeFormat.forPattern(TIMESTAMP_PATTERN_WITH_MILLISECONDS);
    private static final DateTimeFormatter FORMATTER_WITHOUT_MILLISECONDS = DateTimeFormat.forPattern(TIMESTAMP_PATTERN_WITHOUT_MILLISECONDS);

    @Override
    public DateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String str = p.getText();
        try {
            return DateTime.parse(str, FORMATTER_WITH_MILLISECONDS);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
