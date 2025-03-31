package com.beezy.virtual_invoices_sync.dto;

import com.beezy.virtual_invoices_sync.model.Invoice;
import org.springframework.data.domain.Page;

import java.util.List;

public class PageResponse<T> {

    private List<Invoice> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;

    public PageResponse(Page<Invoice> page) {
        this.content = page.getContent();
        this.page = page.getNumber();
        this.size = page.getSize();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }

    public List<Invoice> getContent() {
        return content;
    }

    public void setContent(List<Invoice> content) {
        this.content = content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
