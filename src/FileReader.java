
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReader {
	
	public List<String> getAllPaths(String filePath) {
		File f = null;
		f = new File(filePath);
		File[] files = f.listFiles();
		List<String> list = new ArrayList<String>();
		for (File file : files) {
			if(!file.isDirectory())
				list.add(file.getPath());	
		}
		Collections.sort(list);
		return list;
	}
	

}
