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
 * A listener for updating progress meters.
 * @author David McMackins II
 */
public interface ProgressListener {
    /**
     * Operation to be performed if the action is cancelled.
     */
    public void onCancel();
    
    /**
     * Action to take when progress is made.
     * @param percent Percent of total work complete.
     * @param text Text regarding the progress.
     * @param comment An additional comment.
     */
    public void setProgress(float percent, final String text, final String comment);
}
