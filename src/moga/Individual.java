/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moga;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 *
 * @author idilhaq
 */
public class Individual {

    private Node Departure;
    private Node Destination;
    private List<Node> viaNode = new ArrayList<>();

    public Individual(Node Departure, List<Node> viaNode, Node Destination) {
        this.Departure = Departure;
        this.Destination = Destination;
        this.viaNode = viaNode;
    }    

    public Node getDeparture() {
        return Departure;
    }

    public Node getDestination() {
        return Destination;
    }
        
    public List<Node> getViaNode() {
        return viaNode;
    }    

    public int getLength() {
        int length = 0;
        length = viaNode.size() + 2;
        return length;
    }
    
    public List<Node> getNodes(){
        List<Node> nodes = new ArrayList<>();
        nodes.add(Departure);
        for(int i = 0; i < viaNode.size(); i++){
            nodes.add(viaNode.get(i));
        }
        nodes.add(Destination);
        return nodes;
    }
}
