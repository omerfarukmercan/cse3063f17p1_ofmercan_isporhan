/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SADO
 */

abstract class Square {
	int number;
    String name;
	
    public Square(int number,String name){   
		this.number=number;
		this.name=name;
	}
	
	
	
	public void action(Player p,Square s) {};


	public int getNumber() {
		return number;
	}

	public void setNumber(int squareNumber) {
		this.number = squareNumber;
	}
	
	
}