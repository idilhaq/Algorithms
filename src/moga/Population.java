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

    private final int pop_size;
    private final List<Adj_Node> AdjNodes;

    public Population(int pop_size, List<Adj_Node> AdjNodes) {
        this.pop_size = pop_size;
        this.AdjNodes = AdjNodes;
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

    public Individual[] generatePopulation(Node Departure, Node Destination) {
        Individual[] ind = new Individual[pop_size];
        for (int i = 0; i < pop_size; i++) {
            List<Node> viaNode = generateIndividual(Departure, Destination, AdjNodes);
            ind[i] = new Individual(Departure, viaNode, Destination);
        }
        return ind;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return pop_size;
    }

    public double getDistance(Individual individual) {
        individual.getNodes();
        double distance = 0;
        for (int i = 0; i < (individual.getLength() - 1); i++) {
            distance += getLinkInfo(individual.getNodes().get(i), individual.getNodes().get(i + 1), AdjNodes, "Distance");
        }
        return distance;
    }

    public double getEvacuationTime(Individual individual) {
        individual.getNodes();
        double evac_time = 0;
        for (int i = 0; i < (individual.getLength() - 1); i++) {
            double distance = getLinkInfo(individual.getNodes().get(i), individual.getNodes().get(i + 1), AdjNodes, "Distance");
            double walking_speed = getLinkInfo(individual.getNodes().get(i), individual.getNodes().get(i + 1), AdjNodes, "Walking Speed");
            evac_time += distance / walking_speed;
        }
        return evac_time;
    }

    public double getLinkInfo(Node Start, Node End, List<Adj_Node> adjNode, String info) {
        double value = 0;
        for (int i = 0; i < adjNode.size(); i++) {
            if (adjNode.get(i).getStart().equals(Start) && adjNode.get(i).getEnd().equals(End)) {
                switch (info) {
                    case "Distance":
                        value = adjNode.get(i).getLink().getDistance();
                        break;
                    case "Walking Speed":
                        value = adjNode.get(i).getLink().getAvg_walking_speed();
                        break;
                    case "Safety":
                        value = adjNode.get(i).getLink().getCurr_safety();
                        break;
                    case "Pedestrian Traffic":
                        value = adjNode.get(i).getLink().getPedestrian_traffic();
                        break;
                    default:
                        System.out.println("Error! Choose the correct options!");
                }
            }
        }
        return value;
    }
}
