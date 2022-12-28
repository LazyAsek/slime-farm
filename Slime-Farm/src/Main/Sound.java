package Main;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    
    Clip clip;
    URL soundsURL[] = new URL[30];

    public Sound(){
        try{
            soundsURL[0] = new File("Slime-Farm/res/sound/theme.wav").toURI().toURL();
            soundsURL[1] = new File("Slime-Farm/res/sound/unlock.wav").toURI().toURL();
        }catch(MalformedURLException e){
            e.printStackTrace();
        }
    }

    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundsURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch(Exception e ){
            e.printStackTrace();
        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
