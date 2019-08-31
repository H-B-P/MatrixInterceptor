package com.matrixinterceptor.resources;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.Gdx;

public class Fonts {
	public static class AcalcFonts{
		public static BitmapFont gray;
		public static BitmapFont red;
		public static BitmapFont blue;
		public static BitmapFont green;
		public static BitmapFont white;
		public static BitmapFont black;
	}
	public static void load () {
		
		AcalcFonts.gray=new BitmapFont(Gdx.files.internal("fonts/acalc_font/greenflame.fnt"));
		AcalcFonts.gray.setColor(new Color(0.6f, 0.6f, 0.6f, 1.0f));
		AcalcFonts.red=new BitmapFont(Gdx.files.internal("fonts/acalc_font/greenflame.fnt"));
		AcalcFonts.red.setColor(new Color(1.0f, 0.2f, 0.2f, 1.0f));
		AcalcFonts.blue=new BitmapFont(Gdx.files.internal("fonts/acalc_font/greenflame.fnt"));
		AcalcFonts.blue.setColor(new Color(0.5f, 0.5f, 1.0f, 1.0f));
		AcalcFonts.green=new BitmapFont(Gdx.files.internal("fonts/acalc_font/greenflame.fnt"));
		AcalcFonts.green.setColor(new Color(0.2f, 0.6f, 0.2f, 1.0f));
		AcalcFonts.white=new BitmapFont(Gdx.files.internal("fonts/acalc_font/greenflame.fnt"));
		AcalcFonts.white.setColor(new Color(1f, 1f, 1f, 1.0f));
		AcalcFonts.black=new BitmapFont(Gdx.files.internal("fonts/acalc_font/greenflame.fnt"));
		AcalcFonts.black.setColor(new Color(0f, 0f, 0f, 1.0f));
	}
}
