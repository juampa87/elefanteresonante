package com.elefante.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Transactional(rollbackFor = Exception.class)
public class FilesServiceImpl implements FilesService {

	protected static Logger logger = Logger.getLogger("service");
	private String filesPath;
	private static String photoFolder = "photos/";

	public void savePhoto(MultipartFile photo, String fileName)
			throws IOException {
		logger.debug("Saving photo for user");

		String fullPath = this.filesPath + photoFolder + fileName;
		File file = new File(fullPath);
		FileUtils.writeByteArrayToFile(file, photo.getBytes());

		logger.info("Logo saved OK in: " + fullPath);
	}

	public Boolean deletePhoto(String photoName) throws IOException {
		String fullPath = this.filesPath + photoFolder + photoName;
		File file = new File(fullPath);
		boolean success = file.delete();
		if (!success) {
			logger.error("Error deleting photo: ");
			throw new IOException();
		}
		return success;
	}

	public Boolean checkIfExists(String photoName) {
		String fullPath = this.filesPath + photoFolder + photoName;
		File f = new File(fullPath);
		return f.exists();
	}

	@Required
	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}

}
