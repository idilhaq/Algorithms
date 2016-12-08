/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moga;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author idilhaq
 */
public class Population {
    private final int size;

    public Population(int size) {
        this.size = size;
    }
    
    public List<Node> getNeighbors(Node node, List<Adj_Node> adjNode) {
        List<Node> listAdjNode = new ArrayList<>();
        for (int i = 0; i < adjNode.size(); i++) {
            if (node.equals(adjNode.get(i).getStart())) {
                listAdjNode.add(adjNode.get(i).getEnd());
            } else if (node.equals(adjNode.get(i).getEnd())) {
                listAdjNode.add(adjNode.get(i).getStart());
            }
        }
        return listAdjNode;
    }

    public List<Node> generateIndividual(Node Departure, Node Destination, List<Adj_Node> adjNode) {
        List<Node> path = new ArrayList<>();
        Node next = Departure;
        Random rnd = new Random();
        //add the departure node
        path.add(Departure);
        //iteration until containing the destination node
        while (!getNeighbors(next, adjNode).contains(Destination)) {
            List<Node> listAdjNode = getNeighbors(next, adjNode);
            int random = rnd.nextInt(listAdjNode.size());
            Node nextNode = listAdjNode.get(random);
            if (path.contains(nextNode)) {
                while (path.contains(nextNode)) {
                    listAdjNode.remove(random);
                    random = rnd.nextInt(listAdjNode.size());
                    nextNode = listAdjNode.get(random);
                }
                path.add(nextNode);
            } else {
                path.add(nextNode);
            }
            next = nextNode;
            listAdjNode.clear();
        }
        //remove the departure node
        path.remove(0);
        return path;
    }
    
    public Individual[] generatePopulation(int pop_size, Node Departure, Node Destination, List<Adj_Node> AdjNodes){
        Individual[] ind = new Individual[pop_size];
        for (int i = 0; i < pop_size; i++){
            List<Node> viaNode = generateIndividual(Departure, Destination, AdjNodes);
            ind[i] = new Individual(Departure, viaNode, Destination);
        }
        return ind;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }
}
