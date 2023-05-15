package moe._47saikyo.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(LeetCodeExamples.class)
public @interface LeetCodeExample {
    String value() default "";
}
