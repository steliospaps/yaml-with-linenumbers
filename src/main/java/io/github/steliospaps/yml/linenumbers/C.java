package io.github.steliospaps.yml.linenumbers;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;

public record C(int linenumber, int val) implements Child{

    public C(@JacksonInject("linenumber") int linenumber, int val) {
        this.linenumber = linenumber;
        this.val = val;
    }
}
