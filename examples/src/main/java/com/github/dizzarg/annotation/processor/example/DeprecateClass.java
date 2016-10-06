package com.github.dizzarg.annotation.processor.example;

import com.github.dizzarg.annotation.processor.simple.Deprecate;

@Deprecate(message = "Please do not use this class")
public class DeprecateClass {

    private String name;

    public DeprecateClass(final String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
