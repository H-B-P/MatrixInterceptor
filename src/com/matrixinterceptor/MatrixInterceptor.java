package com.matrixinterceptor;

/*
 * ~SUMMARY~
 *
 * This is the actual game.
 * It's pretty empty: all the fun happens in the screens, which we hand off to as soon as possible.
 *
 */

import com.badlogic.gdx.Game;

import com.matrixinterceptor.resources.BGM;
import com.matrixinterceptor.resources.Fonts;
import com.matrixinterceptor.resources.Options;
import com.matrixinterceptor.resources.Sounds;
import com.matrixinterceptor.resources.Textures;
import com.matrixinterceptor.screens.*;

public class MatrixInterceptor extends Game {


	public void create() {

		Textures.load();
		Sounds.load();
		Fonts.load();
		BGM.load();
		Options.load();

		this.setScreen(new GameScreen(this)); //Hand off to initial screen.

	}

	public void render() {
		super.render(); // I deleted this once and I deeply regretted it.
	}

}