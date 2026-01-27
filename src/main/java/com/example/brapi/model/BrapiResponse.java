package com.example.brapi.model;

import java.util.ArrayList;
import java.util.List;

public class BrapiResponse<T> {
    private Metadata metadata = new Metadata();
    private T result;

    public BrapiResponse() {
    }

    public BrapiResponse(T result) {
        this.result = result;
        this.metadata = new Metadata();
    }

    public BrapiResponse(Metadata metadata, T result) {
        this.metadata = metadata;
        this.result = result;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public static class Metadata {
        private List<Status> status = new ArrayList<>();
        private Pagination pagination;
        private List<DataFile> datafiles = new ArrayList<>();

        public Metadata() {
        }

        public Metadata(List<Status> status, Pagination pagination, List<DataFile> datafiles) {
            this.status = status;
            this.pagination = pagination;
            this.datafiles = datafiles;
        }

        public List<Status> getStatus() {
            return status;
        }

        public void setStatus(List<Status> status) {
            this.status = status;
        }

        public Pagination getPagination() {
            return pagination;
        }

        public void setPagination(Pagination pagination) {
            this.pagination = pagination;
        }

        public List<DataFile> getDatafiles() {
            return datafiles;
        }

        public void setDatafiles(List<DataFile> datafiles) {
            this.datafiles = datafiles;
        }
    }

    public static class Status {
        private String message;
        private String messageType;

        public Status() {
        }

        public Status(String message, String messageType) {
            this.message = message;
            this.messageType = messageType;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMessageType() {
            return messageType;
        }

        public void setMessageType(String messageType) {
            this.messageType = messageType;
        }
    }

    public static class Pagination {
        private Integer currentPage;
        private Integer pageSize;
        private Integer totalCount;
        private Integer totalPages;

        public Pagination() {
        }

        public Pagination(Integer currentPage, Integer pageSize, Integer totalCount, Integer totalPages) {
            this.currentPage = currentPage;
            this.pageSize = pageSize;
            this.totalCount = totalCount;
            this.totalPages = totalPages;
        }

        public Integer getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public Integer getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }
    }

    public static class DataFile {
        private String fileDescription;
        private String fileName;
        private String fileSize;
        private String fileType;
        private String fileURL;

        public DataFile() {
        }

        public DataFile(String fileDescription, String fileName, String fileSize, String fileType, String fileURL) {
            this.fileDescription = fileDescription;
            this.fileName = fileName;
            this.fileSize = fileSize;
            this.fileType = fileType;
            this.fileURL = fileURL;
        }

        public String getFileDescription() {
            return fileDescription;
        }

        public void setFileDescription(String fileDescription) {
            this.fileDescription = fileDescription;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFileSize() {
            return fileSize;
        }

        public void setFileSize(String fileSize) {
            this.fileSize = fileSize;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        public String getFileURL() {
            return fileURL;
        }

        public void setFileURL(String fileURL) {
            this.fileURL = fileURL;
        }
    }
}