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

/**
 * The player character.
 * @author David McMackins II
 */
public class Player {
    private final String TEXTURE_NAME;
    private float x, y, w, h;
    
    public Player(String textureName, float x, float y, float w, float h) {
        this.TEXTURE_NAME = textureName;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    public String getTextureName() {
        return this.TEXTURE_NAME;
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

    public float getW() {
        return this.w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public float getH() {
        return this.h;
    }

    public void setH(float h) {
        this.h = h;
    }
}
