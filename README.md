# RubiksCubeSolverCOMP445
The Rubik's Cube's six faces (Up, Left, Front, Down, Right, Back) are presented by 6D arrays containing nodes that are linked to their neighbors. Therefore, as a group of nodes moves in each move, its neighbors have also moved accordingly. See below: 
U: uuuuuuuuu
L: lllllllll
F: fffffffff
D: ddddddddd
R: rrrrrrrrr
B: bbbbbbbbb
You can make a starting Cube by using cubeScramble(int numMoves) with numMoves as a number of moves you want your starting cube to be scrambled with random moves, or you can scramle the Cube yourself by calling move(String moveName) individually. 
Our Breadth First Search and advancedBFS works for cube with 6 moves away from the goal cube within roughly 2 minutes of time. 
