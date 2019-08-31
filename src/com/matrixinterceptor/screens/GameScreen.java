package com.matrixinterceptor.screens;

import com.badlogic.gdx.math.Rectangle;

import com.matrixinterceptor.resources.Sounds;
import com.matrixinterceptor.resources.Textures;
import com.matrixinterceptor.MatrixInterceptor;

import com.matrixinterceptor.objects.Explosion;
import com.badlogic.gdx.utils.Array;
import com.matrixinterceptor.objects.Mine;

import com.badlogic.gdx.math.MathUtils;

public class GameScreen extends MetaScreen {


    float matrixA=1;
    float matrixB=0;
    float matrixC=0;
    float matrixD=1;

    float hpLossRate=0.55f;

    float startPointX=-0.5f;
    float startPointY=2.5f;


    Rectangle dot = new Rectangle(0,0,8,8);
    Rectangle screenProper=new Rectangle(0, 0, 320, 400);

    Array<Mine> mines = new Array<Mine>();
    Array<Explosion> explosions = new Array<Explosion>();

    public GameScreen(MatrixInterceptor mi) {
        super(mi);

        GAMESPEED=0.8f;
        gameTime=playerTime=0;

    }

    public void render(float delta) {
        game_render(delta);
    }

    public void game_render(float delta) {

        meta_render(delta);

        eventuate_events(delta);

        update_dot();
        update_mine_posns();
        update_mine_posns();
        update_mine_posns();
        update_mine_posns();
        update_mine_posns();
        reduce_HP(delta);
        check_for_dead_mines();
        check_for_dead_explosions();

        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        draw_things();
        batch.end();

    }

    void eventuate_events(float delta){

        matrixA=matrixD=1;

        if (gameTime>2 && (gameTime-GAMESPEED*delta)<2){
            spawnMine(gameTime);
        }
        if (gameTime>4 && (gameTime-GAMESPEED*delta)<4){
            spawnMine(gameTime);
        }
        if (gameTime>6 && (gameTime-GAMESPEED*delta)<6){
            spawnMine(gameTime);
        }
        if (gameTime>7 && (gameTime-GAMESPEED*delta)<7){
            spawnMine(gameTime);
        }
        if (gameTime>9 && (gameTime-GAMESPEED*delta)<9){
            spawnMine(gameTime);
        }
        if (gameTime>12 && (gameTime-GAMESPEED*delta)<12){
            spawnMine(gameTime);
        }
        if (gameTime>13 && (gameTime-GAMESPEED*delta)<13){
            spawnMine(gameTime);
        }
        if (gameTime>16 && (gameTime-GAMESPEED*delta)<16){
            spawnMine(gameTime);
        }

        if (gameTime>30){
            float fracdone = Math.min((gameTime-30)/2, 1);
            matrixA = (1-fracdone)*(1)+(fracdone)*(-1);
        }

        if (gameTime>33 && (gameTime-GAMESPEED*delta)<33){
            spawnMine(gameTime);
        }
        if (gameTime>35 && (gameTime-GAMESPEED*delta)<35){
            spawnMine(gameTime);
        }
        if (gameTime>37 && (gameTime-GAMESPEED*delta)<37){
            spawnMine(gameTime);
        }

        if (gameTime>41 && (gameTime-GAMESPEED*delta)<41){
            spawnMine(gameTime);
        }
        if (gameTime>43 && (gameTime-GAMESPEED*delta)<43){
            spawnMine(gameTime);
        }
        if (gameTime>46 && (gameTime-GAMESPEED*delta)<46){
            spawnMine(gameTime);
        }

        if (gameTime>60){
            float fracdone = Math.min((gameTime-60)/2, 1);
            matrixA = (1-fracdone)*(-1)+(fracdone)*(1);
        }
        if (gameTime>62){
            float fracdone = Math.min((gameTime-62), 1);
            matrixD = (1-fracdone)*(1)+(fracdone)*(2);
        }

        if (gameTime>64 && (gameTime-GAMESPEED*delta)<64){
            spawnMine(gameTime, "south");
        }
        if (gameTime>68 && (gameTime-GAMESPEED*delta)<68){
            spawnMine(gameTime, "south");
        }
        if (gameTime>70 && (gameTime-GAMESPEED*delta)<70){
            spawnMine(gameTime, "south");
        }
        if (gameTime>72 && (gameTime-GAMESPEED*delta)<72){
            spawnMine(gameTime, "south");
        }
        if (gameTime>75 && (gameTime-GAMESPEED*delta)<75){
            spawnMine(gameTime);
        }
        if (gameTime>76 && (gameTime-GAMESPEED*delta)<76){
            spawnMine(gameTime);
        }

        if (gameTime>90){
            float fracdone = Math.min((gameTime-90)/4, 1);
            matrixD =  (1-fracdone)*(2)+(fracdone)*(-2);
        }

        if (gameTime>95 && (gameTime-GAMESPEED*delta)<95){
            spawnMine(gameTime, "south");
        }
        if (gameTime>98 && (gameTime-GAMESPEED*delta)<98){
            spawnMine(gameTime, "east");
        }
        if (gameTime>99 && (gameTime-GAMESPEED*delta)<99){
            spawnMine(gameTime, "west");
        }
        if (gameTime>103 && (gameTime-GAMESPEED*delta)<103){
            spawnMine(gameTime, "north");
        }

        if (gameTime>105 && (gameTime-GAMESPEED*delta)<105){
            spawnMine(gameTime, "north");
        }
        if (gameTime>107 && (gameTime-GAMESPEED*delta)<107){
            spawnMine(gameTime, "north");
        }
    }

