/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

/**
 *
 * @author SADO
 */
public class GotoJailSquare extends Square {
   
    public GotoJailSquare(int number,String name) {
		super(number,name);
	}
    public void action (Player p,Square s){
        p.punishment=3;
        p.getPiece().setLocation(s);
       //p.piece.setLocation();    jail square e göndermemiz lazım  
    }
    
   
    
}
