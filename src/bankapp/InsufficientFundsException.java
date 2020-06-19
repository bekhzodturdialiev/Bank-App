/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

/**
 *
 * @author Shaxzod
 */
public class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {
        super("You have insufficiant funds to complete the transaction");
    }
    
}
