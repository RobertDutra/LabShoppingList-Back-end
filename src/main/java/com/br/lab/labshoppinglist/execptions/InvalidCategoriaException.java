package com.br.lab.labshoppinglist.execptions;

public class InvalidCategoriaException extends Exception{

    private String message;

    public InvalidCategoriaException(String message) {
        super(message);
        this.message = message;
    }
}
