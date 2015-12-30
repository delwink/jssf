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
 * The velocty of some object.
 * @author David McMackins II
 */
public class Velocity extends Point {
    public Velocity() {
        super(0, 0);
    }
    
    public void changeVelocity(float x, float y) {
        super.shift(x, y);
    }
}
