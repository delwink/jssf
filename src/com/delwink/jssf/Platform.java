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
 * A platform which collides with a player.
 * @author David McMackins II
 */
public class Platform {
    private final String TEXTURE_NAME;
    private int x, y, w, h;
    
    /**
     * A new platform.
     * @param textureName Name of the resource used for this platform's texture.
     * @param x The x position of the platform.
     * @param y The y position of the platform.
     * @param w The width of the platform.
     * @param h The height of the platform.
     */
    public Platform(String textureName, int x, int y, int w, int h) {
        this.TEXTURE_NAME = textureName;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public String getTextureName() {
        return TEXTURE_NAME;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }
}
