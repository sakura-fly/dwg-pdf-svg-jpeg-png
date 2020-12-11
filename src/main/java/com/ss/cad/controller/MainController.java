package com.ss.cad.controller;

import com.ss.cad.svg.converter.Resolution;
import com.ss.cad.svg.converter.impl.DWG2SVGConverter;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileFilter;

public class MainController {
    public Button srcBtn;
    public Label srcStr;
    public Button outBtn;
    public Label outStr;
    public Button doIt;
    public TextArea resultText;
    private final String baseDIr = System.getProperty("user.dir");
    public Button srcFileBtn;
    public Label srcFileStr;
    public Button doOne;
    private File srcDir;
    private File srcFile;
    private File outDir;

    public void openSrc(MouseEvent mouseEvent) {
        DirectoryChooser file = new DirectoryChooser();
        file.setTitle("选择源文件目录");
        file.setInitialDirectory(new File(baseDIr));
        Stage stage = (Stage) srcBtn.getScene().getWindow();
        srcDir = file.showDialog(stage);
        srcStr.setText(srcDir.getAbsolutePath());
    }

    public void openOut(MouseEvent mouseEvent) {
        DirectoryChooser file = new DirectoryChooser();
        file.setTitle("选择输出目录");
        file.setInitialDirectory(new File(baseDIr));
        Stage stage = (Stage) srcBtn.getScene().getWindow();
        outDir = file.showDialog(stage);
        outStr.setText(outDir.getAbsolutePath());
    }

    public void openFileSrc(MouseEvent mouseEvent) {
        FileChooser file = new FileChooser();
        file.setTitle("选择源文件");
        file.setInitialDirectory(new File(baseDIr));
        Stage stage = (Stage) srcBtn.getScene().getWindow();
        srcFile = file.showOpenDialog(stage);
        srcFileStr.setText(srcFile.getAbsolutePath());
    }

    public void doIt(MouseEvent mouseEvent) {
        File[] files = srcDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String fileName = pathname.getName().toLowerCase();
                return fileName.endsWith("dwg");
            }
        });
        if (files == null || files.length == 0) {
            resultText.setText("没有Dwg文件");
            return;
        }
        new Thread(() -> {
            for (File f : files) {
                resultText.setText(resultText.getText() + "\n开始转换" + f.getName());
                DWG2SVGConverter converter = new DWG2SVGConverter(f.getAbsolutePath(),
                        outDir + File.separator + f.getName() + ".svg", Resolution.RESOLUTION_1920_1080);
                converter.build();
                resultText.setText(resultText.getText() + "\n完成转换" + f.getName());
            }
            resultText.setText(resultText.getText() + "\n全部转换完成");
        }).start();
    }

    public void doOne(MouseEvent mouseEvent) {
        new Thread(() -> {
            resultText.setText(resultText.getText() + "\n开始转换" + srcFile.getName());
            DWG2SVGConverter converter = new DWG2SVGConverter(srcFile.getAbsolutePath(),
                    outDir + File.separator + srcFile.getName() + ".svg", Resolution.RESOLUTION_1920_1080);
            converter.build();
            resultText.setText(resultText.getText() + "\n完成转换" + srcFile.getName());
        }).start();
    }
}
