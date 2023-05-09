
package com.example.theoregontrail_masonandholden;


import java.io.Serializable;

/**
 * The Entity class holds the values that represent each party member's sick, injured, and death status.
 * @filename OregonTrailMasonandHolden
 * @author Holden Cubberley & Mason Muether
 * @date 5/9/2023
 */
public class Entity implements Serializable {

    // Initializing the public values.
    public boolean sick = false;
    public boolean injured = false;
    public boolean dead = false;

    public String name = "";

    /**
     * Entity
     * Constructor
     * Creates and holds the name string along with the boolean values regarding sick, injured, and dead status.
     */
    public Entity(String name, boolean sick, boolean injured, boolean dead) {

        this.name = name;
        this.sick = sick;
        this.injured = injured;
        this.dead = dead;
    }
}
