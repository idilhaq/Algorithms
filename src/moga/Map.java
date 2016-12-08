/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moga;

import java.util.List;

/**
 *
 * @author idilhaq
 */
public class Map {

    private final List<Node> nodes;
    private final List<Link> links;

    public Map(List<Node> nodes, List<Link> links) {
        this.nodes = nodes;
        this.links = links;
    }
    
    public List<Node> getNodes(){
        return nodes;
    }
    
    public List<Link> getLinks(){
        return links;
    }
}
