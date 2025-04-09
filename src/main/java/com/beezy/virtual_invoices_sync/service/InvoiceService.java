package com.beezy.virtual_invoices_sync.service;

import com.beezy.virtual_invoices_sync.dto.ApiResponses;
import com.beezy.virtual_invoices_sync.dto.ReceiptBody;
import com.beezy.virtual_invoices_sync.model.Invoice;
import com.beezy.virtual_invoices_sync.model.composte.InvoiceNoDeviceId;
import com.beezy.virtual_invoices_sync.repository.InvoiceRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public ResponseEntity<ApiResponses<Invoice>> createInvoice(ReceiptBody invoiceRequest){

        try{
            Invoice invoice = new Invoice();

            InvoiceNoDeviceId newId = new InvoiceNoDeviceId(invoiceRequest.getReceipt().deviceId(), invoiceRequest.getReceipt().invoiceNo());

            Optional<Invoice> existingInvoice = invoiceRepository.findById(newId);

            if (existingInvoice.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ApiResponses<>(false, "Invoice with the same Device ID and Invoice Number already exists!", null));

            }

            invoice.setId(newId);
            invoice.setInvoiceNo(invoiceRequest.getReceipt().invoiceNo());
            invoice.setBuyerData(invoiceRequest.getReceipt().buyerData());
            invoice.setCreditDebitNote(invoiceRequest.getReceipt().creditDebitNote());
            invoice.setDeviceId(invoiceRequest.getReceipt().deviceId());
            invoice.setReceiptCounter(invoiceRequest.getReceipt().receiptCounter());
            invoice.setReceiptCurrency(invoiceRequest.getReceipt().receiptCurrency());
            invoice.setReceiptDate(invoiceRequest.getReceipt().receiptDate());
            invoice.setReceiptDeviceSignature(invoiceRequest.getReceipt().receiptDeviceSignature());
            invoice.setReceiptGlobalNo(invoiceRequest.getReceipt().receiptGlobalNo());
            invoice.setReceiptLines(invoiceRequest.getReceipt().receiptLines());
            invoice.setReceiptLinesTaxInclusive(invoiceRequest.getReceipt().receiptLinesTaxInclusive());
            invoice.setReceiptPayments(invoiceRequest.getReceipt().receiptPayments());
            invoice.setReceiptNotes(invoiceRequest.getReceipt().receiptNotes());
            invoice.setReceiptPrintForm(invoiceRequest.getReceipt().receiptPrintForm());
            invoice.setReceiptTaxes(invoiceRequest.getReceipt().receiptTaxes());
            invoice.setReceiptTotal(invoiceRequest.getReceipt().receiptTotal());
            invoice.setSupplierData(invoiceRequest.getReceipt().supplierData());
            invoice.setReceiptPayments(invoiceRequest.getReceipt().receiptPayments());
            invoice.setReceiptType(invoiceRequest.getReceipt().receiptType());
            invoice.setReceiptVerification(invoiceRequest.getReceipt().receiptVerification());

            Invoice savedInvoice = invoiceRepository.save(invoice);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponses<>(true, "Invoice saved successfully", savedInvoice));
        }catch (DataIntegrityViolationException e) {
//            logger.error("Duplicate entry error: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponses<>(false, "Invoice already exists. Duplicate entry detected.", null));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponses<>(false, "Invoice failed to save: "+e.getMessage(), null));
        }
    }

    public Invoice getInvoiceByDeviceIdAndInvoiceNumber(String deviceId, String invoiceNumber) {
        return invoiceRepository.findByDeviceIdAndInvoiceNo(deviceId, invoiceNumber);
    }

    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }
    public Page<Invoice> getAllInvoices(Pageable pageable) {
        return invoiceRepository.findAll(pageable);
    }

    public Invoice getInvoiceByInvoiceNo(String invoiceNo){
        return invoiceRepository.getInvoiceByInvoiceNo(invoiceNo);
    }

    public Page<Invoice> findByDeviceId(String deviceId, Pageable pageable){
        return invoiceRepository.findByDeviceId( pageable, deviceId);
    }
}
