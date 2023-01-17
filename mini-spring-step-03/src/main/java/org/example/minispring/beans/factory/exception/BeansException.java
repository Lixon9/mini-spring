package org.example.minispring.beans.factory.exception;

/**
 * @author lks
 */
public class BeansException extends RuntimeException{

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeansException(String message) {
        super(message);
    }
}
