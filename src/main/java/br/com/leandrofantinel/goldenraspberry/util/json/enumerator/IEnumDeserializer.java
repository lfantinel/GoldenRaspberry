package br.com.leandrofantinel.goldenraspberry.util.json.enumerator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor
@AllArgsConstructor
public class IEnumDeserializer
        extends JsonDeserializer<IEnum<?>>
        implements ContextualDeserializer {

    private Class<IEnum<?>> mType;

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctx, BeanProperty property) {
        final Class<IEnum<?>> type = (Class<IEnum<?>>) ctx.getContextualType().getRawClass();
        return new IEnumDeserializer(type);
    }

    @Override
    public IEnum<?> deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        final JsonNode node = jp.getCodec().readTree(jp);
        final String value = node.asText();
        return IEnum.valueOf(mType, value);
    }
}
