package moe._47saikyo.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(LeetCodeDatas.class)
public @interface LeetCodeData {
    int index() default 0;
    String value() default "";
}

