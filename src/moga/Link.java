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
public class Link {

    private String Id;
    private int Distance;
    private final double avg_walking_speed;
    private final double pedestrian_traffic;
    private final double curr_safety;

    public Link(String Id, int Distance, double avg_walking_speed, double pedestrian_traffic, double curr_safety) {
        this.Id = Id;
        this.Distance = Distance;
        this.avg_walking_speed = avg_walking_speed;        
        this.pedestrian_traffic = pedestrian_traffic;
        this.curr_safety = curr_safety;
    }

    /**
     * @return the Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @return the Distance
     */
    public int getDistance() {
        return Distance;
    }

    /**
     * @return the avg_walking_speed
     */
    public double getAvg_walking_speed() {
        return avg_walking_speed;
    }

    /**
     * @return the pedestrian_traffic
     */
    public double getPedestrian_traffic() {
        return pedestrian_traffic;
    }

    /**
     * @return the curr_safety
     */
    public double getCurr_safety() {
        return curr_safety;
    }
    
    
}
