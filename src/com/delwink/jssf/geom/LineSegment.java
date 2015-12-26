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
 * A line with fixed length.
 * @author David McMackins II
 */
public class LineSegment {
    private Point start, end;
    
    public LineSegment(Point start, Point end) {
        this.setPoints(start, end);
    }
    
    public LineSegment(LineSegment ls) {
        this.setLineSegment(ls);
    }
    
    public final void setPoints(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    
    public final void setLineSegment(LineSegment ls) {
        this.setPoints(ls.getStart(), ls.getEnd());
    }
    
    public void shift(float x, float y) {
        this.start.shift(x, y);
        this.end.shift(x, y);
    }
    
    public Point getIntersection(LineSegment other) {
        LineSegment diff = new LineSegment(
                new Point(this.end.getX() - this.start.getX(), this.end.getY() - this.start.getY()),
                new Point(other.end.getX() - other.start.getX(), other.end.getY() - other.start.getY()));
        
        float div = -(diff.end.getX() * diff.start.getY()) + (diff.start.getX() * diff.end.getY());
        if (div == 0)
            return null;
        
        float xDiff = this.start.getX() - other.start.getX();
        float yDiff = this.start.getY() - other.start.getY();
        float s = ((-diff.start.getY() * xDiff) + (diff.start.getX() * yDiff)) / div;
        float t = ((diff.end.getX() * yDiff) - (diff.end.getY() * xDiff)) / div;
        
        if (s >= 0 && s <= 1 && t >= 0 && t <= 1)
            return new Point(this.start.getX() + (t * diff.start.getX()),
                    this.start.getY() + (t * diff.start.getY()));
        
        return null;
    }
    
    public Point getStart() {
        return new Point(this.start);
    }
    
    public void setStart(Point start) {
        this.start = start;
    }
    
    public Point getEnd() {
        return new Point(this.end);
    }
    
    public void setEnd(Point end) {
        this.end = end;
    }
}
