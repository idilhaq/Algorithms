/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moga;

/**
 *
 * @author idilhaq
 */
public class Adj_Node {

    private final Node Start;
    private final Link Link;
    private final Node End;

    public Adj_Node(Node Start, Node End, Link Link) {
        this.Start = Start;
        this.Link = Link;
        this.End = End;
    }

    /**
     * @return the Start
     */
    public Node getStart() {
        return Start;
    }

    /**
     * @return the Link
     */
    public Link getLink() {
        return Link;
    }

    /**
     * @return the End
     */
    public Node getEnd() {
        return End;
    }
}
