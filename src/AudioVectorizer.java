import java.io.FileOutputStream;
import java.util.List;

import jAudioFeatureExtractor.DataModel;
import jAudioFeatureExtractor.DataTypes.RecordingInfo;

public class AudioVectorizer {
	private DataModel dataModel;
	
	public static void main(String[] args) throws Exception{
		new AudioVectorizer().run(args);
	}
	
	private void run(String args[]) throws Exception{
		executeDatabase("audios/audioDatabase");
		classifyAudioFile("audios/testAudio");
	}
	private void executeDatabase(String path) throws Exception{
		FileReader reader = new FileReader();
		List<String> allPaths = reader.getAllPaths(path);
		RecordingInfo[] recordings = new RecordingInfo[allPaths.size()];
		for(int i=0;i<recordings.length;i++){
			recordings[i] = new RecordingInfo(allPaths.get(i));
		}
		dataModel = new DataModel("features.xml",null);
		dataModel.featureValue = new FileOutputStream("database512Window0.2overlap.arff");
		dataModel.featureKey = new FileOutputStream("1def.arff");
		dataModel.extract(512, 0.2, 16000, false, true, false, recordings, 1);
	}
	private void classifyAudioFile(String path) throws Exception{
		FileReader reader = new FileReader();
		List<String> allPaths = reader.getAllPaths(path);
		RecordingInfo[] recordings = new RecordingInfo[allPaths.size()];
		for(int i=0;i<recordings.length;i++){
			recordings[i] = new RecordingInfo(allPaths.get(i));
		}
		dataModel = new DataModel("features.xml",null);
		dataModel.featureValue = new FileOutputStream("test512Window0.2overlap.arff");
		dataModel.featureKey = new FileOutputStream("1def.arff");
		dataModel.extract(512, 0.2, 16000, false, true, false, recordings, 1,false,new String[] {"augusta.wav","test.wav"});
	}
}
