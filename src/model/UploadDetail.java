package model;

import java.io.Serializable;

public class UploadDetail implements Serializable 
{
	    long fileSize;
		String fileName,fileType,uploadStatus;
	   
		public String getUploadStatus() {
			return uploadStatus;
		}
		public void setUploadStatus(String uploadStatus) {
			this.uploadStatus = uploadStatus;
		}
		public String getFileType() 
	    {
			return fileType;
		}
		public void setFileType(String fileType) {
			this.fileType = fileType;
		}
		public String getFileName() 
	    {
	    	return fileName;
	    }
	    public void setFileName(String fileName) 
	    {
	    	this.fileName = fileName;
	    }
		public long getFileSize() {
			return fileSize;
		}
		public void setFileSize(long fileSize) {
			this.fileSize = fileSize;
		}
}
