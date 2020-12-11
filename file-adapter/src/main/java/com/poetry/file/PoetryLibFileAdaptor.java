package com.poetry.file;

import com.potery.port.ObtainPoem;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class PoetryLibFileAdaptor implements ObtainPoem {

    private String filename;

    public PoetryLibFileAdaptor(String filename) throws IOException {
        this.filename = filename;
    }

    @Override
    public String getPoem() {
        try {
            return FileUtils.readFileToString(new File(this.filename), "utf-8");
        } catch (IOException e) {
            return "";
        }
    }
}
