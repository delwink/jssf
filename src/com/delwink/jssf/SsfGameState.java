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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * A Side Scroller Format file.
 * @authors David McMackins II, Brandon Wadkins
 */
public class SsfGameState {
    private final ArrayList<Background> BACKGROUNDS = new ArrayList<>();
    private final ArrayList<Platform> PLATFORMS = new ArrayList<>();
    private final ArrayList<SpawnPoint> SPAWNS = new ArrayList<>();
    private Player player = null;
    
    /**
     * Opens an SSF file.
     * @param file The file to open.
     * @throws FileNotFoundException if the file does not exist.
     * @throws IOException if there is an error reading the file.
     * @throws ParserConfigurationException if there is an error parsing the XML.
     * @throws SAXException if there is an error parsing the XML.
     */
    public SsfGameState(File file)
            throws FileNotFoundException, IOException, ParserConfigurationException, SAXException {
        if (!file.isFile())
            throw new IllegalArgumentException(file.getAbsolutePath() + " is not a regular file");
        
        StringBuilder fileData = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            char[] buf = new char[1024];
            int numRead;
            while ((numRead = reader.read(buf)) != -1) {
                String portion = String.valueOf(buf, 0, numRead);
                fileData.append(portion);
            }
        }
        
        this.loadString(fileData.toString());
    }
    
    /**
     * Reads an SSF-formatted string.
     * @param s The string to read.
     * @throws IOException if there is an error reading the file.
     * @throws ParserConfigurationException if there is an error parsing the XML.
     * @throws SAXException if there is an error parsing the XML.
     */
    public SsfGameState(String s)
            throws ParserConfigurationException, SAXException, IOException {
        this.loadString(s);
    }
    
    protected final void loadString(String s)
            throws ParserConfigurationException, SAXException, IOException {
        Document doc = stringToDoc(s);
        Element root = doc.getDocumentElement();
        
        NodeList nodes = root.getElementsByTagName("spawn");
        int len = nodes.getLength();
        if (len == 0)
            throw new IllegalStateException("Must be at least one spawn point");
        
        for (int i = 0; i < len; ++i) {
            Node n = nodes.item(i);
            NamedNodeMap attributes = n.getAttributes();
            
            int x = attrToInt(attributes, "x");
            int y = attrToInt(attributes, "y");
            
            this.SPAWNS.add(new SpawnPoint(x, y));
        }
        
        nodes = root.getElementsByTagName("bg");
        len = nodes.getLength();
        for (int i = 0; i < len; ++i) {
            Node n = nodes.item(i);
            NamedNodeMap attributes = n.getAttributes();
            
            String name = attributes.getNamedItem("path").getNodeValue();
            int layer = attrToInt(attributes, "layer");
            
            this.BACKGROUNDS.add(new Background(name, layer));
        }
        
        nodes = root.getElementsByTagName("platform");
        len = nodes.getLength();
        for (int i = 0; i < len; ++i) {
            Node n = nodes.item(i);
            NamedNodeMap attributes = n.getAttributes();
            
            String texture = attributes.getNamedItem("texture").getNodeValue();
            int x = attrToInt(attributes, "x");
            int y = attrToInt(attributes, "y");
            int w = attrToInt(attributes, "w");
            int h = attrToInt(attributes, "h");
            
            this.PLATFORMS.add(new Platform(texture, x, y, w, h));
        }
    }
    
    private static int attrToInt(NamedNodeMap attrs, String name) {
        return Integer.parseInt(attrs.getNamedItem(name).getNodeValue());
    }
    
    private static Document stringToDoc(String xml)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new InputSource(new StringReader(xml)));
    }
    
    public ArrayList<Platform> getPlatforms() {
        return this.PLATFORMS;
    }
    
    public void addPlatform(Platform platform) {
        this.PLATFORMS.add(platform);
    }
    
    public void removePlatform(Platform platform) {
        this.PLATFORMS.remove(platform);
    }
    
    public ArrayList<Background> getBackgrounds() {
        return this.BACKGROUNDS;
    }
    
    public void addBackground(Background background) {
        this.BACKGROUNDS.add(background);
    }
    
    public void removeBackground(Background background) {
        this.BACKGROUNDS.remove(background);
    }
    
    public ArrayList<SpawnPoint> getSpawnPoints() {
        return this.SPAWNS;
    }
    
    public void addSpawnPoint(SpawnPoint spawnPoint) {
        this.SPAWNS.add(spawnPoint);
    }
    
    public void removeSpawnPoint(SpawnPoint spawnPoint) {
        this.SPAWNS.remove(spawnPoint);
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
