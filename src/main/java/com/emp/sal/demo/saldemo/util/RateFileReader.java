package com.emp.sal.demo.saldemo.util;

import com.emp.sal.demo.saldemo.exception.FileException;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class RateFileReader {
    private static final String path="./csv";
    public static BigDecimal getRateInGel() {
        BigDecimal result = BigDecimal.ONE;
        File dir = new File(path);
        FileFilter fileFilter = new WildcardFileFilter("*Exchange*.csv");
        File[] files = dir.listFiles(fileFilter);
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("./csv/" + files[0].getName()));
            line = br.readLine();
            line = br.readLine();
            String[] arr = line.split(",");
            result = new BigDecimal(arr[1]);
        } catch (FileNotFoundException e) {
            throw new FileException("no file found in /csv/ dir with name *Exchange*.csv");
        } catch (IOException e) {
            throw new FileException("error during file reading process"+e.getMessage());
        }
        return result;

    }
}
