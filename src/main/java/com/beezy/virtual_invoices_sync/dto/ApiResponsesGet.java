package com.beezy.virtual_invoices_sync.dto;

public class ApiResponsesGet <T>{

        private boolean success;
        private String message;
        private PageResponse<T> data;

        public ApiResponsesGet(boolean success, String message,  PageResponse<T> data) {
            this.success = success;
            this.message = message;
            this.data = data;
        }

        // Getters and Setters
        public boolean isSuccess() { return success; }
        public void setSuccess(boolean success) { this.success = success; }

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }

        public PageResponse<T> getData() { return data; }
        public void setData(PageResponse<T> data) { this.data = data; }


}
