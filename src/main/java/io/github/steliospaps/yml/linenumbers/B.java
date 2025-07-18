package io.github.steliospaps.yml.linenumbers;

import com.fasterxml.jackson.annotation.JacksonInject;

import java.util.List;

public record B(int linenumber,List<Child> children)implements Child {
    public B(@JacksonInject("linenumber") int linenumber, List<Child> children) {
        this.linenumber = linenumber;
        this.children = children;
    }
}
