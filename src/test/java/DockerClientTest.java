import org.junit.Test;

import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import util.DockerClientUtil;

public class DockerClientTest {

	@Test
	public void testSubtract() {
		try {
			DockerClientUtil.listImages();
		} catch (DockerCertificateException e) {
			e.printStackTrace();
		} catch (DockerException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test01() throws DockerCertificateException, DockerException, InterruptedException {
		try {
			DockerClientUtil.listImages();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test02() throws DockerCertificateException, DockerException, InterruptedException {
        System.out.println("1111");
	}


}
