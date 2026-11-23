package org.codewiththamsanqa.springboot_app_people.exceptions;

public class ResponseException extends RuntimeException{

    public ResponseException(String msg){
        super(msg);
    }
}
