package project.controller;
 public class Game {
	 /** Entry point for Game */
    public static void main(String[] args) {
    	int stats = 0;
    	Controller GO =  new Controller();
    	stats++;
    	GO.start();
    	if (stats > 0)
    		GO.canPlay();
    }
}
