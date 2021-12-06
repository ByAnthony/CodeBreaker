package collideItems;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import helpers.GameInfo;

public class HallwaySouthEdge1 extends Sprite {
    private World world;
    private Body body;

    public HallwaySouthEdge1(World world, String name, float x, float y) {
        super(new Texture(name));
        this.world = world;
        setPosition(x - -540, y - -14);
        createBody();
    }

    void createBody() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(getX() / GameInfo.PPM, getY() / GameInfo.PPM);
        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox((getWidth() / 2 ) / GameInfo.PPM,
                (getHeight() / 2) / GameInfo.PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
//        fixtureDef.density = 1f;

        Fixture fixture = body.createFixture(fixtureDef);
        fixture.setUserData("HallwaySouthEdge1");
//        fixture.setSensor(true);
        shape.dispose();
    }
}