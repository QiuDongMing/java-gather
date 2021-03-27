package com.qdm.file.io;

import org.junit.Test;

import java.io.*;

/**
 * @author qiudm
 * @date 2019/1/9 11:40
 * @desc
 */
public class ReaderWriterTests {

    @Test
    public void FileReaderTest() throws Exception {
        String fileName = "smallfile.txt";
        Reader reader = new FileReader(fileName);
        BufferedReader br = new BufferedReader(reader);
        String sr;
        while ((sr = br.readLine()) != null) {
            System.out.println(sr);
        }
        reader.close();
    }


    @Test
    public void FileWriterTest() throws Exception {
        String newFileName = "newFileName.txt";
        String fileName = "smallfile.txt";
        Reader reader = new FileReader(fileName);
        BufferedReader br = new BufferedReader(reader);
        Writer writer = new FileWriter(newFileName);
        BufferedWriter bw = new BufferedWriter(writer);
        String sr;
        while ((sr = br.readLine()) != null) {
            System.out.println(sr);
            bw.write(sr);
            bw.newLine();
        }
        bw.flush();
        reader.close();
        writer.close();
    }




}
