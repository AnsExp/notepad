package com.notepad.controllers.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.notepad.controllers.EditorObserver;
import com.notepad.controllers.FrameObserver;

public class OpenFileAction implements Action {

    @Override
    public void onAction() {
        File file = FrameObserver.openFile();
        if (file == null) return;
        try {
            String content = readFile(file);
            EditorObserver.setText(content);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    private String readFile(File file) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }

        return content.toString();
    }
}
