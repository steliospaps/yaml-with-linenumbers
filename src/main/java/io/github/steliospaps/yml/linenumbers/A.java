package io.github.steliospaps.yml.linenumbers;

import com.fasterxml.jackson.annotation.JacksonInject;

public record A(int linenumber, int val, Child child) implements Child {
    public A(@JacksonInject("linenumber") int linenumber, int val, Child child) {
        this.linenumber = linenumber;
        this.val = val;
        this.child = child;
    }
}
