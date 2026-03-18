package com.notepad.controllers.actions;

import com.notepad.controllers.FrameObserver;

public class CloseFrameAction implements Action {

    @Override
    public void onAction() {
        FrameObserver.close();
    }
}
