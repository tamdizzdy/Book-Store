/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author DELL
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String fileName = context.getRealPath("/" + context.getInitParameter("fileName"));

        try {
            Map<String, String> map = readFile(fileName);
            context.setAttribute("MAP", map);
            System.out.println("-- Load Context");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
      
    }

    public Map<String, String> readFile(String fileName) throws IOException {
        Map<String, String> map = new HashMap<>();
     
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileReader f = null;
        BufferedReader bf = null;
        try {
            f = new FileReader(fileName);
            bf = new BufferedReader(f);
            while (bf.ready()) {
                String line = bf.readLine();
                String[] arr = line.split("=");
                if (arr.length == 2) {

                    map.put(arr[0], arr[1]);

                }
            }
        } finally {
            if (bf != null) {
                bf.close();
            }
            if (f != null) {
                f.close();
            }
        }
        return map;
    }

}
