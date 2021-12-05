package scenes.level1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.codeclan.game.GameMain;
import morse.MorseCode;

import java.util.ArrayList;
import java.util.Objects;

public class MorseGame implements Screen {

    private GameMain parent;
    private Stage stage;

    ArrayList<String> typedMorse;

    Table table;
    Skin skin;

    Label startTranslate;
    Label startWords;
    Label startMorse;
    Label morse;
    Label answer;

    MorseCode morseCode;

    public MorseGame(GameMain gameMain) {
        parent = gameMain;
        stage = new Stage(new ScreenViewport());
        morseCode = new MorseCode();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        typedMorse = new ArrayList<>();

        table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        stage.addActor(table);

        skin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));

        startTranslate = new Label("Ready to train? Translate:", skin);
        startWords = new Label("L E A R N   C O D I N G", skin);
        startMorse = new Label( "", skin);

        final TextButton morseKeyDot = new TextButton(".", skin, "default");
        final TextButton morseKeyDash = new TextButton("-", skin, "default");
        final TextButton morseKeyPause = new TextButton("II", skin, "default");
        final TextButton morseKeyListen = new TextButton("Listen", skin, "default");

        table.add(startTranslate).height(50).colspan(5);
        table.row().pad(5, 0, 5, 0);
        table.add(startWords).height(50).colspan(5);
        table.row().pad(5, 0, 5, 0);
        table.add(startMorse).height(50).colspan(5);
        table.row().pad(5, 0, 5, 0);
        table.add().height(50).colspan(5);
        table.row().pad(5, 0, 5, 0);
        table.add(morseKeyDot);
        table.add(morseKeyDash);
        table.add(morseKeyPause);
        table.add(morseKeyListen);

        morseKeyDot.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(morseKeyDot.isPressed()){
                    typedMorse.add(".");
                    morse = new Label(typedMorse.toString()
                            .replace(", ", "")
                            .replace("[", "")
                            .replace("]", "")
                            .trim(), skin);
                    table.reset();
                    table.add(startTranslate).height(50).colspan(5);
                    table.row().pad(5, 0, 5, 0);
                    table.add(startWords).height(50).colspan(5);
                    table.row().pad(5, 0, 5, 0);
                    table.add(morse).height(50).colspan(5);
                    table.row().pad(5, 0, 5, 0);
                    table.add().height(50).colspan(5);
                    table.row().pad(5, 0, 5, 0);
                    table.add(morseKeyDot);
                    table.add(morseKeyDash);
                    table.add(morseKeyPause);
                    table.add(morseKeyListen);
                }
            }
        });

        morseKeyDash.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(morseKeyDash.isPressed()){
                    typedMorse.add("-");
                    morse = new Label(typedMorse.toString()
                            .replace(", ", "")
                            .replace("[", "")
                            .replace("]", "")
                            .trim(), skin);
                    table.reset();
                    table.add(startTranslate).height(50).colspan(5);
                    table.row().pad(5, 0, 5, 0);
                    table.add(startWords).height(50).colspan(5);
                    table.row().pad(5, 0, 5, 0);
                    table.add(morse).height(50).colspan(5);
                    table.row().pad(5, 0, 5, 0);
                    table.add().height(50).colspan(5);
                    table.row().pad(5, 0, 5, 0);
                    table.add(morseKeyDot);
                    table.add(morseKeyDash);
                    table.add(morseKeyPause);
                    table.add(morseKeyListen);
                }
            }
        });

        morseKeyPause.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(morseKeyPause.isPressed()){
                    typedMorse.add(" ");
                    morse = new Label(typedMorse.toString()
                            .replace(", ", "")
                            .replace("[", "")
                            .replace("]", "")
                            .trim(), skin);
                    table.reset();
                    table.add(startTranslate).height(50).colspan(5);
                    table.row().pad(5, 0, 5, 0);
                    table.add(startWords).height(50).colspan(5);
                    table.row().pad(5, 0, 5, 0);
                    table.add(morse).height(50).colspan(5);
                    table.row().pad(5, 0, 5, 0);
                    table.add().height(50).colspan(5);
                    table.row().pad(5, 0, 5, 0);
                    table.add(morseKeyDot);
                    table.add(morseKeyDash);
                    table.add(morseKeyPause);
                    table.add(morseKeyListen);
                }
            }
        });

        morseKeyListen.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(morseKeyListen.isPressed()){
                    String translatedInMorse = morseCode.getMorseWordTranslation(typedMorse);
                    if(Objects.equals(translatedInMorse, "learn coding")) {
                        answer = new Label("CODE RECEIVED SUCCESSFULLY", skin);
                        morse = new Label(typedMorse.toString()
                                .replace(", ", "")
                                .replace("[", "")
                                .replace("]", "")
                                .trim(), skin);
                        table.reset();
                        table.add().height(50).colspan(5);
                        table.row().pad(5, 0, 5, 0);
                        table.add().height(50).colspan(5);
                        table.row().pad(5, 0, 5, 0);
                        table.add(morse).height(50).colspan(5);
                        table.row().pad(5, 0, 5, 0);
                        table.add(answer).height(50).colspan(5);
                        table.row().pad(5, 0, 5, 0);
                        table.add();
                    }else{
                        answer = new Label("Mmmm... Send it again?", skin);
                        typedMorse.clear();
                        morse = new Label(typedMorse.toString()
                                .replace(", ", "")
                                .replace("[", "")
                                .replace("]", "")
                                .trim(), skin);
                        table.reset();
                        table.add(startTranslate).height(50).colspan(5);
                        table.row().pad(5, 0, 5, 0);
                        table.add(startWords).height(50).colspan(5);
                        table.row().pad(5, 0, 5, 0);
                        table.add(morse).height(50).colspan(5);
                        table.row().pad(5, 0, 5, 0);
                        table.add(answer).height(50).colspan(5);
                        table.row().pad(5, 0, 5, 0);
                        table.add(morseKeyDot);
                        table.add(morseKeyDash);
                        table.add(morseKeyPause);
                        table.add(morseKeyListen);
                    }
                }
            }
        });

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.55f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f));
        stage.draw();

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            parent.changeScreen(GameMain.MENU);
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
    }
}
