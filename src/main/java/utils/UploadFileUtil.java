package utils;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class UploadFileUtil {
    private Part part; // 包含文件的part
    private String path; // 文件存放的位置

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) { // 设置part
        this.part = part;
    }

    public String getPath() { // 设置文件存放的位置（文件夹）
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public String getFilename() { // 获取文件名
        String contentDispositionHeader = part.getHeader("content-disposition");
        System.out.println("contentDispositionHeader:::" + contentDispositionHeader);
        String[] elements = contentDispositionHeader.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                System.out.println(element);
                String filename = element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
                int n = filename.lastIndexOf('\\');
                filename = filename.substring(n + 1);
                return filename;
            }
        }
        return null;
    }

    public int saveFile() { // 将文件保存在所设置的文件夹中
        // Collection<String> headerNames = part.getHeaderNames();
        // for (String header : headerNames) {
        // System.out.println(header + "=" + part.getHeader(header));
        // }
        try {
            InputStream is = part.getInputStream();
            String filename = new String(getFilename().getBytes(), "UTF-8");
            File file = new File(path);
            if (!file.exists() || !file.isDirectory()) {
                file.mkdir();
            }
            System.out.println("kkkk" + file + File.separator + filename);
            FileOutputStream fos = new FileOutputStream(new File(file + File.separator + filename));
            byte[] buf = new byte[1024];
            while (is.read(buf) != -1) {
                fos.write(buf);
            }
            fos.flush();
            fos.close();
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
