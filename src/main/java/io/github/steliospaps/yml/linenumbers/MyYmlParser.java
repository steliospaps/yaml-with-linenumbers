package io.github.steliospaps.yml.linenumbers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.LineNumberInjector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;

import java.lang.classfile.instruction.LineNumber;

public class MyYmlParser {
    private final YAMLMapper mapper;

    public MyYmlParser() {
        mapper = new YAMLMapper();
        mapper.disable(YAMLGenerator.Feature.USE_NATIVE_TYPE_ID);
        mapper.disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        mapper.enable(YAMLGenerator.Feature.MINIMIZE_QUOTES);
        mapper.setInjectableValues(new LineNumberInjector());


    }

    public Document parseYml(String yml) {
        try {
            return mapper.readValue(yml, Document.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String writeYml(Document res) {
        try {
            return mapper.writeValueAsString(res);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
