package com.matrixinterceptor.resources;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {
	
	public static Texture letterboxPoncho;

	public static Texture dot;

	public static Texture prettyBG;
	public static Texture statusBar;

	public static Texture explosion;
	public static Texture bigExplosion;
	public static Texture massiveExplosion;

	public static Texture breadCrumb;
	public static Texture grid;

	public static Texture healthBar;
	public static Texture healthSliver;

	public static class Mine{
		public static Texture regular;
		public static Texture north;
		public static Texture south;
		public static Texture east;
		public static Texture west;




	}

	public static Texture arrowIotaGreen;
	public static Texture arrowIotaOrange;

	public static void load () {

		arrowIotaGreen = new Texture("textures/arrow_iota_green.png");
		arrowIotaOrange = new Texture("textures/arrow_iota_orange.png");
		healthBar = new Texture("textures/healthBar.png");
		healthSliver = new Texture("textures/healthSliver.png");

		breadCrumb = new Texture("textures/breadcrumb.png");
		grid = new Texture("textures/grid.png");

		dot = new Texture("textures/dot.png");

		letterboxPoncho = new Texture("textures/letterboxPoncho.png");
		
		prettyBG=new Texture("textures/prettyBG.png");
		statusBar=new Texture("textures/statusBar.png");

		explosion = new Texture("textures/explosions/explosion.png");
		bigExplosion = new Texture("textures/explosions/big_explosion.png");
		massiveExplosion = new Texture("textures/explosions/massive_explosion.png");

		Mine.regular = new Texture("textures/mines/mine.png");
		Mine.north = new Texture("textures/mines/north_mine.png");
		Mine.south = new Texture("textures/mines/south_mine.png");
		Mine.east = new Texture("textures/mines/east_mine.png");
		Mine.west = new Texture("textures/mines/west_mine.png");

	}
}
