package transaction.api.api_transaction.entity;

import jakarta.persistence.*;
import transaction.api.api_transaction.service.EncryptorService;

import java.math.BigDecimal;
import java.util.UUID;

import org.aspectj.apache.bcel.generic.RET;


@Entity
@Table(name = "tb_transacao")
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "documento_usuario")
    private String encryptUserDocument;
    
    @Column(name = "valor_transacao")
    private BigDecimal transactionValue;

    @Column(name = "token_cartao")
    private String encryptTokenCard;

    @Transient
    private String userDocument;

    @Transient
    private String tokenCard;

    

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEncryptUserDocument() {
        return encryptUserDocument;
    }

    public void setEncryptUserDocument(String encryptUserDocument) {
        this.encryptUserDocument = encryptUserDocument;
    }

    public BigDecimal getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(BigDecimal transactionValue) {
        this.transactionValue = transactionValue;
    }

    public String getEncryptTokenCard() {
        return encryptTokenCard;
    }

    public void setEncryptTokenCard(String encryptTokenCard) {
        this.encryptTokenCard = encryptTokenCard;
    }

    public String getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(String userDocument) {
        this.userDocument = userDocument;
    }

    public String getTokenCard() {
        return tokenCard;
    }

    public void setTokenCard(String tokenCard) {
        this.tokenCard = tokenCard;
    }

    @PrePersist
    public void prePersist() {
        this.encryptUserDocument = EncryptorService.encrypt(userDocument);
        this.encryptTokenCard = EncryptorService.encrypt(tokenCard);
    }

    @PostLoad
    public void postLoad() {
        this.userDocument = EncryptorService.decrypt(encryptTokenCard);
        this.tokenCard = EncryptorService.decrypt(encryptTokenCard);
    }
}
