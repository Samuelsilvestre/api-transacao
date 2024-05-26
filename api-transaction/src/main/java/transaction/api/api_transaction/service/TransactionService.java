package transaction.api.api_transaction.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import transaction.api.api_transaction.dto.TransactionRequest;
import transaction.api.api_transaction.dto.TransactionResponse;
import transaction.api.api_transaction.entity.TransactionModel;
import transaction.api.api_transaction.repository.TransactionRepository;

@Service
public class TransactionService {
    
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void create(TransactionRequest request) {
        var model = new TransactionModel();
        model.setUserDocument(request.userDocument());
        model.setTokenCard(request.tokenCard());
        model.setTransactionValue(request.transactionValue());
        transactionRepository.save(model);
    }

    public Page<TransactionResponse> findAll(int page, int size) {
        var transactions = transactionRepository.findAll(PageRequest.of(page, size));
        return transactions.map(TransactionResponse::toResponse);
    }
}
