/*
 * jssf - Java Side Scroller Format library
 * Copyright (C) 2015 Delwink, LLC
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, version 3 only.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.delwink.jssf.geom;

/**
 * A two-dimensional point.
 * @author David McMackins II
 */
public class Point {
    private float x, y;
    
    public Point(float x, float y) {
        this.setPoint(x, y);
    }
    
    public Point(Point p) {
        this.setPoint(p);
    }
    
    public final void setPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public final void setPoint(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }
    
    public void shift(float x, float y) {
        this.x += x;
        this.y += y;
    }
    
    @Override
    public String toString() {
        return String.format("(%f, %f)", this.x, this.y);
    }
    
    public float getX() {
        return this.x;
    }
    
    public void setX(float x) {
        this.x = x;
    }
    
    public float getY() {
        return this.y;
    }
    
    public void setY(float y) {
        this.y = y;
    }
}
