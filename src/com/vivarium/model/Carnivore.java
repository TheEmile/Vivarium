package com.vivarium.model;

import java.util.ArrayList;

import static java.lang.Math.abs;

public abstract class Carnivore extends Animal
{


	private int coefX = 1, coefY = 1; // pour debug

	public Carnivore(int posX, int posY, Vivarium v, float health, float hunger, float vitality, float speed, Sex type, ArrayList<AreaType> availableArea, ArrayList<AreaType> dfArea)
	{
		super(posX,posY,v,health,hunger,vitality,speed,type,availableArea, dfArea);
	}

	boolean eat(Herbivore other)
	{
		if(this.speed > other.speed)
		{
			other.setHP(0);
			return  true;
		}
		this.setHunger(this.hunger-4);
		this.setHP(this.getHP()+5);
		return false;
	}



	/*
	* Retourne à l'indice 0 le coefX à prendre, et à l'indice 1 le coefY
	* */
	public void lookForFood(long dt)
	{
		Animal prey = this.vivarium.scanForPrey(this);
		//int[] ret = new int[2];
		if(prey != null)
		{
			if(prey.getPos().getX()<this.getPos().getX())
			{
				coefX = -1;
			}
			else
			{
				coefX =1;
			}
			if(prey.getPos().getY()<this.getPos().getY())
			{
				coefY =-1;
			}
			else
			{
				coefY=1;
			}
			if (abs(prey.getPos().getX()-this.getPos().getX())<4 && abs(prey.getPos().getY()-this.getPos().getY())<4) {

				this.eat((Herbivore)prey);
				this.setHunger(this.hunger-4.0f);
			}
		}
		else
		{
			if (this.getPos().getX()+getSize()/2> vivarium.getTerrain().getWidth() ){
				coefX = -1;
			}
			else if (this.getPos().getX()-getSize()/2  <0){
				coefX = 1;
			}
			if (this.getPos().getY()+getSize()/2> vivarium.getTerrain().getHeight() ){
				coefY = -1;
			}
			else if (this.getPos().getY()-getSize()/2 <0){
				coefY = 1;
			}

		}

		//ret[0] = this.coefX;
		//ret[1] = this.coefY;
		move(dt * getSpeed() * coefX, dt * getSpeed() * coefY);
		//return ret;
	}

	/*
	* Retourne à l'indice 0 le coefX à prendre, et à l'indice 1 le coefY
	* */
	public Animal lookForMate(long dt)
	{
		Animal petit = null;
		Animal mate = this.vivarium.scanOtherGender(this);
		int[] ret = new int[2];
		if(mate != null)
		{
			if(mate.getPos().getX()<this.getPos().getX())
			{
				coefX = -1;
			}
			else
			{
				coefX =1;
			}
			if(mate.getPos().getY()<this.getPos().getY())
			{
				coefY =-1;
			}
			else
			{
				coefY=1;
			}
			if (abs(mate.getPos().getX()-this.getPos().getX())<2 && abs(mate.getPos().getY()-this.getPos().getY())<2) {
				//System.out.println("euh... c'est pas un peu beaucoup là ???");
				this.hunger += 4;
				if (type == Sex.Female)
					try {
						petit = OrganismFactory.AnimalFactory(getSpecie(), (int) this.getPos().getX(), (int) this.getPos().getY(), vivarium, Sex.getRandom());
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		}
		else
		{
			if (this.getPos().getX()+getSize()/2> vivarium.getTerrain().getWidth() )
			{
				coefX = -1;
			}
			else if (this.getPos().getX()-getSize()/2 <0)
			{
				coefX = 1;
			}
			if (this.getPos().getY()+getSize()/2> vivarium.getTerrain().getHeight() )
			{
				coefY = -1;
			}
			else if (this.getPos().getY()-getSize()/2<0)
			{
				coefY = 1;
			}
		}

		//ret[0] = this.coefX;
		//ret[1] = this.coefY;
		//return ret;
		move(dt * getSpeed() * coefX, dt * getSpeed() * coefY);
		return petit;
	}


	public boolean isHungry()
	{
		return getHunger()>=5;
	}


	// TODO : REGARDER CA DE PLUS PRES
	public int getCoefX() {
		return coefX;

	}

	public int getCoefY() {
		return coefY;
	}
}