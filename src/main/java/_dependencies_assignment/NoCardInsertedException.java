/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _dependencies_assignment;

/**
 *
 * @author mathiasjepsen
 */
public class NoCardInsertedException extends Exception {

    public NoCardInsertedException(String errorMessage) {
        super(errorMessage);
    }
    
}
