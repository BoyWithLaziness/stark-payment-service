package stark.payment_service.enums;

public enum LedgerEventType {
    PAYMENT_CREATED,
    ORDER_CREATED,
    SIGNATURE_VERIFIED,
    SIGNATURE_FAILED,
    PAYMENT_SUCCESS,
    PAYMENT_FAILED,
    PAYMENT_EXPIRED
}
