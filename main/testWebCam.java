/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_application_ia;

import com.github.sarxos.webcam.Webcam;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Parv
 */
public class testWebCam {
    public static void main(String args[]) throws IOException{
    Webcam webcam = Webcam.getDefault();
    webcam.open();
    ImageIO.write(webcam.getImage(),"JPG", new File("BreachCapture.jpg"));
    
    }
}
