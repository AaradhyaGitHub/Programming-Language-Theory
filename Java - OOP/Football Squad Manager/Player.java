
public abstract class Player {

    private String playerId;
    private String firstName;
    private String lastName;
    private String position;

    protected int currentOVR;
    protected int level;

    protected final int maxLevel;
    protected final int baseOVR;

    private boolean isStarter;
    private String specialRole;

    public Player(
            String playerId,
            String firstName,
            String lastName,
            String position,
            int currentOVR,
            int level,
            int maxLevel,
            int baseOVR,
            boolean isStarter,
            String specialRole
    ) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;

        this.currentOVR = currentOVR;
        this.level = level;
        this.maxLevel = maxLevel;
        this.baseOVR = baseOVR;

        this.isStarter = isStarter;
        this.specialRole = specialRole;

    }

    public String getPlayerId() {
        return playerId;
    }
    public String getPlayerFirstName() {
        return firstName;
    }
    public String getPlayerLastName() {
        return lastName;
    }
    public String getPlayerPosition() {
        return position;
    }
    public boolean getIsPlayerStarter() {
        return isStarter;
    }
    public String getPlayerRoles() {
        return specialRole;
    }
    public int getPlayerCurrentOVR(){
        return currentOVR;
    }
    public abstract String getCoreStrength();
    public abstract String getCoreWeakness();
    public abstract int[] getStats();

    public int calculatePotentialOVR(){
        return 0;
    }
    
    public void displayInfo(){
    }
    


}
