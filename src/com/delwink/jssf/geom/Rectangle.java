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

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Rectangle extends Rectangle2D.Double {
    public Rectangle(double x, double y, double w, double h) {
        super(x, y, w, h);
    }
    
    public Rectangle(Point2D pos, Point2D size) {
        super(pos.getX(), pos.getY(), size.getX(), size.getY());
    }
    
    public ArrayList<Point2D.Double> getIntersection(LineSegment ls) {
        ArrayList<Point2D.Double> intersected = new ArrayList<>();
        LineSegment[] lines = this.getLines();
        
        for (LineSegment line : lines) {
            Point2D.Double p = line.getIntersection(ls);
            if (p != null && !intersected.contains(p))
                intersected.add(p);
        }
        
        if (intersected.isEmpty())
            return null;
        
        return intersected;
    }
    
    public ArrayList<Point2D.Double> getIntersection(Rectangle r2) {
        ArrayList<Point2D.Double> intersected = new ArrayList<>();
        LineSegment[] l1s = this.getLines(), l2s = r2.getLines();
        
        for (LineSegment l1 : l1s)
            for (LineSegment l2 : l2s) {
                Point2D.Double p = l1.getIntersection(l2);
                if (p != null && !intersected.contains(p))
                    intersected.add(p);
            }
        
        return intersected;
    }
    
    public LineSegment[] getLines() {
        Point2D.Double endPoint = new Point2D.Double(this.getX() + this.getWidth(),
                this.getY() + this.getHeight());
        
        LineSegment lines[] = {
            new LineSegment(this.getX(), this.getY(), endPoint.getX(), this.getY()),
            new LineSegment(this.getX(), this.getY(), this.getX(), endPoint.getY()),
            new LineSegment(this.getX(), endPoint.getY(), endPoint.getX(), endPoint.getY()),
            new LineSegment(endPoint.getX(), this.getY(), endPoint.getX(), endPoint.getY())
        };
        
        return lines;
    }
}
