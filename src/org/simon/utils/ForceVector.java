/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.simon.utils;

/**
 * @author Emil Simon
 */

public class ForceVector {
    public float x;
    public float y;
    
    public ForceVector () {
        x = 0;
        y = 0;
    }
    
    public ForceVector (float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean isNone () {
        return (x==0) && (y==0);
    }
    
    @Override
    public String toString () {
        return x+","+y;
    }
    
    public void fromString (String str) {
        String[] args = str.trim().split(",");
        if (args.length == 2) {
            x = Float.parseFloat(args[0].trim());
            y = Float.parseFloat(args[1].trim());
        }
    }
}
