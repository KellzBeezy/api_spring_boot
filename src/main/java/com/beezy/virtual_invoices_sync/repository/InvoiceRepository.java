package com.beezy.virtual_invoices_sync.repository;

import com.beezy.virtual_invoices_sync.model.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Invoice getInvoiceByInvoiceNo(String invoiceNo);

    Page<Invoice> findAll(Pageable pageable);
}
