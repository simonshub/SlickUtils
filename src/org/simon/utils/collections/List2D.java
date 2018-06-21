/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simon.utils.collections;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XyRoN
 */
public class List2D<T> extends ArrayList<List<T>> {
    
    public List2D (int x, int y) {
        super();
        
        for (int i=0;i<y;i++) {
            this.add(new ArrayList<> ());
            for (int j=0;j<x;j++) {
                this.get(i).add(null);
            }
        }
    }
    
    public List2D () {
        super();
    }
    
    public T get (int x, int y) {
        return this.get(y).get(x);
    }
    
    public void set (int x, int y, T element) {
        this.get(y).set(x, element);
    }
    
    public void add (int x, int y, T element) {
        this.get(y).add(x, element);
    }
    
    public void append (T element) {
        this.get(this.size()-1).add(this.get(this.size()-1).size()-1, element);
    }
    
}
