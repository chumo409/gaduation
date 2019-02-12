package com.yhl.util;

import javafx.scene.input.DataFormat;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataToString implements Converter<Date,String> {
    public String convert(Date source) {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = df.format(source);
        //System.out.println(format);
        return df.format(source);
    }
}
