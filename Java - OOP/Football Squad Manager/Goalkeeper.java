
public class Goalkeeper extends Player {

    private int diving;
    private int positioning;
    private int handling;
    private int reflexes;
    private int kicking;
    private int physical;

    public Goalkeeper(
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
            //Goalkeeper abilities:
            int diving,
            int positioning,
            int handling,
            int reflexes,
            int kicking,
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

        this.diving = diving;
        this.positioning = positioning;
        this.handling = handling;
        this.reflexes = reflexes;
        this.kicking = kicking;
        this.physical = physical;
    }

    public String getCoreStrength() {
        int max = diving;
        String strength = "Diving";

        if (positioning > max) {
            max = positioning;
            strength = "Positioning";
        }

        if (handling > max) {
            max = handling;
            strength = "Handling";
        }

        if (reflexes > max) {
            max = reflexes;
            strength = "Reflexes";
        }

        if (kicking > max) {
            max = kicking;
            strength = "Kicking";
        }

        if (physical > max) {
            max = physical;
            strength = "Physical";
        }
        return strength;
    }

    public String getCoreWeakness() {
        int min = diving;
        String weakness = "Diving";

        if (positioning < min) {
            min = positioning;
            weakness = "Positioning";
        }

        if (handling < min) {
            min = handling;
            weakness = "Handling";
        }

        if (reflexes < min) {
            min = reflexes;
            weakness = "Reflexes";
        }

        if (kicking < min) {
            min = kicking;
            weakness = "Kicking";
        }

        if (physical < min) {
            min = physical;
            weakness = "Physical";
        }
        return weakness;
    }

    public int[] getStats() {
        return new int[]{diving, positioning, handling, reflexes, kicking, physical};
    }
}
