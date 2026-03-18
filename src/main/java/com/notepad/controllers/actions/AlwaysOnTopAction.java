package com.notepad.controllers.actions;

import com.notepad.controllers.FrameObserver;

public class AlwaysOnTopAction implements Action {

    @Override
    public void onAction() {
        FrameObserver.alwaysVisible();
    }
}
