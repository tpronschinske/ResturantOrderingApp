/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Travis
 */
public class DataAccessException extends Exception {
       public DataAccessException(String msg) {
        super(msg);
    }
    
    public DataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
