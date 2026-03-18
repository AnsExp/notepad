package com.notepad.controllers.actions;

import com.notepad.controllers.EditorObserver;
import com.notepad.controllers.FrameObserver;

import java.io.*;

public class SaveFileAction implements Action {

    @Override
    public void onAction() {
        File file = FrameObserver.saveFile();
        if (file == null) return;
        writeFile(file, EditorObserver.getText());
    }

    private void writeFile(File file, String text) {
        String fileName = file.getName();
        if (!fileName.endsWith(".txt")) {
            file = new File(file.getParent(), fileName + ".txt");
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
