
public class OutfieldPlayer extends Player {

    private int pace;
    private int shooting;
    private int passing;
    private int dribbling;
    private int defending;
    private int physical;

    public OutfieldPlayer(
            String playerId,
            String firstName,
            String lastName,
            String position,
            int currentOVR,
            int level,
            int maxLevel,
            int baseOVR,
            boolean isStarter,
            String specialRole,
            //OutfieldPlayer abilities:
            int pace,
            int shooting,
            int passing,
            int dribbling,
            int defending,
            int physical
    ) {

        super(
                playerId,
                firstName,
                lastName,
                position,
                currentOVR,
                level,
                maxLevel,
                baseOVR,
                isStarter,
                specialRole
        );

        this.pace = pace;
        this.shooting = shooting;
        this.passing = passing;
        this.dribbling = dribbling;
        this.defending = defending;
        this.physical = physical;
    }

    public String getCoreStrength() {
        int max = pace;
        String strength = "Pace";

        if (shooting > max) {
            max = shooting;
            strength = "Shooting";
        }
        if (passing > max) {
            max = passing;
            strength = "Passing";
        }
        if (dribbling > max) {
            max = dribbling;
            strength = "Dribbling";
        }
        if (defending > max) {
            max = defending;
            strength = "Defending";
        }
        if (physical > max) {
            max = physical;
            strength = "Physical";
        }
        return strength;
    }

    public String getCoreWeakness() {
        int min = pace;
        String weakness = "Pace";

        if (shooting < min) {
            min = shooting;
            weakness = "Shooting";
        }
        if (passing < min) {
            min = passing;
            weakness = "Passing";
        }
        if (dribbling < min) {
            min = dribbling;
            weakness = "Dribbling";
        }
        if (defending < min) {
            min = defending;
            weakness = "Defending";
        }
        if (physical < min) {
            min = physical;
            weakness = "Physical";
        }
        return weakness;

    }

    public int[] getStats() {
        return new int[]{pace, shooting, passing, dribbling, defending, physical};
    }

}
