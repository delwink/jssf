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

package com.delwink.jssf;

import java.awt.geom.Point2D;

/**
 * An object that obeys physics.
 * @author David McMackins II
 */
public abstract class AbstractPhysicalObject {
    private Acceleration acceleration;
    private Point2D.Double pos, size;
    private Velocity velocity;
    
    public AbstractPhysicalObject(Point2D.Double pos, Point2D.Double size) {
        this(pos, size, new Velocity());
    }
    
    public AbstractPhysicalObject(Point2D.Double pos, Point2D.Double size, Velocity velocity) {
        this.pos = pos;
        this.size = size;
        this.velocity = velocity;
        this.acceleration = new Acceleration();
    }
    
    public void changeVelocity(float x, float y) {
        this.velocity.changeVelocity(x, y);
    }
    
    public Point2D.Double getPos() {
        return new Point2D.Double(this.pos.getX(), this.pos.getY());
    }
    
    public void setPos(Point2D.Double pos) {
        this.pos = pos;
    }
    
    public Point2D.Double getSize() {
        return new Point2D.Double(this.size.getX(), this.size.getY());
    }
    
    public void setSize(Point2D.Double size) {
        this.size = size;
    }
}
