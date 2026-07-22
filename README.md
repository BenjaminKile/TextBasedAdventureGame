# TextBasedAdventureGame

A Java coursework project for a console-based maze game. You are trapped in a maze and must find your way out by choosing the correct route at each junction.

## Overview
This repository contains a console-based adventure game where you navigate a maze by choosing one of three directions at each junction:
- 1 = left
- 2 = right
- 3 = forward

The game reads its maze data from [src/Nodes.csv](src/Nodes.csv), and you can use [MazeMap.pdf](MazeMap.pdf) to view the routes or try to figure out the correct path to escape the maze.

## Project structure
- [src/Main.java](src/Main.java) - the main console version of the game
- [src/Main_GUI.java](src/Main_GUI.java) - an unfinished GUI experiment
- [src/Server.java](src/Server.java) - handles input, file loading, and game flow
- [src/Node.java](src/Node.java) - represents each maze node
- [src/Nodes.csv](src/Nodes.csv) - stores the maze layout and text for each node

## How to run
### Prerequisites
- Java 17 or later installed

### From the terminal
From the project root, compile and run the console version with:

```powershell
javac -d out/production src/*.java
java -cp out/production Main
```

This compiles the classes into [out/production](out/production).

## How to play
- Try to solve the maze on your own, or use [MazeMap.pdf](MazeMap.pdf) if you want a guide.
- At each junction, enter a number to choose a direction.
- The game will tell you when you reach a dead end or when you escape the maze.
- After finishing, you can restart the game by pressing any key except `n`.

## Notes
- The console version is the main working version of the game.
- The GUI version in [src/Main_GUI.java](src/Main_GUI.java) was an unfinished experiment and may not be fully functional.
- If you want to change the maze, edit [src/Nodes.csv](src/Nodes.csv) and adjust the node data accordingly.

## License
This project is available under the MIT License. See [LICENSE](LICENSE) for more details.
