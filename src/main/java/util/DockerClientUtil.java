package util;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.Image;
import com.spotify.docker.client.messages.ImageInfo;
import domian.Imagelocal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class DockerClientUtil {
	
	/**  
	* @Title: listImages  
	* @Description: list images in localhost  
	* @return void
	 * @throws  DockerCertificateException, DockerException, InterruptedException
	*/  
	public static List<Imagelocal> listImages() throws DockerCertificateException, DockerException, InterruptedException{
		DockerClient docker = DefaultDockerClient.fromEnv().build();
		List<Image> images = docker.listImages();
		List<Imagelocal> imagelocals =new ArrayList<>(); 
		for (Image image : images) {
			Imagelocal imagelocal = new Imagelocal();
			String imageName = null;
			if (image.repoTags() != null) {
				imageName = image.repoTags().toArray()[0].toString();
			} else {
				imageName = image.repoDigests().get(0).split("@")[0];
			}
			imagelocal.setIname(imageName);
			String size = Math.round(Double.valueOf(image.size()) / 1000000) + "MB";
			imagelocal.setSize(size);
			imagelocal.setCreatedtime(new Date());
			System.out.println(imagelocal);
			imagelocals.add(imagelocal);
			/*System.out.print("镜像名称：" + imageName + "\t");
			System.out.print("大小为：" + Math.round(Double.valueOf(image.size()) / 1000000) + "MB");
			System.out.println();*/
		}
		docker.close();
		return imagelocals;
	}
	
	public static List<Imagelocal> refreshImages() throws DockerCertificateException, DockerException, InterruptedException{
		DockerClient docker = DefaultDockerClient.fromEnv().build();
		List<Imagelocal> imagelocals =new ArrayList<>(); 
		List<Image> images = docker.listImages();
		String imageName = null;
		for (Image image : images) {
			imageName = image.repoTags().toArray()[0].toString();
			ImageInfo imageInfo = docker.inspectImage(imageName);
			Imagelocal imagelocal = new Imagelocal();
			imagelocal.setIname(imageName);
			imagelocal.setCreatedtime(imageInfo.created());
			if (imageInfo.containerConfig().exposedPorts() != null) {
				imagelocal.setPorts(imageInfo.containerConfig().exposedPorts().toString());
			}
			imagelocal.setImageid(imageInfo.id().split(":")[1]);
			imagelocal.setSize( Math.round(Double.valueOf(image.size()) / 1000000) + "MB");
			imagelocals.add(imagelocal);
			//System.out.println(imagelocal);
			//System.out.println(imageName+"\t" + imageInfo.id() + "\t" + imageInfo.containerConfig().exposedPorts() + "\t" + imageInfo.created());
		}
		docker.close();
		return imagelocals;
	}
	
	/**  
	* @Title: pullImage  
	* @Description: pull image from IP in imageLocation.properties
	* @param imageName
	* @return void     
	*/  
	public static void pullImage(String imageName) throws DockerCertificateException, IOException, DockerException, InterruptedException {
		Properties properties=new Properties();
		properties.load(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("imagelocation.properties"));
		String imageRep = properties.getProperty("locationIP");
		String port = properties.getProperty("port");
		DockerClient docker = DefaultDockerClient.fromEnv().build();
		String imagePath = imageRep +":"+ port +"/"+imageName;
		System.out.println(imageRep);
		System.out.println(imagePath);
		docker.pull(imagePath);
		docker.close();
	}
	
	public static void removeImage(String imageName) throws DockerCertificateException, IOException, DockerException, InterruptedException {
		DockerClient docker = DefaultDockerClient.fromEnv().build();
		docker.removeImage(imageName);
		docker.close();
	}	
	public static void runImage(String imageName,List<String> ports) throws DockerCertificateException {
		DockerClient docker = DefaultDockerClient.fromEnv().build();
		
		docker.close();
	}
	

	
	public static void run(String imageName) throws DockerCertificateException {
		DockerClient docker = DefaultDockerClient.fromEnv().build();
		
		docker.close();
	}
}