    //drawing functions

    void draw_things(){
        draw_background();
        draw_grid();
        draw_path();
        draw_eigens();
        draw_mines();
        draw_explosions();
        draw_dot();
        draw_health_bars();
        draw_status_bars();
        draw_poncho();
    }

    void draw_background(){
        batch.draw(Textures.prettyBG, 0f, -80);

    }

    void draw_grid(){
        batch.draw(Textures.grid,0,0);
    }

    void draw_path(){
        for (float i=0; i<12; i+=0.2){
            float iX=game_to_player_X(time_to_x_path_posn(i));
            float iY=game_to_player_Y(time_to_y_path_posn(i));
            batch.draw(Textures.breadCrumb, iX-3, iY-3);
        }
    }

    void draw_eigens(){
        if (matrixA>=0){
            for (float i=game_to_player_X(0);  Math.abs(player_to_game_X(i-2))<=Math.abs(matrixA); i+=1){
                batch.draw(Textures.arrowIotaGreen, i-2, game_to_player_Y(0)-2);
            }
            for (float i=0; i<10; i++){
                batch.draw(Textures.arrowIotaGreen, game_to_player_X(matrixA)-2-i,game_to_player_Y(0)-2-i);
                batch.draw(Textures.arrowIotaGreen, game_to_player_X(matrixA)-2-i,game_to_player_Y(0)-2+i);
            }
        }
        else{
            for (float i=game_to_player_X(0);  Math.abs(player_to_game_X(i+2))<=Math.abs(matrixA); i-=1){
                batch.draw(Textures.arrowIotaOrange, i-2, game_to_player_Y(0)-2);
            }
            for (float i=0; i<10; i++){
                batch.draw(Textures.arrowIotaOrange, game_to_player_X(matrixA)-2+i,game_to_player_Y(0)-2-i);
                batch.draw(Textures.arrowIotaOrange, game_to_player_X(matrixA)-2+i,game_to_player_Y(0)-2+i);
            }
        }

        if (matrixD>=0){
            for (float i=game_to_player_Y(0);  Math.abs(player_to_game_Y(i-2))<=Math.abs(matrixD); i+=1){
                batch.draw(Textures.arrowIotaGreen,  game_to_player_X(0)-2, i-2);
            }
            for (float i=0; i<10; i++){
                batch.draw(Textures.arrowIotaGreen, game_to_player_X(0)-2-i,game_to_player_Y(matrixD)-2-i);
                batch.draw(Textures.arrowIotaGreen, game_to_player_X(0)-2+i,game_to_player_Y(matrixD)-2-i);
            }
        }
        else{
            for (float i=game_to_player_Y(0);  Math.abs(player_to_game_Y(i+2))<=Math.abs(matrixD); i-=1){
                batch.draw(Textures.arrowIotaOrange,game_to_player_X(0)-2, i-2);
            }
            for (float i=0; i<10; i++){
                batch.draw(Textures.arrowIotaOrange, game_to_player_X(0)-2-i,game_to_player_Y(matrixD)-2+i);
                batch.draw(Textures.arrowIotaOrange, game_to_player_X(0)-2+i,game_to_player_Y(matrixD)-2+i);
            }
        }

    }
    void draw_dot(){batch.draw(Textures.dot,dot.x, dot.y); }

    void draw_mines(){
        for (Mine mine: mines){
            if (mine.direction.equals("north")){
                batch.draw(Textures.Mine.north, mine.rect.x-20, mine.rect.y-20);
            }
            else if (mine.direction.equals("south")){
                batch.draw(Textures.Mine.south, mine.rect.x-20, mine.rect.y-20);
            }
            else if (mine.direction.equals("east")){
                batch.draw(Textures.Mine.east, mine.rect.x-20, mine.rect.y-20);
            }
            else if (mine.direction.equals("west")){
                batch.draw(Textures.Mine.west, mine.rect.x-20, mine.rect.y-20);
            }
            else {
                batch.draw(Textures.Mine.regular, mine.rect.x - 20, mine.rect.y - 20);
            }
        }
    }

    void draw_explosions(){
        for (Explosion explosion: explosions){
            batch.draw(Textures.explosion, explosion.rect.x, explosion.rect.y);
        }
    }

