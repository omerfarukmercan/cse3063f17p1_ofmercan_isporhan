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
public class IncomeTaxSquare extends Square{
    String name="Income Tax Square";
    public IncomeTaxSquare(int number,String name) {
		super(number,name);
	}
    public void action (Player p){
        p.decreaseMoney((p.money.getValue()/10));
        
        //Gelirinin %10 u kadarını kaybedecek (total cashın)
        //if player.money <0 then player goes bankruptcy
        //removed from game
            
        
    }
    
}
