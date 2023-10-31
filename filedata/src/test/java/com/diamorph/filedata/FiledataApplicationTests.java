package com.diamorph.filedata;

import com.diamorph.filedata.entities.Image;
import com.diamorph.filedata.repository.ImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.Optional;

@SpringBootTest
class FiledataApplicationTests {

	@Autowired
	ImageRepository imageRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testImageSave() throws IOException {
		Image image = new Image();
		image.setName("image_1.jpeg");

		File file = new File("/Users/diamorph/Desktop/Courses/Java-Spring/Java Spring Framework/filedata/src/main/resources/image_1.jpg");
		byte[] fileContent = new byte[(int) file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(fileContent);

		image.setData(fileContent);

		imageRepository.save(image);
		inputStream.close();
	}

	@Test
	public void testReadImage() {
		Image image = imageRepository.findById(1L).get();
		File file = new File("/Users/diamorph/Pictures/" + image.getName());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(image.getData());
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
			try {
				fos.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
    }

}
