/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;

/**
 *
 * @author idilhaq
 */
public class Vertex {
        final private String id;
        final private String name;


        public Vertex(String id, String name) {
                this.id = id;
                this.name = name;
        }
        public String getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        @Override
        public String toString() {
                return name;
        }

}
