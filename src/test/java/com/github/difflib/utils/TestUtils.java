package com.github.difflib.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestUtils {

    private TestUtils() {
    }

    public static Path pathToResource(String path) {
        return Paths.get(classLoader()
                .getResource(path)
                .getPath());
    }

    private static ClassLoader classLoader() {
        return TestUtils.class.getClassLoader();
    }
}
