package org.uob.a2.gameobjects;

/**
 * Represents an interface for objects that can be used within the game.
 * 
 * <p>
 * Objects implementing this interface must define methods to manage their use
 * information and provide their name.
 * </p>
 */
public interface Usable {

     void setUseInformation(UseInformation useInformation);
     UseInformation getUseInformation();
     String getName();
}

//public void setUseInformation(UseInformation useInformation) {
  //  this.useInformation = useInformation;
//}

//private UseInformation useInformation;



