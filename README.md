# **Adventure Game - SOLID Implementation**

A text-based RPG game implementing SOLID principles with combat, leveling, and item systems.

## **Project Overview**

This project demonstrates the implementation of SOLID principles in a game architecture, featuring:
- Turn-based combat system
- Item collection and management
- Level progression
- Achievement system
- Score tracking

## **UML Diagram**

![Adventure Game UML Diagram](https://github.com/TemirJohn/SolidAdventureGame/blob/main/UML%20Diagrams.png)


## **Technical Architecture**

### **Project Structure**

```
📂 SolidAdventureGame
│── 📂 src
│   ├── 📂 player
│   │   ├── Player.java
│   ├── 📂 combat
│   │   ├── CombatManager.java
│   ├── 📂 enemies
│   │   ├── Enemy.java
│   │   ├── Skeleton.java
│   │   ├── Zombie.java
│   │   ├── Vampire.java
│   ├── 📂 items
│   │   ├── ItemManager.java
│   │   ├── GoldCoin.java
│   │   ├── HealthElixir.java
│   │   ├── MagicScroll.java
│   │   ├── Item.java
│   ├── 📂 level
│   │   ├── LevelManager.java
│   │   ├── LevelFactory.java
│   │   ├── LevelFactory1.java
│   │   ├── LevelFactory2.java
│   │   ├── LevelFactory3.java
│   ├── 📂 score
│   │   ├── ScoreManager.java
│   ├── MainGame.java
│   ├── GameEngine.java
```

### **SOLID Principles Implementation**

#### **1. Single Responsibility Principle**
- Each manager class handles one specific aspect of the game
- Clear separation between combat, items, and scoring systems

#### **2. Open/Closed Principle**
- Enemy and Item systems are extensible through inheritance
- New level types can be added via factory implementation

#### **3. Liskov Substitution Principle**
- All enemy types can be used interchangeably
- Items follow consistent behavior patterns

#### **4. Interface Segregation**
- Focused interfaces for different game aspects
- Clear separation of concerns

#### **5. Dependency Inversion**
- High-level modules depend on abstractions
- Factory pattern used for level creation

## **Game Features**

### **Player System**
- Health and experience management
- Level progression
- Inventory system
- Combat statistics

### **Combat System**
- Turn-based combat
- Multiple enemy types
- Experience rewards
- Health management

### **Item System**
- Various item types
- Health restoration effects
- Experience bonuses
- Inventory management

### **Achievement System**
- Monster Hunter: Defeat 10 enemies
- Master Collector: Collect 15 items
- Battle Hardened: Take 1000 damage
- Recovery Master: Heal 500 HP
- Game Master: Reach 1000 score

## **Getting Started**

### **Prerequisites**
- Java JDK 8 or higher
- Command line terminal


### **Gameplay Instructions**
1. Launch the game
2. Enter character name
3. Use menu options:
   - 1️⃣ Fight Enemies
   - 2️⃣ Manage Items
   - 3️⃣ View Statistics
   - 4️⃣ Exit Game

## **Game Objectives**
- Complete all three levels
- Defeat all enemies
- Collect available items
- Unlock all achievements
- Maximize score

## **Technical Details**

### **Design Patterns Used**
- Factory Pattern for level creation
- Strategy Pattern for combat system
- Observer Pattern for achievement tracking

### **Key Components**
- Modular architecture
- Event-driven systems
- Extensible enemy and item frameworks
- Achievement tracking system

## **Future Enhancements**
- Additional enemy types
- New item categories
- Extended achievement system
- Save/Load functionality
- Enhanced combat mechanics

