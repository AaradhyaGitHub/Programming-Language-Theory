# FC Barcelona Squad Manager
## ECS 140A Learning Project - Object-Oriented Programming in Java

---

## Project Overview

This project is a **Squad Management System** for FC Barcelona (a football/soccer team). It was created as a self-directed learning exercise to master Object-Oriented Programming concepts in Java, parallel to the course homework but with a different domain.

The system reads player data from a file, organizes players into a squad, and generates various analytical reports about team composition, player potential, and upgrade recommendations.

---

## The Problem Domain

### What is FC Mobile?
FC Mobile is a mobile game where you build and manage a football squad. Each player has:
- **Overall Rating (OVR)**: A number representing how good they are (higher = better)
- **Six Stats**: Different attributes depending on player type
- **Level System**: Players can be upgraded from level 0 to level 5, increasing their OVR
- **Positions**: Where they play on the field (GK = Goalkeeper, ST = Striker, CB = Center Back, etc.)

### The Squad
This project manages an 18-player squad:
- **1 Goalkeeper** (different stats than other players)
- **10 Starting Players** (the main team)
- **7 Bench Players** (substitutes)

Some players have **special roles** like Captain, Free Kick Taker, or Penalty Taker.

---

## Player Information Tracked

For every player, the system tracks:
- **Player ID** (unique identifier, e.g., "001")
- **First Name** and **Last Name**
- **Position** (e.g., GK, ST, LW, CB, CDM)
- **Current OVR** (current overall rating after upgrades)
- **Level** (how many times they've been upgraded, 0-5)
- **Max Level** (always 5 in this game)
- **Base OVR** (original rating before any upgrades)
- **Is Starter** (whether they're in the starting XI or on the bench)
- **Special Role** (Captain, Penalty Taker, etc., or NONE)

### Player Types

The system distinguishes between two fundamentally different player types:

#### 1. Outfield Players (forwards, midfielders, defenders)
Six stats tracked:
- **Pace** (speed)
- **Shooting** (goal-scoring ability)
- **Passing** (ability to pass the ball)
- **Dribbling** (ball control while running)
- **Defending** (ability to stop opponents)
- **Physical** (strength and stamina)

#### 2. Goalkeepers
Six different stats tracked:
- **Diving** (ability to dive for saves)
- **Positioning** (positioning to block shots)
- **Handling** (catching the ball)
- **Reflexes** (reaction speed)
- **Kicking** (passing/clearing the ball)
- **Physical** (strength and stamina)

---

## Input Data Format

Player data is stored in a file named `squad_data.txt`. Each line represents one player with semicolon-separated values:

```
PlayerID;FirstName;LastName;Position;CurrentOVR;Level;MaxLevel;BaseOVR;PlayerType;Stat1;Stat2;Stat3;Stat4;Stat5;Stat6;IsStarter;SpecialRole
```

**Field Descriptions:**
- `PlayerID`: 3-digit unique identifier (e.g., "001")
- `FirstName`, `LastName`: Player's name
- `Position`: Two or three letter code (GK, ST, LW, CB, CDM, etc.)
- `CurrentOVR`: Current overall rating (integer)
- `Level`: Current upgrade level (0-5)
- `MaxLevel`: Maximum possible level (always 5)
- `BaseOVR`: Original rating before upgrades (integer)
- `PlayerType`: Single character - `G` for Goalkeeper, `O` for Outfield
- `Stat1-Stat6`: The six stats (integers)
  - For Outfield (`O`): Pace, Shooting, Passing, Dribbling, Defending, Physical
  - For Goalkeeper (`G`): Diving, Positioning, Handling, Reflexes, Kicking, Physical
- `IsStarter`: `Y` for starting XI, `N` for bench
- `SpecialRole`: `CAPTAIN`, `PENALTY`, `FREE_KICK_SHORT`, `FREE_KICK_LONG`, `CORNER`, or `NONE`

**Example Lines:**
```
001;David;Raya;GK;115;1;5;114;G;186;177;174;178;181;175;Y;NONE
010;Lionel;Messi;ST;118;4;5;114;O;182;175;155;184;65;138;Y;PENALTY
017;Juan;Veron;CM;115;0;5;115;O;120;112;143;134;115;111;N;NONE
```

---

## System Functionality

The Squad Manager generates several types of reports and analyses:

### 1. Squad Overview
- Display all players with their current stats
- Show starting XI vs bench
- Display special role assignments

### 2. Player Analysis
For individual players:
- **Core Strength**: Identify their best stat (e.g., "Messi's core strength is Dribbling")
- **Core Weakness**: Identify their worst stat (e.g., "Messi's core weakness is Defending")
- **Potential OVR**: Calculate maximum possible rating if fully upgraded

### 3. Upgrade Planning
- Identify which players have remaining upgrade capacity
- Compare upgrade potential between players
- Simulate what happens when you upgrade a player

### 4. Squad Comparison
- Find lowest OVR players (position replacement recommendations)
- Rank players by specific stats (e.g., "Who are the fastest players?")
- Compare bench players to starters

---

## Technical Requirements (OOP Concepts Applied)

This project demonstrates the following Object-Oriented Programming concepts:

### Class Hierarchy & Inheritance
- `Player` (abstract base class)
  - `OutfieldPlayer` (extends Player)
  - `Goalkeeper` (extends Player)

### Abstract Methods
Methods declared in `Player` but implemented differently in subclasses:
- `getCoreStrength()` - finds highest stat
- `getCoreWeakness()` - finds lowest stat
- `getStats()` - returns the 6 stats as an array

### Visibility Modifiers
- `private`: Data that's hidden from subclasses (playerId, firstName, lastName, position, isStarter, specialRole)
- `protected`: Data that subclasses need direct access to (currentOVR, level, baseOVR, maxLevel)
- `public`: Methods accessible from outside the class

### Polymorphism
The system can treat all players uniformly through the `Player` type, even though Goalkeepers and Outfield players behave differently:
```java
Player[] squad = new Player[18];
for (Player p : squad) {
    p.displayInfo();  // Works for both types, but displays differently
}
```

### Encapsulation
- Player data is protected from direct external access
- Access is controlled through public getter methods
- Internal implementation details are hidden

### Constructors
- Subclass constructors call parent constructor using `super()`
- `final` fields must be initialized in constructor

---

## Project Structure

```
├── README.md                  # This file
├── squad_data.txt            # Input data (18 players)
├── Player.java               # Abstract base class
├── OutfieldPlayer.java       # Concrete class for field players
├── Goalkeeper.java           # Concrete class for goalkeepers
├── Squad.java                # Manages the collection of players
└── Main.java                 # Entry point, reads file and runs reports
```

---

## Sample Output (To Be Implemented)

```
=== FC Barcelona Squad Overview ===

STARTING XI:
001 | David Raya | GK | OVR: 115 | Level: 1/5 | Potential: 119
002 | Marcelo Silva | LB | OVR: 117 | Level: 4/5 | Potential: 118
...

BENCH:
012 | Rafael Leao | LW | OVR: 117 | Level: 3/5 | Potential: 119
...

=== Upgrade Recommendations ===
Players with most upgrade potential:
1. Juan Veron (CM) - Base 115, Currently 115, 5 upgrades available
2. Dirk Kuyt (CM) - Base 115, Currently 115, 5 upgrades available
...

=== Position Needs Analysis ===
Lowest OVR by position:
- Goalkeeper: David Raya (115)
- Defense: Patrick Kluivert (114)
...
```

---

## Learning Objectives

By completing this project, the developer will demonstrate understanding of:

1. **Class design** - Creating appropriate abstractions (abstract Player class)
2. **Inheritance** - Using `extends` to create specialized player types
3. **Abstract methods** - Declaring methods that subclasses must implement
4. **Visibility modifiers** - Choosing appropriate access levels (private, protected, public)
5. **Constructors** - Chaining constructors with `super()`
6. **Polymorphism** - Treating different types uniformly through a common interface
7. **File I/O** - Reading structured data from files
8. **Collections** - Managing arrays of objects
9. **Encapsulation** - Protecting data and providing controlled access

---

## Comparison to Course Homework

This project mirrors the structure of Homework 2 (Tonopah State University student tracking system):

| Homework 2 | This Project |
|------------|--------------|
| Students | Players |
| Degree-seeking vs Non-degree | Outfield vs Goalkeeper |
| Financial assistance subtypes | Special roles/upgrades |
| Fee calculation | OVR calculation |
| Student reports | Squad analysis |

The added complexity includes:
- Upgrade simulation system
- Core strength/weakness analysis
- Position-based comparisons
- Multiple report types

---

## Getting Started

1. Ensure `squad_data.txt` is in the same directory as the Java files
2. Compile all Java files: `javac *.java`
3. Run the program: `java Main`
4. Follow on-screen prompts to generate reports

---

## Notes

- This is a learning project, not production code
- The upgrade calculation is simplified (1 OVR per level)
- Multiple special roles per player are simplified (only one stored)
- Formation validation is not implemented in the current version

---

*This project was created as a companion to ECS 140A coursework to reinforce Object-Oriented Programming concepts through a personally meaningful domain.*