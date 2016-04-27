/*
 * FIRST Team 1699's MultiCameraServer
 *  
 * Credit for this class goes to GitHub user Wazzaps, FIRST Team 1573
 * https://gist.github.com/Wazzaps/bb9e72696f8980e7e727
 * 
 * @author David Sh. from 1573
 * @author thatging3rkid, FIRST Team 1699
 * @author squirlemaster42, FIRST Team 1699 
 * 
 * This class allows us to switch between two or more cameras
 */
package frc.team1699.vision;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import frc.team1699.inireader.iniReader;

public class MultiCameraServer {
	
	private int _session;
	private Image frame;
	private int _cameraCount;
	private int selectedCamera = 0;
	private boolean firstTime = true;
	
	public MultiCameraServer(int camCount){
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		_cameraCount = camCount;
	}
	
	public void run(){
		NIVision.IMAQdxGrab(_session, frame, 1);
		CameraServer.getInstance().setImage(frame);
	}
	
	public void setCamera(int cam){
		if (cam >= _cameraCount || cam < 0){
			System.out.println("Error: tried to set camera out of bounds.");
			return;
		}
		
		if(!firstTime){
			NIVision.IMAQdxStopAcquisition(_session);
			NIVision.IMAQdxCloseCamera(_session);
		}else{
			firstTime = false;
		}
		
		selectedCamera = cam;
		_session = NIVision.IMAQdxOpenCamera("cam" + selectedCamera, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		NIVision.IMAQdxConfigureGrab(_session);
		NIVision.IMAQdxStartAcquisition(_session);
	}
	
	public int getCamera() {
		return selectedCamera;
	}
	
	public void toggleCamera() {
		setCamera((selectedCamera + 1) % _cameraCount);
	}
}
