package com.bridgelabz.cabInvoiceGenerator;

public class InvoiceException extends Exception{
    enum ExceptionType{
        INVALID_USERID,INCORRECT_TOTAL_FARE;
    }
    ExceptionType exceptionType;
    public InvoiceException(String message,ExceptionType exceptionType){
        super(message);
        this.exceptionType=exceptionType;
    }
}
