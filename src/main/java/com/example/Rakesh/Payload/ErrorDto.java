package com.example.Rakesh.Payload;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

public class ErrorDto {

    public String message;

    public Date date;

    public String description;

    public ErrorDto(String message, Date date, String description){
        this.message = message;
        this.date=date;
        this.description = description;
    }


    public String getMessage(){
        return message;
    }

    public Date getDate(){
        return date;
    }

    public String getDescription(){
        return description;
    }
}
