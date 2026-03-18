package com.notepad.controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.notepad.Application;

public class Frame extends JFrame {
    private static int FRAME_COUNT = 0;

    public Frame() {
        FRAME_COUNT++;

        setTitle(Application.getProperty("app.name", "Notepad").toString());

        setSize(
                Integer.parseInt(Application.getProperty("window.width", 600).toString()),
                Integer.parseInt(Application.getProperty("window.height", 800).toString()));

        setLocation(
                Integer.parseInt(Application.getProperty("window.x", 600).toString()),
                Integer.parseInt(Application.getProperty("window.y", 800).toString()));

        if (Boolean.parseBoolean(Application.getProperty("window.maximized", "false").toString())) {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/logo.png")));
        setIconImage(icon.getImage());

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                FRAME_COUNT--;
                dispose();
                if (FRAME_COUNT <= 0) {
                    Application.setProperty("window.x", getLocation().x);
                    Application.setProperty("window.y", getLocation().y);
                    Application.setProperty("window.width", getSize().width);
                    Application.setProperty("window.height", getSize().height);
                    Application.setProperty("window.maximized", getExtendedState() == JFrame.MAXIMIZED_BOTH);
                    Application.storeProperties();
                    System.exit(0);
                }
            }
        });
    }
}
