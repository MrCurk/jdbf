package net.iryndin.jdbf;

import net.iryndin.jdbf.api.IDBFReader;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by iryndin on 26.01.15.
 */
public class KladrFilesTest {

    static final String PATH = "/var/jdbf/temp";

    @Test
    public void streetDbf() throws IOException {
        File file = Paths.get(PATH, "street.dbf").toFile();
        if (!file.exists()) {
            byte[] bytes = IOUtils.urlToBytes("https://github.com/chezka/kladr/blob/master/STREET.DBF?raw=true");
            try (FileOutputStream out = new FileOutputStream(file)) {
                out.write(bytes);
            }
            System.out.println("Download STREET.DBF from GitHub");
        } else {
            System.out.println("Found STREET.DBF");
        }
        IDBFReader reader = JDBF.createDBFReader(file);
    }

    @Test
    public void altnamesDbf() throws IOException {
        File file = Paths.get(PATH, "altnames.dbf").toFile();
        if (!file.exists()) {
            byte[] bytes = IOUtils.urlToBytes("https://github.com/chezka/kladr/blob/master/ALTNAMES.DBF?raw=true");
            try (FileOutputStream out = new FileOutputStream(file)) {
                out.write(bytes);
            }
            System.out.println("Download ALTNAMES.DBF from GitHub");
        } else {
            System.out.println("Found ALTNAMES.DBF");
        }
        IDBFReader reader = JDBF.createDBFReader(file);
        System.out.println(reader.getMetadata());
    }

}
