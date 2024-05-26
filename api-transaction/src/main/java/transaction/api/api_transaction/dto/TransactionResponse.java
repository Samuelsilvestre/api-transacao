package transaction.api.api_transaction.dto;

import java.math.BigDecimal;

import transaction.api.api_transaction.entity.TransactionModel;

public record TransactionResponse(
    String userDocument,
    String TokenCard,
    BigDecimal value
) {

    public static TransactionResponse toResponse(TransactionModel model) {
        return new TransactionResponse(model.getUserDocument(), model.getTokenCard(), model.getTransactionValue());
    }
    
}
