package com.brightcrowns.research.gdxart;

import com.badlogic.gdx.Game;
import com.brightcrowns.research.gdxart.screens.MainMenuScreen;

public class MyGdxGame extends Game {


    @Override
    public void create() {
        setScreen(new MainMenuScreen(this));
    }
}
