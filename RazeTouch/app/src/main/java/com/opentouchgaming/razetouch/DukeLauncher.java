package com.opentouchgaming.razetouch;

import com.opentouchgaming.androidcore.DebugLog;
import com.opentouchgaming.androidcore.GameEngine;
import com.opentouchgaming.androidcore.SubGame;

import java.io.File;
import java.util.ArrayList;

public class DukeLauncher extends RazeBaseLauncher
{
    DukeLauncher()
    {
        SUB_DIR = "DUKE";
        new File(getRunDirectory()).mkdirs();
    }

    @Override
    public void updateSubGames(GameEngine engine, ArrayList<SubGame> availableSubGames)
    {
        log.log(DebugLog.Level.D, "updateSubGames");

        availableSubGames.clear();

        SubGame.addGame(availableSubGames, getRunDirectory(), getSecondaryDirectory(), SUB_DIR + ".", ".", 0, WEAPON_WHEEL_NBR, new String[]{"duke3d.grp"}, R.drawable.dn3d, "Duke Nukem 3D",
                        "Copy duke3d.grp to:", "Put your Duke 3D files here.txt");

        SubGame sg = SubGame.addGame(availableSubGames, getRunDirectory(), getSecondaryDirectory(), SUB_DIR + "addons/nw", "addons/nw", 0, WEAPON_WHEEL_NBR, new String[]{"addons/nw/nwinter.grp"},
                                     R.drawable.raze, "Duke: Nuclear Winter", "Copy your Duke files to:", "Put your NW files here.txt");

        sg.setExtraArgs("-gamegrp nwinter.grp");

        sg = SubGame.addGame(availableSubGames, getRunDirectory(), getSecondaryDirectory(), SUB_DIR + "addons/vacation", "addons/vacation", 0, WEAPON_WHEEL_NBR, new String[]{"addons/vacation/vacation.grp"},
                             R.drawable.raze, "Duke Caribbean: Life's a Beach", "Copy your Duke files to:", "Put your Vacation files here.txt");
        sg.setExtraArgs("-gamegrp vacation.grp");

        sg = SubGame.addGame(availableSubGames, getRunDirectory(), getSecondaryDirectory(), SUB_DIR + "addons/dc", "addons/dc", 0, WEAPON_WHEEL_NBR, new String[]{"addons/dc/dukedc.grp"},
                             R.drawable.raze, "Duke It Out in D.C.", "Copy your Duke files to:", "Put your Duke DC files here.txt");
        sg.setExtraArgs("-gamegrp dukedc.grp");

        addAddonsDir(engine, availableSubGames, new String[]{"nw", "vacation", "dc"});

        super.updateSubGames(engine, availableSubGames);
    }
}
