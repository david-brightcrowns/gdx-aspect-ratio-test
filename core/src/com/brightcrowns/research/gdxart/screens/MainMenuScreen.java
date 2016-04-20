package com.brightcrowns.research.gdxart.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.brightcrowns.research.gdxart.MyGdxGame;

/**
 * Created by davidg on 20/04/16.
 */
public class MainMenuScreen implements Screen {

    private MyGdxGame game;

    private Stage stage;
    private Skin skin;

    private Table table;
    private Button buttonCenteredScreen;
    private Button buttonBorderScreen;
    private Button buttonExit;

    public MainMenuScreen(MyGdxGame game) {
        super();
        this.game = game;
    }

    @Override
    public void show() {

        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), new TextureAtlas("ui/blueButtons.pack"));

        //Button PLAY
        buttonCenteredScreen = new TextButton("Centered Screen Test", skin);
        buttonCenteredScreen.pad(20);
        buttonCenteredScreen.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new CenteredScreen(game));
            }
        });


        //Button PLAY
        buttonBorderScreen = new TextButton("Border Screen Test", skin);
        buttonBorderScreen.pad(20);
        buttonBorderScreen.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new BorderScreen(game));
            }
        });

        //Button EXIT
        buttonExit = new TextButton("Salir", skin);
        buttonExit.pad(20);
        buttonExit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });


        table = new Table();
        table.setBounds(100, 40, Gdx.graphics.getWidth()-200, Gdx.graphics.getHeight()-80);

        table.row();
        table.add(buttonCenteredScreen).spaceTop(30).spaceBottom(20)
                .spaceLeft(50).spaceRight(50).expandX().fillX();
        table.row();
        table.add(buttonBorderScreen).spaceBottom(20)
                .spaceLeft(50).spaceRight(50).expandX().fillX();
        table.row();
        table.add(buttonExit).spaceBottom(20)
                .spaceLeft(50).spaceRight(50).expandX().fillX();
        //table.debug();

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor( 0f, 0f, 0f, 1f );
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
