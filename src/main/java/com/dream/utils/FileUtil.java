package com.dream.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static Boolean createAlbum(String albumPath) {
		try {
			File albumFile = new File(albumPath);
			if(!albumFile.exists()) {
				albumFile.mkdirs();
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	
    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成新的文件名
     * @param fileOriginName 源文件名
     * @return
     */
    public static String getFileName(String fileOriginName){
		return UUIDUtils.getUUID() + getSuffix(fileOriginName);
    }
    
    /**
    *
    * @param file 文件
    * @param path 文件存放路径
    * @param fileName 源文件名
    * @return
    */
   public static boolean upload(MultipartFile file, String path, String fileName){
       // 生成新的文件名
       //String realPath = path + "/" + FileNameUtils.getFileName(fileName);
       //使用原文件名
       String realPath = path + "/" + fileName;
       File dest = new File(realPath);
       //判断文件父目录是否存在
       if(!dest.getParentFile().exists()){
           dest.getParentFile().mkdir();
       }

       try {
           file.transferTo(dest);
           return true;
       } catch (IllegalStateException e) {
           e.printStackTrace();
           return false;
       } catch (IOException e) {
           e.printStackTrace();
           return false;
       }

   }
}
