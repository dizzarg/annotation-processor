package com.github.dizzarg.annotation.processor.simple;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Documented
@Retention( RetentionPolicy.CLASS )
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface Deprecate {

    String message();

}
