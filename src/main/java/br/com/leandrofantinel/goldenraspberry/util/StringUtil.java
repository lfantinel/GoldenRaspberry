package br.com.leandrofantinel.goldenraspberry.util;

public final class StringUtil {
    private StringUtil() {}

    @SafeVarargs
    public static <T> String coalesce(T... values){
        if (values == null || values.length == 0) return "";
        for (T v : values) if (v != null && !v.toString().isEmpty()) return v.toString();
        return "";
    }
}
