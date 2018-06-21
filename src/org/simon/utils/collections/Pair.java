/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simon.utils.collections;

/**
 *
 * @author XyRoN
 */
public class Pair <X, Y> {
    
    private X x;
    private Y y;
    
    public Pair () { }
    
    public Pair (X x, Y y) {
        this.x = x;
        this.y = y;
    }
    
    public X getFirst () {
        return x;
    }
    
    public Y getSecond () {
        return y;
    }
    
    public void setFirst (X x) {
        this.x = x;
    }
    
    public void setSecond (Y y) {
        this.y = y;
    }
    
}
