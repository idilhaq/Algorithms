/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moga;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author idilhaq
 */
public class MOGA {

    //Obtaining Node, Adjacent Node, and Link Information
    public MOGA() {

    }

    //Evaluate Fitness (Distance, Time, Safety Value)
    public void evalDist() {

    }

    public void evalTime() {

    }

    public void evalSafe() {

    }

    //Selection
    public void select() {

    }

    //Crossover
    public void crossOver() {

    }

    //Mutation
    public void mutation() {

    }

    //Termination
    public void termination() {

    }

    

    public static void main(String[] args) {
        MOGA moga = new MOGA();
        //Define the data
        String[] node = {"Node 1", "Node 2", "Node 3", "Node 4", "Node 5", "Node 6", "Node 7", "Node 8", "Node 9", "Node 10"};
        String[] link = {"Link 0", "Link 1", "Link 2", "Link 3", "Link 4", "Link 5", "Link 6", "Link 7", "Link 8", "Link 9", "Link 10", "Link 11", "Link 12", "Link 13", "Link 14"};
        int[] distance = {40, 80, 65, 60, 75, 50, 100, 60, 30, 30, 60, 60, 30, 60, 30};
        //create Link Information
        Link[] Link_info = new Link[link.length];
        for (int i = 0; i < link.length; i++) {
            Link_info[i] = new Link(link[i], distance[i], 1, 1, 1);
        }
        //Node
        Node[] Nodes = new Node[node.length + 1];
        for (int i = 0; i < node.length; i++) {
            Nodes[i + 1] = new Node(node[i]);
        }
        //Create Adjacent_Node
        List<Adj_Node> AdjNodes = new ArrayList<Adj_Node>();
        Adj_Node Adj_Node_1 = new Adj_Node(Nodes[1], Nodes[2], Link_info[13]);
        AdjNodes.add(Adj_Node_1);
        Adj_Node Adj_Node_2 = new Adj_Node(Nodes[1], Nodes[7], Link_info[6]);
        AdjNodes.add(Adj_Node_2);
        Adj_Node Adj_Node_3 = new Adj_Node(Nodes[2], Nodes[3], Link_info[11]);
        AdjNodes.add(Adj_Node_3);
        Adj_Node Adj_Node_4 = new Adj_Node(Nodes[2], Nodes[4], Link_info[12]);
        AdjNodes.add(Adj_Node_4);
        Adj_Node Adj_Node_5 = new Adj_Node(Nodes[3], Nodes[5], Link_info[8]);
        AdjNodes.add(Adj_Node_5);
        Adj_Node Adj_Node_6 = new Adj_Node(Nodes[3], Nodes[4], Link_info[10]);
        AdjNodes.add(Adj_Node_6);
        Adj_Node Adj_Node_7 = new Adj_Node(Nodes[4], Nodes[6], Link_info[9]);
        AdjNodes.add(Adj_Node_7);
        Adj_Node Adj_Node_8 = new Adj_Node(Nodes[5], Nodes[10], Link_info[4]);
        AdjNodes.add(Adj_Node_8);
        Adj_Node Adj_Node_9 = new Adj_Node(Nodes[5], Nodes[6], Link_info[7]);
        AdjNodes.add(Adj_Node_9);
        Adj_Node Adj_Node_10 = new Adj_Node(Nodes[6], Nodes[8], Link_info[5]);
        AdjNodes.add(Adj_Node_10);
        Adj_Node Adj_Node_11 = new Adj_Node(Nodes[7], Nodes[8], Link_info[3]);
        AdjNodes.add(Adj_Node_11);
        Adj_Node Adj_Node_12 = new Adj_Node(Nodes[7], Nodes[9], Link_info[1]);
        AdjNodes.add(Adj_Node_12);
        Adj_Node Adj_Node_13 = new Adj_Node(Nodes[8], Nodes[9], Link_info[14]);
        AdjNodes.add(Adj_Node_13);
        Adj_Node Adj_Node_14 = new Adj_Node(Nodes[8], Nodes[10], Link_info[2]);
        AdjNodes.add(Adj_Node_14);
        Adj_Node Adj_Node_15 = new Adj_Node(Nodes[9], Nodes[10], Link_info[0]);
        AdjNodes.add(Adj_Node_15);

        Adj_Node_15.getLink().getDistance();

        int pop_size = 1;
        Individual[] individual = new Individual[pop_size];
        Node Departure = Nodes[1];
        Node Destination = Nodes[10];
        Population pop = new Population(pop_size, AdjNodes);
        individual = pop.generatePopulation(Departure, Destination);
        for (int i = 0; i < individual.length; i++) {
            System.out.print(individual[i].getDeparture().getId() + " - ");
            for (int j = 0; j < individual[i].getViaNode().size(); j++) {
                System.out.print(individual[i].getViaNode().get(j).getId() + " - ");
            }
            System.out.println(individual[i].getDestination().getId());
            System.out.println("Size = " + individual[i].getLength());
            System.out.println("Distance = " + pop.getDistance(individual[i]));
            System.out.println("Evacuation Time = " + pop.getEvacuationTime(individual[i]));
        }
        
        //Get Link Information
        /*
        System.out.println(pop.getLinkInfo(Nodes[1], Nodes[2], AdjNodes, "Distance"));
        System.out.println(pop.getLinkInfo(Nodes[1], Nodes[2], AdjNodes, "Walking Speed"));
        System.out.println(pop.getLinkInfo(Nodes[1], Nodes[2], AdjNodes, "Safety"));
        System.out.println(pop.getLinkInfo(Nodes[1], Nodes[2], AdjNodes, "Pedestrian Traffic"));
        */ 
        //get nodes in individual
        /*
        for (int i = 0; i < individual.length; i++) {
            for (int j = 0; j < individual[i].getLength(); j++) {
                System.out.print(individual[i].getNodes().get(j).getId() + " - ");                
            }
            System.out.println("===========");
        }
        */

    }
}
