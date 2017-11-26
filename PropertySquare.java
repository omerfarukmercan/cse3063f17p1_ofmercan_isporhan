/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SADO
 */
abstract class PropertySquare extends Square {
	
	
    public PropertySquare (int number,String name,Money price,Money rent){
        super(number,name);
        price = this.price ;
        rent = this.rent;
        
    }
    
    public void action(Player p, Square s,Die d1,Die d2){
		
	}
    
}
