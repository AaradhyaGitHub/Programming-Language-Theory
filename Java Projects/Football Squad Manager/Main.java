
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Player[] squad = new Player[18];
        int playerCount = 0;

        try {
            File file = new File("squad_data.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");

                String playerId = data[0];
                String firstName = data[1];
                String lastName = data[2];
                String position = data[3];

                int currentOVR = Integer.parseInt(data[4]);
                int level = Integer.parseInt(data[5]);
                int maxLevel = Integer.parseInt(data[6]);
                int baseOVR = Integer.parseInt(data[7]);
                String playerType = data[8];

                int stat1 = Integer.parseInt(data[9]);
                int stat2 = Integer.parseInt(data[10]);
                int stat3 = Integer.parseInt(data[11]);
                int stat4 = Integer.parseInt(data[12]);
                int stat5 = Integer.parseInt(data[13]);
                int stat6 = Integer.parseInt(data[14]);

                boolean isStarter = data[15].equals("Y");
                String specialRole = data[16];

                if (playerType.equals("O")) {
                    squad[playerCount] = new OutfieldPlayer(
                            playerId,
                            firstName,
                            lastName,
                            position,
                            currentOVR,
                            level,
                            maxLevel,
                            baseOVR,
                            isStarter,
                            specialRole,
                            stat1,
                            stat2,
                            stat3,
                            stat4,
                            stat5,
                            stat6
                    );
                } else if (playerType.equals("G")) {
                    squad[playerCount] = new Goalkeeper(
                            playerId,
                            firstName,
                            lastName,
                            position,
                            currentOVR,
                            level,
                            maxLevel,
                            baseOVR,
                            isStarter,
                            specialRole,
                            stat1,
                            stat2,
                            stat3,
                            stat4,
                            stat5,
                            stat6
                    );
                }

                playerCount++;

            }
            scanner.close();
            System.out.println("=== Squad Loaded ===");
            for (int i = 0; i < playerCount; i++) {
                Player p = squad[i];
                System.out.println(p.getPlayerFirstName() + " " + p.getPlayerLastName()
                        + " | " + p.getPlayerPosition()
                        + " | OVR: " + p.getPlayerCurrentOVR()
                        + " | Strength: " + p.getCoreStrength()
                        + " | Weakness: " + p.getCoreWeakness());
            }

            System.out.println("\n=== Polymorphism in Action ===");
            for (int i = 0; i < playerCount; i++) {
                int[] stats = squad[i].getStats();  // Same method call...
                System.out.println(squad[i].getPlayerFirstName() + ": "
                        + stats.length + " stats returned");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");

        }
    }
}
