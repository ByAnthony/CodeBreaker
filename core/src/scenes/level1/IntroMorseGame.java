package scenes.level1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.codeclan.game.GameMain;

public class IntroMorseGame implements Screen {

    private GameMain parent;
    private GameMain game;
    private Stage stage;

    Table table;
    Skin skin;

    private Texture bg;
    private Sound waves;

    Label startTranslate;
    Label startWords;
    Label startMorse;

    public IntroMorseGame(GameMain gameMain) {
        parent = gameMain;
        this.game = gameMain;
        stage = new Stage(new ScreenViewport());

        waves = Gdx.audio.newSound(Gdx.files.internal("Sounds/waves.ogg"));
        waves.play();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        stage.addActor(table);

        skin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));

        bg = new Texture("Backgrounds/introMorse.jpg");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.55f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        game.getBatch().begin();
        game.getBatch().draw(bg, 0, 0);
        game.getBatch().end();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f));
        stage.draw();

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            parent.changeScreen(GameMain.MENU);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            waves.stop();
            parent.changeScreen(GameMain.MORSEGAME);
        }
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        waves.dispose();
    }
}
