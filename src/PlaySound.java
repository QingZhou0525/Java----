

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * 声音播放
 *
 */

public class PlaySound {

	private File file;//音频文件
	private AudioInputStream stream;//音频输入流
	private AudioFormat format;//音频格式
	private DataLine.Info info;//音频行信息
	private Clip clip;//音频行

	
	
	static boolean[] b = new boolean[]{true, true, true, true};//控制声音播放

	
	void open(String s) {
		file = new File(s);//音频文件对象
		try {
			stream = AudioSystem.getAudioInputStream(file);//音频输入流对象
			format = stream.getFormat();//音频格式对象
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	void play() {
		info = new DataLine.Info(Clip.class, format);//音频行信息对象
		try {
			clip = (Clip) AudioSystem.getLine(info);//音频行对象
			clip.open(stream);//将音频数据读入音频行
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	void stop() {
		clip.stop();//暂停音频播放
	}
	

	void start() {
		clip.start();//播放音频行
	}
	
	void loop() {
		clip.loop(20);//回放
	}
}
