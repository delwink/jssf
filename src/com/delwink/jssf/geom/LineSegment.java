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
    public static final double RIGHT_ANGLE = Math.PI / 2;
    
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
        LineSegment l1 = this;
        LineSegment l2 = other;
        
        float deltaX1 = l1.end.getX() - l1.start.getX();
        float deltaY1 = l1.end.getY() - l1.start.getY();
        float deltaX2 = l2.end.getX() - l2.start.getX();
        float deltaY2 = l2.end.getY() - l2.start.getY();
        
        float div = (deltaX1 * deltaY2) - (deltaX2 * deltaY1);
        if (div == 0)
            return null; // this can happen if the lines are collinear!
        
        float xDiff = l1.start.getX() - l2.start.getX();
        float yDiff = l1.start.getY() - l2.start.getY();
        float s = ((deltaX1 * yDiff) - (deltaY1 * xDiff)) / div;
        float t = ((deltaX2 * yDiff) - (deltaY2 * xDiff)) / div;
        
        if (s >= 0 && s <= 1 && t >= 0 && t <= 1)
            return new Point(l1.start.getX() + (t * deltaX1), l1.start.getY() + (t * deltaY1));
        
        return null;
    }
    
    public float getAngle() {
        float deltaX = this.end.getX() - this.start.getX();
        float deltaY = this.end.getY() - this.start.getY();
        
        return (float) Math.toDegrees(Math.atan2(deltaY, deltaX));
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
