package com.brightcrowns.research.gdxart.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.brightcrowns.research.gdxart.MyGdxGame;

/**
 * Created by davidg on 20/04/16.
 */
public class BorderScreen implements Screen {

    private MyGdxGame game;
    private Stage stage;

    private Image centeredImage;
    private Image backgroundImage;


    public BorderScreen(MyGdxGame game) {
        super();
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage(){
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.BACK) {
                    game.setScreen(new MainMenuScreen(game));
                }
                return true;
            }
        };

        Gdx.input.setInputProcessor(stage);

        centeredImage = new Image(new Texture(Gdx.files.internal("images/brightcrowns-logo.png")));
        centeredImage.setPosition(
                (Gdx.graphics.getWidth() - centeredImage.getWidth()) / 2,
                (Gdx.graphics.getHeight() - centeredImage.getHeight()) / 2
        );

        stage.addActor(centeredImage);

        backgroundImage = new Image(new Texture(Gdx.files.internal("images/border.png")));
        backgroundImage.setPosition(
                (Gdx.graphics.getWidth() - backgroundImage.getWidth()) / 2,
                (Gdx.graphics.getHeight() - backgroundImage.getHeight()) / 2
        );

        stage.addActor(backgroundImage);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor( 1f, 1f, 1f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

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
