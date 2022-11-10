package com.global;

import java.io.*;

/**
 * @author Roshni Das
 * @created 05/11/2022
 * @project AnagramSolver
 */
public class ReadFile {

    public static String usingBufferedReader(File file) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(file);
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultStringBuilder.toString();
    }

}
