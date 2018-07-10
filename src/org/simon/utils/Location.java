/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.simon.utils;

/**
 * @author Emil Simon
 */

public class Location {
    
    public float x, y;
    
    
    
    public Location () {
        x = 0;
        y = 0;
    }
     
    public Location (float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public Location (Location other) {
        this.x = other.x;
        this.y = other.y;
    }
    
    
    
    public float getDistanceF (Location loc) {
        float dx = Math.abs(loc.x-this.x);
        float dy = Math.abs(loc.y-this.y);
        return (float)Math.sqrt(dx*dx + dy*dy);
    }
    
    public double getDistanceD (Location loc) {
        double dx = Math.abs(loc.x-this.x);
        double dy = Math.abs(loc.y-this.y);
        return Math.sqrt(dx*dx + dy*dy);
    }
    
    public static float getDistanceF (Location loc1,Location loc2) {
        float dx = Math.abs(loc1.x-loc2.x);
        float dy = Math.abs(loc1.y-loc2.y);
        return (float)Math.sqrt(dx*dx + dy*dy);
    }
    
    public static double getDistanceD (Location loc1,Location loc2) {
        double dx = Math.abs(loc1.x-loc2.x);
        double dy = Math.abs(loc1.y-loc2.y);
        return Math.sqrt(dx*dx + dy*dy);
    }
    
    
    
    public Location offset (float x, float y) {
        return new Location (this.x+x, this.y+y);
    }
    
    public Location offset (Location loc) {
        return new Location (this.x+loc.x, this.y+loc.y);
    }
    
    
    
    public boolean isInBounds (Location upper_left, Location lower_right) {
        return !((x < upper_left.x) || (x > lower_right.x) || (y < upper_left.y) || (y > lower_right.y));
    }
    
    public boolean isInBoundsWithDiff (Location upper_left, Location lower_right, int margin) {
        return isInBounds (new Location (upper_left.x-margin, upper_left.y-margin), new Location (lower_right.x+margin, lower_right.y+margin));
    }
    
    public boolean isInRange (Location loc, int range) {
        return (this.getDistanceF(loc) <= range);
    }
    
    
    
    @Override
    public String toString () {
        return x+","+y;
    }
}
