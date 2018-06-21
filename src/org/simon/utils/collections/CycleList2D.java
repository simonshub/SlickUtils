/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simon.utils.collections;

import java.util.ArrayList;
import java.util.List;
import org.simon.utils.SlickUtils;

/**
 *
 * @author XyRoN
 */
public class CycleList2D<T> extends ArrayList<CycleList<T>> {
    
    private int size_x;
    private int size_y;
    
    public CycleList2D (int x, int y) {
        super();
        
        size_x = x;
        size_y = y;
        
        for (int i=0;i<y;i++) {
            this.add(new CycleList<> ());
            for (int j=0;j<x;j++) {
                this.get(i).add((T) new Object ());
            }
        }
    }
    
    public CycleList2D () {
        super();
        size_x = 0;
        size_y = 0;
    }
    
    
    
    public boolean has (int x, int y) {
        try {
            get(x,y);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public T get (int x, int y) {
        if (y>=size_y || y<0) return null;
        return this.get(y).get(x);
    }
    
    public void set (int x, int y, T element) {
        this.get(y).set(x, element);
    }
    
    public void add (int x, int y, T element) {
        if (y >= this.sizeY() || y >= size_y) {
            int prev_size_y = size_y;
            size_y = y+1;
            for (int i=prev_size_y;i<size_y;i++)
                this.add(new CycleList<> ());
        }
        this.get(y).add(x, element);
        if (this.get(y).size()>size_x) size_x=this.get(y).size();
    }
    
    public void append (T element) {
        if (this.get(this.sizeY()-1).size()>size_x) size_x=this.get(this.size()-1).size();
    }
    
    public T random () {
        int x = SlickUtils.randIndex(size_x);
        int y = SlickUtils.randIndex(size_y);
        return get(x,y);
    }
    
    @Override
    public int size () {
        return size_x * size_y;
    }
    
    public int sizeX () {
        return size_x;
    }
    
    public int sizeY () {
        return size_y;
    }
    
    public List<T> collate () {
        List<T> result = new ArrayList<> ();
        for (List<T> row : this) result.addAll(row);
        return result;
    }
    
}
