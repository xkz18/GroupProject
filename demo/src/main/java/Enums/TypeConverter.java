package Enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.print.attribute.Attribute;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TypeConverter implements AttributeConverter<Type, String> {
    @Override
    public String convertToDatabaseColumn(Type type){
        if(type==null) {
            return null;
        }
        return type.getCode();
    }

    @Override
    public Type convertToEntityAttribute(String code){
        if(code==null){
            return null;
        }
        return Stream.of(Type.values())
                .filter(c->c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
