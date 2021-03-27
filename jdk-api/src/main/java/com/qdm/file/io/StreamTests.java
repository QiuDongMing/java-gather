package com.qdm.file.io;

import org.junit.Test;

import java.io.*;

/**
 * @author qiudm
 * @date 2019/1/9 11:26
 * @desc
 */
public class StreamTests {

    @Test
    public void FileInputStreamTest() throws Exception {
        String fileName = "smallfile.txt";
        InputStream inputStream = new FileInputStream(fileName);
        int read;
        while ((read = inputStream.read())!=-1) {
            System.out.print( (char)read);
        }
        inputStream.close();
    }

    @Test
    public void bufferedInputStreamTest() throws Exception {
        String fileName = "smallfile.txt";
        InputStream inputStream = new FileInputStream(fileName);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        int read;
        while ((read = bufferedInputStream.read())!=-1) {
            System.out.print( (char)read);
        }
        inputStream.close();
    }


    @Test
    public void FileOutPutStreamTest() throws Exception {
        String fileName = "smallfile.txt";
        String copyFileName = "copySmallFile.txt";
        InputStream inputStream = new FileInputStream(fileName);
        OutputStream outputStream = new FileOutputStream(copyFileName);
        int read;
        while ((read = inputStream.read())!=-1) {
            System.out.print( (char)read);
            outputStream.write(read);
        }
        inputStream.close();
        outputStream.close();
    }






















}
