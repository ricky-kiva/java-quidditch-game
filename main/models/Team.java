package main.models;

import java.util.Arrays;

public class Team {

    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";

    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers;

    public Team(String house, String keeper, String seeker, String[] chasers) {
        if (house.isBlank() || keeper.isBlank() || seeker.isBlank() ||
        house == null || keeper == null || seeker == null) {
            throw new IllegalArgumentException("All names cannot be blank!");
        }
        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;

        if (chasers.length != 3 || Team.hasNullOrBlank(chasers)) {
            throw new IllegalArgumentException("Chasers must contain 3 eligible players (no null anonymous)!");
        }

        this.chasers = Arrays.copyOf(chasers, 3);
    }

    public Team(Team source) {
        this.house = source.house;
        this.keeper = source.keeper;
        this.seeker = source.seeker;
        this.chasers = Arrays.copyOf(source.chasers, source.chasers.length);
    }

    public static boolean hasNullOrBlank(String[] chasers) {
        return Arrays.stream(chasers).anyMatch(chaser -> chaser == null) ||
        Arrays.stream(chasers).anyMatch(chaser -> chaser.isBlank());
    }
    
    public String getHouse() {
        return this.house;
    }

    public String getKeeper() {
        return this.keeper;
    }

    public String getSeeker() {
        return this.seeker;
    }

    public String[] getChasers() {
        return Arrays.copyOf(this.chasers, this.chasers.length);
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setKeeper(String keeper) {
        this.keeper = keeper;
    }

    public void setSeeker(String seeker) {
        this.seeker = seeker;
    }

    public void setChasers(String[] chasers) {
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

     public static String getPositionChaser() {
         return POSITION_CHASER;
     }

     public static String getPositionSeeker() {
         return POSITION_SEEKER;
     }

     public static String getPositionKeeper() {
         return POSITION_KEEPER;
     }

     @Override
     public String toString() {
        return "House: " + this.house + "\n" +
        "Keeper: " + this.keeper + "\n" +
        "Seeker: " + this.seeker + "\n" +
        "Chasers: " + Arrays.toString(this.chasers) + "\n";
     }

}
