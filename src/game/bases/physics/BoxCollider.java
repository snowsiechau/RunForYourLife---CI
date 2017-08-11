package game.bases.physics;

import game.bases.GameObject;
import tklibs.Mathx;

/**
 * Created by Nttung PC on 7/23/2017.
 */
public class BoxCollider extends GameObject {
    public float width;
    public float height;

    public BoxCollider(float width, float height) {
        super();
        this.width = width;
        this.height = height;
    }

    public BoxCollider() {
        this(0,0);
    }

    public float left(){
        return this.screenPosition.x-width/2;
    }
    public float right(){
        return this.screenPosition.x+width/2;
    }
    public float top(){
        return this.screenPosition.y-height/2;
    }
    public float bottom(){
        return this.screenPosition.y+height/2;
    }

    public boolean collideWith(BoxCollider other){
        boolean xOverlap = Mathx.inRange(other.left(),this.left(),this.right()) || Mathx.inRange(this.left(),other.left(),other.right());
        boolean yOverlap = Mathx.inRange(other.top(),this.top(),this.bottom()) || Mathx.inRange(this.top(),other.top(),other.bottom());
        return xOverlap && yOverlap;
    }

    public boolean collideWith(float top, float bottom, float left, float right) {
        boolean xOverlap = Mathx.inRange(left, this.left(), this.right())
                || Mathx.inRange(this.left(), left, right);

        boolean yOverlap = Mathx.inRange(top, this.top(), this.bottom())
                || Mathx.inRange(this.top(), top, bottom);

        return xOverlap && yOverlap;
    }



    @Override
    public String toString() {
        return "BoxCollider{" +
                "width=" + width +
                ", height=" + height +
                ", position=" + position +
                ", screenPosition=" + screenPosition +
                '}';
    }
}
