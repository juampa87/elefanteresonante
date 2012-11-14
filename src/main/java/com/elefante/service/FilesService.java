package com.elefante.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FilesService {

	void savePhoto(MultipartFile photo, String fileName) throws IOException;

	Boolean deletePhoto(String photoName) throws IOException;

	Boolean checkIfExists(String photoName);

}
