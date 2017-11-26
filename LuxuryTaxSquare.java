/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author SADO
 */
public class LuxuryTaxSquare extends Square {
  
    public LuxuryTaxSquare(int number,String name){
        super(number,name);
    }
    public void action (Player p, Square s,Die d1,Die d2){
        p.decreaseMoney(75);
        //Playerdan 75$ dolar kesilecek 
        //if money<0 goes bankruptcy 
        //removed from game
    }
}
