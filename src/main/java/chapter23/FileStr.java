package chapter23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tools.ant.util.StringUtils;

public class FileStr {

	public static void main(String[] args) throws IOException {

		String path = "C:\\Users\\yuanyougao\\Desktop\\hello.txt";
		File file = new File(path);
		if (file.isFile()) {
			//System.out.println("存在文件");
		} else {
			System.out.println("不存在");
		}
		OutputStream outputstream = null;
		try {
			 //String writestr ="wo ai ni zhong guo";
			 //outputstream = new FileOutputStream(file);
			// outputstream.write(writestr.getBytes());
			 System.out.println("write success");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputstream != null) {
				outputstream.close();
			}
			
		}
		
		InputStream inputstream = null;
		try {
			byte[] inputbyte = new byte[1024];
			inputstream = new FileInputStream(file);
			while (true) {
				int readnum = inputstream.read(inputbyte);
				System.out.println(readnum);
				if (readnum == -1){
					break;
				}
			}
			System.out.println("shuju:" +new String(inputbyte));
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (inputstream != null) {
				inputstream.close();
			}
		}
		
		
		
	}

}
