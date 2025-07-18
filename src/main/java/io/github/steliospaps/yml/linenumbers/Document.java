package io.github.steliospaps.yml.linenumbers;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;


public record Document(String title, Child child) {

}
