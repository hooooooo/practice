class Solution {

        
    final int DIR_NORTH = 0;
    final int DIR_EAST = 1;
    final int DIR_SOUTH = 2;
    final int DIR_WEST = 3;
    
    class Robot {
        public int[] pos;
        public int dir;
        Robot(){
            pos = new int[2];
            dir = DIR_NORTH;
        }
        boolean theSame(Robot another){
            return dir == another.dir && pos[0] == another.pos[0] && pos[1] == another.pos[1];
        }
    }

    
    int turnLeft(int current){
        current += 4;
        current--;
        return current % 4;
    }
    
    int turnRight(int current){
        current += 4;
        current ++;
        return current  % 4;
    }
    
    void forward(Robot robot){
        int dir = robot.dir;
        if(dir == DIR_NORTH){
            robot.pos[1]++;
        } else if(dir == DIR_EAST) {
             robot.pos[0] ++;
        } else if(dir == DIR_SOUTH) {
             robot.pos[1] --;
        } else if(dir == DIR_WEST) {
             robot.pos[0] --;
        } 
    }
    
    void execute(Robot robot, String instructions){
        for(int i = 0; i<instructions.length(); i++){
            char ch = instructions.charAt(i);
            if(ch == 'G'){
                forward(robot);
            } else if(ch == 'L'){
               robot.dir =  turnLeft(robot.dir);
            } else if(ch == 'R'){
               robot.dir =  turnRight(robot.dir);
            }
        }
    }
  
    
    public boolean isRobotBounded(String instructions) {
        Robot current = new Robot();
        Robot origin = new Robot();
        int count = 5;
        do{
            execute(current, instructions);
            if(current.theSame(origin)){
                return true;
            }
        } while(count-- > 0);
        
        return false;
        
    }
}
