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

public class Rectangle {
    private Point pos, size;
    
    public Rectangle(Point pos, Point size) {
        this.setRectangle(pos, size);
    }
    
    public Rectangle(Rectangle r) {
        this.setRectangle(r);
    }
    
    public final void setRectangle(Point pos, Point size) {
        this.pos = pos;
        this.size = size;
    }
    
    public final void setRectangle(Rectangle r) {
        this.pos = r.getPos();
        this.size = r.getSize();
    }
    
    public void shift(float x, float y) {
        this.pos.shift(x, y);
    }
    
    public void grow(float x, float y) {
        this.size.shift(x, y);
    }
    
    public Point getPos() {
        return new Point(this.pos);
    }
    
    public void setPos(Point pos) {
        this.pos = pos;
    }
    
    public Point getSize() {
        return new Point(this.size);
    }
    
    public void setSize(Point size) {
        this.size = size;
    }
}
