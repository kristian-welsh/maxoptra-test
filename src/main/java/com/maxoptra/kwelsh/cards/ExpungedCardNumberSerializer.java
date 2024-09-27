package com.maxoptra.kwelsh.cards;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ExpungedCardNumberSerializer extends JsonSerializer {

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String cardNumber = (String) value;
        gen.writeString("xxxx-xxxx-xxxx-" + cardNumber.substring(15,19));
    }
}
