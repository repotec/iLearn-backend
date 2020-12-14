package com.fabric.ilearn.model;

import com.fabric.ilearn.controller.lrn.LevelController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class BooleanConverter implements AttributeConverter<Boolean, Character> {
    Logger logger = LoggerFactory.getLogger(BooleanConverter.class);

    @Override
    public Character convertToDatabaseColumn(Boolean attribute) {
        if(attribute != null)
            if(attribute)
                return 'Y';
            else
                return 'N';

        return null;
    }

    @Override
    public Boolean convertToEntityAttribute(Character dbData) {
        if (dbData != null){
            return dbData.equals('Y');
        }
        return null;
    }
}
