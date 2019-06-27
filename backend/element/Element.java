package game.backend.element;

import game.backend.move.Direction;

public abstract class Element {
	
	public abstract boolean isMovable();
	
	public abstract String getKey();
	
	public String getFullKey() {
		return getKey();
	}

	public boolean isSolid() {
		return true;
	}

	public boolean canExplode(){return true;}

	public boolean canFormFigures(){return true;}
	
	public Direction[] explode() {
		return null;
	}
	
	public long getScore() {
		return 0;
	}

	public boolean isFruit(){
		return false;
	}
}
