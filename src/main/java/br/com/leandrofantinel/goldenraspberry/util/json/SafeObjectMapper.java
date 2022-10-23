package br.com.leandrofantinel.goldenraspberry.util.json;

import br.com.leandrofantinel.goldenraspberry.util.json.enumerator.IEnum;
import br.com.leandrofantinel.goldenraspberry.util.json.enumerator.IEnumDeserializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class SafeObjectMapper extends ObjectMapper {

    public SafeObjectMapper() {
        super(JsonMapper.builder()

                .addModules(new Jdk8Module(), new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)

                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                .configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false)
                .configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false)

                .configure(DeserializationFeature.FAIL_ON_TRAILING_TOKENS, false)
                .configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false)
                .configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, false)
                .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false)
                .configure(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY, false)
                .configure(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS, false)
                .configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, false)
                .configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
                .configure(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY, false)

                .addHandler(new SafeDeserializationProblemHandler())

                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true)
                .configure(JsonParser.Feature.IGNORE_UNDEFINED, true)

                .visibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE)
                .visibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE)
                .visibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .serializationInclusion(JsonInclude.Include.NON_NULL)

                .addModule(new SimpleModule()
                        .addDeserializer(IEnum.class, new IEnumDeserializer()))

                .build()
        );

    }
}
