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
 * A background image for a stage.
 * @author David McMackins II
 */
public class Background {
    private final int LAYER;
    private final String NAME;
    
    /**
     * A new background image reference.
     * @param name The name of the resource for the image.
     * @param layer The layer of the background.
     */
    public Background(String name, int layer) {
        if (layer < 1)
            throw new IllegalArgumentException(String.valueOf(layer) + " is not a positive layer");
        
        if (name.isEmpty())
            throw new IllegalArgumentException("Background name cannot be empty");
        
        this.LAYER = layer;
        this.NAME = name;
    }
    
    public int getLayer() {
        return this.LAYER;
    }
    
    public String getResourceName() {
        return this.NAME;
    }
}
