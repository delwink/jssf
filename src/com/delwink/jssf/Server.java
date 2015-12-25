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

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

/**
 * An SSF Protocol server connection.
 * @author David McMackins II
 */
public interface Server {
    /**
     * Initializes communication to the SSFP server.
     * @throws ConnectException if the connection could not be established.
     * @throws UnknownHostException if the server's hostname could not be resolved.
     */
    public void connect() throws ConnectException, UnknownHostException;
    
    /**
     * Closes the connection to the server.
     */
    public void disconnect();
    
    /**
     * Attempts reconnection to the server in the event of failure.
     * @throws ConnectException if the connection could not be established.
     * @throws UnknownHostException if the server's hostname could not be resolved.
     */
    public void reconnect() throws ConnectException, UnknownHostException;
    
    /**
     * Requests the current level state from the server.
     * @return A description of the level state as determined by the server.
     * @throws IllegalStateException if the server's response is malformed.
     * @throws IOException if there is an error making the request.
     */
    public SsfGameState getState() throws IllegalStateException, IOException;
    
    /**
     * Downloads all needed resources from the server into a local cache.
     * @param pl A listener for the progress of this download.
     * @throws IOException if an error occurs while getting the resources.
     */
    public void downloadResources(ProgressListener pl) throws IOException;
    
    /**
     * Tries to move the player to the left.
     * @throws IOException if an error occurs while communicating with the server.
     */
    public void moveLeft() throws IOException;
    
    /**
     * Tries to move the player to the right.
     * @throws IOException if an error occurs while communicating with the server.
     */
    public void moveRight() throws IOException;
    
    /**
     * Tries to make the player jump.
     * @throws IOException if an error occurs while communicating with the server.
     */
    public void jump() throws IOException;
    
    /**
     * Tries to make the player crouch.
     * @throws IOException if an error occurs while communicating with the server.
     */
    public void crouch() throws IOException;
}
