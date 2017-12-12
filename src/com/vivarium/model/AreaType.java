package com.vivarium.model;
/**
 * 
 */
public enum AreaType {
    Desert,
    Plain,
    Water,
    Mountain;

    public static AreaType getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}