    void draw_health_bars(){
        for (Mine mine:mines){
            if (mine.hp<1){
                for (float i=0; i<32; i+=1){
                    if (mine.hp<(32f-i)/32f) {
                        batch.draw(Textures.healthSliver, mine.rect.x + 4 + i, mine.rect.y - 20);
                    }
                }
                batch.draw(Textures.healthBar,mine.rect.x, mine.rect.y-20);
            }
        }
    }

    void draw_status_bars(){
        batch.draw(Textures.statusBar, 0, 0);
        batch.draw(Textures.statusBar, 0, 400);
    }

    void draw_poncho(){
        batch.draw(Textures.letterboxPoncho, -640, -960);
    }

    //calculating

    float player_to_game_X(float playerX){
        return (playerX-160f)/80f;
    }

    float player_to_game_Y(float playerY){
        return (playerY-240f)/80f;
    }

    float game_to_player_X(float gameX){
        return gameX*80f+160f;
    }

    float game_to_player_Y(float gameY){
        return gameY*80f+240f;
    }

    //pathology

    float time_to_x_path_posn(float time){
        if (time<4){ return -0.5f;}
        if (time<6){return -0.5f+(time-4);}
        if (time<8){return 1.5f;}
        return 1.5f-(time-8);
    }

    float time_to_y_path_posn(float time){
        if (time<4){ return 2.5f-time;}
        if (time<6){return -1.5f;}
        if (time<8){return -1.5f+(time-6);}
        return 0.5f;
    }

    //dot

    float matrixedX(float X, float Y){
        return matrixA*X+matrixB*Y;
    }
    float matrixedY(float X, float Y){
        return matrixC*X+matrixD*Y;
    }

    //spawning functions

    void spawnMine(float startTime){
        Mine mine = new Mine(startTime);
        mines.add(mine);
    }

    void spawnMine(float startTime, String direction){
        Mine mine = new Mine(startTime, direction);
        mines.add(mine);
    }

    void spawnExplosion(float x, float y){
        Explosion explosion = new Explosion(gameTime);
        explosion.rect.x=x;
        explosion.rect.y=y;
        explosions.add(explosion);
        Sounds.mineSplode.play(0.4f);
    }
    //update functions

    void update_mine_posns(){
        for (Mine mine:mines){

            float mineDiffX = player_to_game_X(mine.rect.x+mine.rect.width/2)-startPointX;
            float mineDiffY = player_to_game_Y(mine.rect.y+mine.rect.height/2)-startPointY;

            if (mine.direction.equals("north")){
                float gameX = time_to_x_path_posn(gameTime-mine.startTime+mineDiffY/2);
                float gameY = time_to_y_path_posn(gameTime-mine.startTime+mineDiffY/2);

                mine.rect.setCenter(game_to_player_X(gameX), game_to_player_Y(gameY));
            }
            else if (mine.direction.equals("south")){
                float gameX = time_to_x_path_posn(gameTime-mine.startTime-mineDiffY/2);
                float gameY = time_to_y_path_posn(gameTime-mine.startTime-mineDiffY/2);

                mine.rect.setCenter(game_to_player_X(gameX), game_to_player_Y(gameY));
            }
            else if (mine.direction.equals("east")){
                float gameX = time_to_x_path_posn(gameTime-mine.startTime+mineDiffX/2);
                float gameY = time_to_y_path_posn(gameTime-mine.startTime+mineDiffX/2);

                mine.rect.setCenter(game_to_player_X(gameX), game_to_player_Y(gameY));
            }
            else if (mine.direction.equals("west")) {
                float gameX = time_to_x_path_posn(gameTime - mine.startTime - mineDiffX / 2);
                float gameY = time_to_y_path_posn(gameTime - mine.startTime - mineDiffX / 2);

                mine.rect.setCenter(game_to_player_X(gameX), game_to_player_Y(gameY));
            }
            else{
                float gameX = time_to_x_path_posn(gameTime-mine.startTime);
                float gameY = time_to_y_path_posn(gameTime-mine.startTime);

                mine.rect.setCenter(game_to_player_X(gameX), game_to_player_Y(gameY));
            }

        }
    }

    void update_dot(){
        if (screenProper.contains(mpX, mpY)) {
            float dotX=game_to_player_X(matrixedX(player_to_game_X(mpX), player_to_game_Y(mpY)));
            float dotY=game_to_player_Y(matrixedY(player_to_game_X(mpX), player_to_game_Y(mpY)));
            dot.setCenter(dotX,dotY);
        }
    }

    void reduce_HP(float delta){
        for (Mine mine:mines){
            if (mine.rect.overlaps(dot)){
                mine.hp-=delta*GAMESPEED*hpLossRate;
            }
        }
    }

    void check_for_dead_mines(){
        for (Mine mine:mines){
            if (mine.hp<0){
                mines.removeValue(mine, true);
                spawnExplosion(mine.rect.x-15, mine.rect.y-15);
            }
        }
    }

    void check_for_dead_explosions(){
        for (Explosion explosion:explosions){
            if (explosion.startTime<gameTime-0.5){
                explosions.removeValue(explosion, true);
            }
        }
    }
}