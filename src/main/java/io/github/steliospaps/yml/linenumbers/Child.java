package io.github.steliospaps.yml.linenumbers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type",visible = false)
@JsonSubTypes({
        @JsonSubTypes.Type(value = A.class),
        @JsonSubTypes.Type(value = B.class),
        @JsonSubTypes.Type(value = C.class),
})
public interface Child {
    @JsonIgnore
    int linenumber();
}
