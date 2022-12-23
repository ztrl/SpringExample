package com.coderby.myapp.upload.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.coderby.myapp.upload.model.UploadFileVO;

@Repository
public class UploadFileRepository implements IUploadFileRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class UploadFileMapper implements RowMapper<UploadFileVO> {
		private int[] excludeIndex = {1, 1, 1, 1, 1, 1, 1};
		
		public UploadFileMapper() {}
		public UploadFileMapper(int[] excludeIndex) {
			this.excludeIndex = excludeIndex;
		}
		
		@Override
		public UploadFileVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UploadFileVO uploadFile = new UploadFileVO();
			if (excludeIndex[0] == 1) {
				uploadFile.setFileId(rs.getInt("fileId"));				
			}
			if (excludeIndex[1] == 1) {
				uploadFile.setDirectoryName(rs.getString("directoryName"));
			}
			if (excludeIndex[2] == 1) {
				uploadFile.setFileName(rs.getString("fileName"));
			}
			if (excludeIndex[3] == 1) {
				uploadFile.setFileSize(rs.getLong("fileSize"));
			}
			if (excludeIndex[4] == 1) {
				uploadFile.setFileContentType(rs.getString("fileContentType"));
			}
			if (excludeIndex[5] == 1) {
				uploadFile.setFileUploadDate(rs.getTimestamp("fileUploadDate"));
			}
			if (excludeIndex[6] == 1) {
				uploadFile.setFileData(rs.getBytes("fileData"));				
			}
			return uploadFile;
		}
	}

	@Override
	public int getMaxFileId() {
		String sql = "SELECT NVL(MAX(file_id), 0) FROM upload_file";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void uploadFile(UploadFileVO file) {
		String sql = "INSERT INTO upload_file "
					+" (file_id, directory_name, file_name, file_size, "
					+" file_content_type, file_upload_date, file_data) "
					+" VALUES (?, ? ,?, ?, ?, SYSTIMESTAMP, ?)";
		jdbcTemplate.update(sql, 
				file.getFileId(), 
				file.getDirectoryName(), 
				file.getFileName(), 
				file.getFileSize(), 
				file.getFileContentType(),
				file.getFileData());
	}

	@Override
	public List<UploadFileVO> getFileList(String directoryName) {
		String sql = "SELECT "
					+" FILE_ID AS fileId, "
					+" DIRECTORY_NAME AS directoryName, "
					+" FILE_NAME AS fileName, "
					+" FILE_SIZE AS fileSize, "
					+" FILE_CONTENT_TYPE AS fileContentType, "
					+" FILE_UPLOAD_DATE AS fileUploadDate "
					+" FROM UPLOAD_FILE "
					+" WHERE DIRECTORY_NAME = ? "
					+" ORDER BY FILE_UPLOAD_DATE DESC ";
		return jdbcTemplate.query(sql, new UploadFileMapper(new int[] {1, 1, 1, 1, 1, 1, 0}), directoryName);
	}

	@Override
	public List<UploadFileVO> getAllFileList() {
		String sql = "SELECT "
				+" FILE_ID				As fileId, "
				+" DIRECTORY_NAME		As directoryName, "
				+" FILE_NAME			As fileName, "
				+" FILE_SIZE			As fileSize, "
				+" FILE_CONTENT_TYPE	As fileContentType, "
				+" FILE_UPLOAD_DATE		As fileUploadDate "
				+" FROM UPLOAD_FILE "
				+" ORDER BY FILE_UPLOAD_DATE DESC ";
		return jdbcTemplate.query(sql, new UploadFileMapper(new int[] {1, 1, 1, 1, 1, 1, 0}));
	}

	@Override
	public List<UploadFileVO> getImageList(String directoryName) {
		String sql = "SELECT "
				+" FILE_ID				As fileId, "
				+" DIRECTORY_NAME		As directoryName, "
				+" FILE_NAME			As fileName, "
				+" FILE_SIZE			As fileSize, "
				+" FILE_CONTENT_TYPE	As fileContentType, "
				+" FILE_UPLOAD_DATE		As fileUploadDate, "
				+" FILE_DATA			As fileData "
				+" FROM UPLOAD_FILE "
				+" WHERE DIRECTORY_NAME = ? "
				+" ORDER BY FILE_UPLOAD_DATE DESC ";
		return jdbcTemplate.query(sql, new UploadFileMapper(), directoryName);
	}

	@Override
	public UploadFileVO getFile(int fileId) {
		String sql = "SELECT "
				+" FILE_ID				As fileId, "
				+" DIRECTORY_NAME		As directoryName, "
				+" FILE_NAME			As fileName, "
				+" FILE_SIZE			As fileSize, "
				+" FILE_CONTENT_TYPE	As fileContentType, "
				+" FILE_DATA			As fileData "	
				+" FROM UPLOAD_FILE "
				+" WHERE FILE_ID = ? ";
		return jdbcTemplate.queryForObject(sql, new UploadFileMapper(new int[] {1, 1, 1, 1, 1, 0, 1}), fileId);
	}

	@Override
	public String getDirectoryName(int fileId) {
		String sql = "SELECT DIRECTORY_NAME FROM UPLOAD_FILE "
					+"WHERE FILE_ID = ? ";
		return jdbcTemplate.queryForObject(sql, String.class, fileId);
	}

	@Override
	public void updateDirectory(HashMap<String, Object> map) {
		String sql = "UPDATE UPLOAD_FILE "
					+" SET DIRECTORY_NAME = ? "
					+" WHERE FILE_ID = ? ";
		jdbcTemplate.update(sql, map.get("directoryName"), map.get("fileId"));
	}

	@Override
	public void deleteFile(int fileId) {
		String sql = "DELETE FROM UPLOAD_FILE WHERE FILE_ID = ? ";
		jdbcTemplate.update(sql, fileId);
	}

	@Override
	public void updateFile(UploadFileVO file) {
		String sql = "UPDATE UPLOAD_FILE SET "
					+"DIRECTORY_NAME = ?, "
					+"FILE_NAME = ?, "
					+"FILE_SIZE = ?, "
					+"FILE_CONTENT_TYPE = ?, "
					+"FILE_DATA = ?, "
					+"WHERE FILE_ID = ? ";
		jdbcTemplate.update(sql,
				file.getDirectoryName(),
				file.getFileName(),
				file.getFileSize(),
				file.getFileContentType(),
				file.getFileData(),
				file.getFileId());
	}

}
