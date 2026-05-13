package project.controller;
 public class Game {
	 /** Auto einai to entry point gia to game mas */
    public static void main(String[] args) {
    	int stats = 0;
    	Controller GO =  new Controller();
    	stats++;
    	GO.start();
    	if (stats > 0)
    		GO.canPlay();
    }
}