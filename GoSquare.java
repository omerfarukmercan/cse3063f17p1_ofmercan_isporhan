/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author SADO
 */
public class GoSquare extends Square {
     public GoSquare(int number,String name) {
		super(number,name);
                
	}
     public void action(Player p, Square s,Die d1,Die d2){
         p.increaseMoney(200);
         
     }
}