/*
 * jssf - Java Side Scroller Format library
 * Copyright (C) 2015-2016 Delwink, LLC
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

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * A line with fixed length.
 * @author David McMackins II
 */
public class LineSegment extends Line2D.Double {
    public LineSegment(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }
    
    public LineSegment(Point2D start, Point2D end) {
        super(start, end);
    }
    
    public void shift(double x, double y) {
        this.setLine(x + this.getX1(), y + this.getY1(),
                x + this.getX2(), y + this.getY2());
    }
    
    public Point2D.Double getIntersection(LineSegment l2) {
        LineSegment l1 = this;
        
        double deltaX1 = l1.getX2() - l1.getX1();
        double deltaY1 = l1.getY2() - l1.getY1();
        double deltaX2 = l2.getX2() - l2.getX1();
        double deltaY2 = l2.getY2() - l2.getY1();
        
        double div = (deltaX1 * deltaY2) - (deltaX2 * deltaY1);
        if (div == 0)
            return null; // this can happen if the lines are collinear!
        
        double xDiff = l1.getX1() - l2.getX1();
        double yDiff = l1.getY1() - l2.getY1();
        double s = ((deltaX1 * yDiff) - (deltaY1 * xDiff)) / div;
        double t = ((deltaX2 * yDiff) - (deltaY2 * xDiff)) / div;
        
        if (s >= 0 && s <= 1 && t >= 0 && t <= 1)
            return new Point2D.Double(l1.getX1() + (t * deltaX1), l1.getY1() + (t * deltaY1));
        
        return null;
    }
    
    public double getAngle() {
        double deltaX = this.getX2() - this.getX1();
        double deltaY = this.getY2() - this.getY1();
        
        return Math.toDegrees(Math.atan2(deltaY, deltaX));
    }
}
