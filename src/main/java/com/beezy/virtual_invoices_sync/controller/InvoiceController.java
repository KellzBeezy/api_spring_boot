package com.beezy.virtual_invoices_sync.controller;

import com.beezy.virtual_invoices_sync.dto.*;
import com.beezy.virtual_invoices_sync.model.Invoice;
import com.beezy.virtual_invoices_sync.repository.InvoiceRepository;
import com.beezy.virtual_invoices_sync.service.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
//    private final InvoiceRepository repository;
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceRepository repository, InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
//        this.repository = repository;
    }

// @RequestBody Invoice invoice
@Operation(
        summary = "Create a new invoice",
        description = "Creates a new invoice in the system",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Invoice data to create",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = InvoiceRequest.class)
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Invoice created successfully",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ApiResponses.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Invalid input provided",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ApiResponses.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "Internal Server Error",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ApiResponses.class)
                        )
                )
        }
)
@PostMapping("/sync")
public ResponseEntity<?> syncInvoice(@Valid @RequestBody ReceiptBody invoice) {
    Invoice createdInvoice = null;

    if(invoice.getReceipt().supplierData() == null){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponses<>(false, "Invoice Supplier Data cannot be null", null));
    }
    if (invoice.getReceipt().invoiceNo() == null ||
            invoice.getReceipt().invoiceNo().isBlank()) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponses<>(false, "Invoice Number cannot be null or blank.", null));
    }
    if (invoice.getReceipt().receiptGlobalNo() == null ||
            invoice.getReceipt().receiptGlobalNo()==0) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponses<>(false, "Receipt Global Number cannot be null or zero(0).", null));
    }
    if (invoice.getReceipt().receiptCounter() == null ||
            invoice.getReceipt().receiptCounter()==0) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponses<>(false, "Receipt Counter Number cannot be null or zero(0).", null));
    }
    if (invoice.getReceipt().receiptCurrency() == null ||
            invoice.getReceipt().receiptCurrency().isBlank()) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponses<>(false, "Receipt Currency cannot be null or blank.", null));
    }

    return invoiceService.createInvoice(invoice);
}

    @Operation(
            summary = "Get All Invoices",
            description = "Fetches all invoices from the system",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully fetched invoices",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiResponsesGet.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Invoices not found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiResponses.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiResponses.class)
                            )
                    )
            }
    )
    @GetMapping
    public ResponseEntity<ApiResponses<PageResponse<Invoice>>> getInvoices(
            @RequestParam(defaultValue = "0") int page,       // Page number (default: 0)
            @RequestParam(defaultValue = "10") int size,      // Page size (default: 10)
            @RequestParam(defaultValue = "invoiceNo") String sortBy, // Sort field (default: "id")
            @RequestParam(defaultValue = "asc") String sortOrder // Sort order (default: "asc")
    ) {
        // Create a Pageable object based on the request parameters
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortOrder.equalsIgnoreCase("asc") ? Sort.Order.asc(sortBy) : Sort.Order.desc(sortBy)));

        // Get the paginated result from the service
        Page<Invoice> invoicePage = invoiceService.getAllInvoices(pageable);

        // Check if the result is empty
        if (invoicePage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponses<>(false, "No invoices found",  new PageResponse<>(invoicePage)));
        }

        // Return paginated response
        return ResponseEntity.ok(new ApiResponses<>(true, "Invoices retrieved successfully", new PageResponse<>(invoicePage)));
    }

//    @GetMapping("/tasks")
//    public PageResponse<Invoice> getTasks(  @RequestParam(defaultValue = "0") int page,       // Page number (default: 0)
//                                            @RequestParam(defaultValue = "10") int size,      // Page size (default: 10)
//                                            @RequestParam(defaultValue = "invoiceNo") String sortBy, // Sort field (default: "id")
//                                            @RequestParam(defaultValue = "asc") String sortOrder // Sort order (default: "asc")
//    ) {
//        // Create a Pageable object based on the request parameters
//        Pageable pageable = PageRequest.of(page, size, Sort.by(sortOrder.equalsIgnoreCase("asc") ? Sort.Order.asc(sortBy) : Sort.Order.desc(sortBy)));
//
//        return new PageResponse<>(invoiceService.getAllInvoices(pageable));
//    }


    @GetMapping("/{invoiceNo}")
    public ResponseEntity<ApiResponses<Invoice>> getInvoices(@PathVariable String invoiceNo) {
        Invoice invoices = invoiceService.getInvoiceByInvoiceNo(invoiceNo);

        if (invoices == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponses<>(false, "No invoices found", null));
        }

        return ResponseEntity.ok(new ApiResponses<>(true, "Invoices retrieved successfully", invoices));

    }

}
