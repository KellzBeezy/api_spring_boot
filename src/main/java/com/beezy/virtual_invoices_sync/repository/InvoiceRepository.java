package com.beezy.virtual_invoices_sync.repository;

import com.beezy.virtual_invoices_sync.model.Invoice;
import com.beezy.virtual_invoices_sync.model.composte.InvoiceNoDeviceId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, InvoiceNoDeviceId> {

    Invoice getInvoiceByInvoiceNo(String invoiceNo);

    Page<Invoice> findAll(Pageable pageable);

    Page<Invoice> findByDeviceId(Pageable page,String deviceId);

    Optional<Invoice> findById(InvoiceNoDeviceId newId);

    Invoice findByDeviceIdAndInvoiceNo(String deviceId, String invoiceNo);

//    @Query("SELECT o FROM invoice o WHERE o.supplierData.supplierTIN = :supplierTin")
//    Optional<Invoice> findBySupplierTin(String supplierTin);

}
