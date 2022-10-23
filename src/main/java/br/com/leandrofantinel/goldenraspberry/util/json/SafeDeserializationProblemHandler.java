package br.com.leandrofantinel.goldenraspberry.util.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

public class SafeDeserializationProblemHandler extends DeserializationProblemHandler {
    @Override
    public Object handleWeirdKey(DeserializationContext ctx, Class<?> rawKeyType, String keyValue, String failureMsg) {
        return null;
    }

    @Override
    public Object handleWeirdNativeValue(DeserializationContext ctx, JavaType targetType, Object valueToConvert, JsonParser p) {
        return null;
    }

    @Override
    public Object handleUnexpectedToken(DeserializationContext ctx, JavaType targetType, JsonToken t, JsonParser p, String failureMsg) {
        return null;
    }

    @Override
    public Object handleInstantiationProblem(DeserializationContext ctx, Class<?> instClass, Object argument, Throwable t) {
        return null;
    }

    @Override
    public Object handleMissingInstantiator(DeserializationContext ctx, Class<?> instClass, ValueInstantiator valueInsta, JsonParser p, String msg) {
        return null;
    }

    @Override
    public JavaType handleUnknownTypeId(DeserializationContext ctx, JavaType baseType, String subTypeId, TypeIdResolver idResolver, String failureMsg) {
        return null;
    }

    @Override
    public JavaType handleMissingTypeId(DeserializationContext ctx, JavaType baseType, TypeIdResolver idResolver, String failureMsg) {
        return null;
    }

    @Override
    public Object handleWeirdStringValue(DeserializationContext ctx, Class<?> targetType, String valueToConvert, String failureMsg) {
        return null;
    }

    @Override
    public Object handleWeirdNumberValue(DeserializationContext ctx, Class<?> targetType, Number valueToConvert, String failureMsg) {
        return null;
    }
}
