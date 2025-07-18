package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;

//in this package to allow protected access
public class LineNumberInjector extends InjectableValues {
    @Override
    public Object findInjectableValue(Object valueId, DeserializationContext ctxt, BeanProperty forProperty, Object beanInstance) throws
    JsonMappingException {
        if(valueId.equals("linenumber")){
            if(((YAMLParser)ctxt.getParser()).getParsingContext()._child==null){
                return 1;//top level
            }
            int lineNumber = ((YAMLParser)ctxt.getParser()).getParsingContext()._child._lineNr+1;//0 based?
            return lineNumber;
        }
        return null;
    }
}