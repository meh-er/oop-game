package org.uob.a2.gameobjects;

public class Equipment extends GameObject implements Usable {

    protected UseInformation useInformation;

    public Equipment(String id, String name, String description, boolean hidden, UseInformation useInformation){
        super(id, name, description, hidden);
        this.useInformation = useInformation;
    }

    public void setUseInformation(UseInformation useInformation){
        this.useInformation = useInformation;
    }

    public UseInformation getUseInformation(){
        return useInformation;
    }

    /**
     * Returns a string representation of this equipment, including the attributes inherited from {@code GameObject}
     * and the associated use information.
     *
     * @return a string describing the equipment
     */
    public String use(GameObject target, GameState gameState){
        Room room = gameState.getMap().getCurrentRoom();
        if (useInformation.isUsed()) {
            return "You have already used this!";
        }

        useInformation.setUsed(true);

        // find and reveal hidden items in the container
        for (Item item : room.getItems()) {
            if (item.getId().equals(useInformation.getResult())) {
                item.setHidden(false);
            }
        }


        return useInformation.getMessage();
    }

    @Override
    public String toString() {
        return super.toString() + ", useInformation=" + useInformation;
    }
}
