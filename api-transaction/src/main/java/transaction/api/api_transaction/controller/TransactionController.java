package transaction.api.api_transaction.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import transaction.api.api_transaction.dto.TransactionRequest;
import transaction.api.api_transaction.service.TransactionService;


@RestController
@RequestMapping("/transaction")
public class TransactionController {
    
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/create")
    public void save(@RequestBody TransactionRequest request) {
        transactionService.create(request);
    }

    @GetMapping("/list")
    public ResponseEntity<?> findAll(@RequestParam(name = "page", defaultValue = "0") Integer page,
    @RequestParam(name = "size", defaultValue = "10") Integer size) {
        var response = transactionService.findAll(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    

    
}
