package com.github.dizzarg.annotation.processor.example;

import com.github.dizzarg.annotation.processor.simple.Deprecate;

public class ClassWithDepracatedMethod {

    private String name;

    public ClassWithDepracatedMethod(final String name ) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Deprecate(message = "try to use classWithDepracatedMethod.getName().length() methods")
    public int getNameLength(){
        return name.length();
    }

}
