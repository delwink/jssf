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

import java.util.ArrayList;

/**
 * A Side Scroller Format file.
 * @author David McMackins II Brandon Wadkins
 */
public class SsfFile {
    private ArrayList<Background> backgrounds;
    private ArrayList<Platform> platforms;
    private Player player;
    
    public Player getPlayer() {
        return player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public Platform[] getPlatforms() {
        return this.platforms.toArray(new Platform[this.platforms.size()]);
    }
    
    public void addPlatform(Platform platform) {
        this.platforms.add(platform);
    }
    
    public void removePlatform(Platform platform) {
        this.platforms.remove(platform);
    }
    
    public Background[] getBackgrounds() {
        return this.backgrounds.toArray(new Background[this.backgrounds.size()]);
    }
    
    public void addBackground(Background background) {
        this.backgrounds.add(background);
    }
    
    public void removeBackground(Background background) {
        this.backgrounds.remove(background);
    }
}
