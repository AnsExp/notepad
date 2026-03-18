package com.notepad.controllers;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public final class FrameObserver {

    private static Frame frame;

    private FrameObserver() {
    }

    public static void initObserver(Frame frame) {
        FrameObserver.frame = frame;
    }

    public static File openFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Text Files (*.txt)", "txt"));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = chooser.showOpenDialog(FrameObserver.frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }

    public static File saveFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Text Files (*.txt)", "txt"));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = chooser.showSaveDialog(FrameObserver.frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }

    public static void close() {
        FrameObserver.frame.dispose();
    }

    public static boolean alwaysVisible() {
        boolean alwaysVisible = !FrameObserver.frame.isAlwaysOnTop();
        FrameObserver.frame.setAlwaysOnTop(alwaysVisible);
        return  alwaysVisible;
    }
}
