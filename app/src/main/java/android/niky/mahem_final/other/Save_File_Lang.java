package android.niky.mahem_final.other;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Save_File_Lang {

    private Context context;
    private String path;
    private File fileeee;

    public Save_File_Lang(Context context ,File file)
    {
        this.context=context;
        this.path=file.getAbsolutePath()+ "/.Mahem/lang.txt";
        this.fileeee=file;
    }

    public String readFileAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(new File(path)));
            while ((line = in.readLine()) != null) stringBuilder.append(line);

        } catch (FileNotFoundException e) {
            tt(e.getMessage());
        } catch (IOException e) {
            tt(e.getMessage());
        }

        String[] a=stringBuilder.toString().split("\n");
        String b=a[a.length-1];
        return b;
    }

    public void saveStringToFile(String str) {

        File root =this.fileeee;
        File dir = new File(root.getAbsolutePath() + "/.Mahem");
        dir.mkdirs(); // build directory
        File file = new File(dir, "lang.txt"); // build file

        try {
            FileOutputStream f = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(f);
            pw.println(str);
            //////////
            pw.flush();
            pw.close();
            f.close();
            //////////
            tt("Saved");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            tt(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            tt(e.getMessage());
        }
    }


    public void tt(String str) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }
    }
