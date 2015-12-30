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

import com.delwink.jssf.geom.Point;

/**
 * An object that obeys physics.
 * @author David McMackins II
 */
public abstract class AbstractPhysicalObject {
    private Acceleration acceleration;
    private Point pos, size;
    private Velocity velocity;
    
    public AbstractPhysicalObject(Point pos, Point size) {
        this(pos, size, new Velocity());
    }
    
    public AbstractPhysicalObject(Point pos, Point size, Velocity velocity) {
        this.pos = pos;
        this.size = size;
        this.velocity = velocity;
        this.acceleration = new Acceleration();
    }
    
    public void changeVelocity(float x, float y) {
        this.velocity.changeVelocity(x, y);
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
