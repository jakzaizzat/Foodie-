package foody.jakzaizzat.com.foody.Controller;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;

public class FileController {
    private String fileName;

    public void createFile(String name){
        File f = null;
        boolean bool = false;
        try {

            fileName = "test.json";
           // f = new File(fileName);
            System.out.println("File name is " + fileName);


                    //getApplicationContext().openFileOutput("filename", Context.MODE_PRIVATE);


            bool = f.createNewFile();
            System.out.println("File created: "+bool);

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
