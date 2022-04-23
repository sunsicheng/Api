package com.study.io;


import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * @author sunsicheng
 * @version 1.0
 * @date 2022/4/23 20:34
 */
public class ReaderTest {

    private FileReader fileReader;

    @Test
    public void testRead() throws IOException {
        //1.创建文件,表示从该文件中读内容到程序
        File file = new File("D:\\IdeaFiles\\study\\java\\src\\main\\resources\\file\\helloword");
        //2.创建流
        try {
            fileReader = new FileReader(file);
            //3.操作流
            int read;
            while ((read = fileReader.read()) != -1) {
                System.out.print((char) read);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            fileReader.close();
        }
    }

    @Test
    public void testRead2() throws IOException {
        //1.创建文件
        File file = new File("D:\\IdeaFiles\\study\\java\\src\\main\\resources\\file\\helloword");
        //2.创建流
        try {
            fileReader = new FileReader(file);
            //3.操作流
            int read;
            char[] cbuf = new char[5];
            while ((read = fileReader.read(cbuf)) != -1) {
                System.out.print(new String(cbuf, 0, read));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            fileReader.close();
        }
    }


    @Test
    public void testWrite() throws IOException {
        //创建文件，表明要写出去到该文件，如果不存在，会覆盖
        File file = new File("D:\\IdeaFiles\\study\\java\\src\\main\\resources\\file\\write1.txt");

        // 创建输出流
        FileWriter fileWriter = new FileWriter(file, true);

        //操作流
        fileWriter.write("测试文件追加");

        //关闭流
        fileWriter.close();
    }


    @Test
    public void readAndWrite() throws IOException {
        //1.创建写入写出文件
        File src = new File("D:\\IdeaFiles\\study\\java\\src\\main\\resources\\file\\helloword");
        File target = new File("D:\\IdeaFiles\\study\\java\\src\\main\\resources\\file\\target.txt");

        //2.创建输入流，输出流
        FileReader fileReader = new FileReader(src);
        FileWriter fileWriter = new FileWriter(target);

        //3.读取数据并写出
        char[] chars = new char[5];
        int len;
        while ((len = fileReader.read(chars)) != -1) {
            //每次写出len个字符
            fileWriter.write(chars, 0, len);
        }

        //4.关闭资源文件
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (fileReader != null) {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
