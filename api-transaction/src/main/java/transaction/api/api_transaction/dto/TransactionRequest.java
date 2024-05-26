package transaction.api.api_transaction.dto;

import java.math.BigDecimal;

public record TransactionRequest(
    String userDocument,
    String tokenCard,
    BigDecimal transactionValue
) {
    
}
