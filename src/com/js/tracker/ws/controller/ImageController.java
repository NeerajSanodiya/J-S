package com.js.tracker.ws.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.js.tracker.ws.dao.ImageDAO;
import com.js.tracker.ws.dto.ImageDTO;
import com.js.tracker.ws.util.JsonResponse;

public class ImageController {
	public String deleteImages(HttpServletRequest request,
			HttpServletResponse response, List<ImageDTO> imageDTOs) {
		String ret = "error";
		String val = request.getRealPath("\\");
		List<String> idList = new ArrayList<String>();
		for (ImageDTO dto : imageDTOs) {
			File file = new File(val, dto.getFpath());
			if (file.exists()) {
				try {
					file.delete();
					idList.add(dto.getId());
				} catch (Exception e) {

				}
			} else {
				idList.add(dto.getId());
			}
		}
		try{
			ret = new ImageDAO().deleteImages(idList);
		}catch (Exception e) {}
		
		return ret;
	}

	public void uploadDone(HttpServletRequest request,
			HttpServletResponse response) {
		String retJsonStrong = new JsonResponse(false, "error.", "").getJson();

		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(
				diskFileItemFactory);
		ImageDTO dto = new ImageDTO();
		try {
			if (ServletFileUpload.isMultipartContent(request)) {
				List list = servletFileUpload.parseRequest(request);
				Iterator i = list.iterator();

				while (i.hasNext()) {
					FileItem fi = (FileItem) i.next();

					if (fi.isFormField()) {
						String fieldName = fi.getFieldName();
						String fieldValue = fi.getString();
						if (fieldName.equalsIgnoreCase("username")) {
							dto.setUsername(fieldValue);
						}
						if (fieldName.equalsIgnoreCase("c_date")) {
							dto.setC_date(fieldValue);
						}
						if (fieldName.equalsIgnoreCase("c_time")) {
							dto.setC_time(fieldValue);
						}
						if (fieldName.equalsIgnoreCase("ret_path")) {
							dto.setRet_path(fieldValue);
						}

					} else {
						String val = request.getRealPath("\\");
						String filename = fi.getName();
						File file = new File(val + "trackerimages");
						file.mkdirs();
						File imageFile = new File(file, filename);
						fi.write(imageFile);
						dto.setFpath("trackerimages/" + filename);
					}
				}
				ImageDTO imageDTO = new ImageDTO();
				imageDTO.setRet_path(dto.getRet_path());
				int ret = new ImageDAO().saveImageData(dto);
				if (ret == 1) {
					retJsonStrong = new JsonResponse(true, "", imageDTO)
							.getJson();
				} else {
					retJsonStrong = new JsonResponse(false, "error.", "")
							.getJson();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			retJsonStrong = new JsonResponse(false, "error.", "").getJson();
			return;
		}
		try {

			response.getWriter().print(retJsonStrong);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
